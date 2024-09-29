
package com.example.nagoyameshi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.UserEditForm;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.FavoriteService;
import com.example.nagoyameshi.service.ReviewService;
import com.example.nagoyameshi.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;    
    private final UserService userService;
    private final StoreRepository storeRepository;
 
    
    public UserController(UserRepository userRepository, UserService userService, StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.storeRepository = storeRepository;
        
    }    
    
    @GetMapping
    public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {         
        User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());  
        
        model.addAttribute("user", user);
        
        return "user/index";
    }
    @GetMapping("/edit")
    public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {        
        User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());  
        UserEditForm userEditForm = new UserEditForm(user.getId(), user.getName(), user.getFurigana(), user.getPostalCode(), user.getAddress(), user.getPhoneNumber(), user.getEmail());
        
        model.addAttribute("userEditForm", userEditForm);
        
        return "user/edit";
    }    
    
 // 1. パスワード再設定のリクエストを受け入れるエンドポイントを追加
    @GetMapping("/reset-password")
    public String showResetPasswordForm() {
        return "user/reset-password-form"; // パスワード再設定フォームのHTMLを返す
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated UserEditForm userEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // メールアドレスが変更されており、かつ登録済みであれば、BindingResultオブジェクトにエラー内容を追加する
        if (userService.isEmailChanged(userEditForm) && userService.isEmailRegistered(userEditForm.getEmail())) {
            FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済みのメールアドレスです。");
            bindingResult.addError(fieldError);                       
        }
        
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        
        userService.update(userEditForm);
        redirectAttributes.addFlashAttribute("successMessage", "会員情報を編集しました。");
        
        return "redirect:/user";
    }  

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
        // パスワード再設定の処理を実装し、成功した場合は成功メッセージをリダイレクト先に渡す
        // 失敗した場合はエラーメッセージをリダイレクト先に渡す
        // リダイレクト先は適宜決定してください
        return "redirect:/user/reset-password"; // パスワード再設定完了画面やリダイレクト先のURLを指定する
    }
 // 2. パスワード再設定のフォームを提供
 // パスワード再設定フォームのHTMLを作成し、必要な入力フィールドを含めます

 // 3. パスワード再設定の処理を実装
 // resetPasswordメソッド内で、パスワード再設定のロジックを実装します
    
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private ReviewService reviewService;

    // お気に入り追加エンドポイント
    @PostMapping("/favorite/add")
    public ResponseEntity<String> addFavorite(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
                                              @RequestParam("storeId") Integer storeId) {
        User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + storeId));
        favoriteService.addFavorite(user, store);
        return ResponseEntity.ok("お気に入りに追加しました。");
    }

    // お気に入り削除エンドポイント
    @PostMapping("/favorite/remove")
    public ResponseEntity<String> removeFavorite(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @RequestParam("storeId") Integer storeId) {
        User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + storeId));
        favoriteService.removeFavorite(user, store);
        return ResponseEntity.ok("お気に入りから削除しました。");
    }

    // レビュー投稿エンドポイント
    @PostMapping("/review/add")
    public ResponseEntity<String> addReview(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
                                            @RequestParam("storeId") Integer storeId,
                                            @RequestParam("reviewText") String reviewText, 
                                            @RequestParam("rating") int rating) {
        
        User user = userRepository.findById(userDetailsImpl.getUser().getId())
                      .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userDetailsImpl.getUser().getId()));
        
        Store store = storeRepository.findById(storeId)
                      .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + storeId));
        
        reviewService.postReview(user, store, reviewText, rating);

        return ResponseEntity.ok("レビューを投稿しました。");
    }


    
}