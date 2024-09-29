package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.service.FavoriteService;
import com.example.nagoyameshi.service.ReviewService;
import com.example.nagoyameshi.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
    private final UserRepository userRepository;        
    private final UserService userService;
    private final FavoriteService favoriteService;
    private final ReviewService reviewService; 
    public AdminUserController(UserRepository userRepository ,UserService userService, FavoriteService favoriteService, ReviewService reviewService) {
        this.userRepository = userRepository;             
        this.userService = userService;
        this.favoriteService = favoriteService;
        this.reviewService = reviewService;
    }    
    
    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, Model model) {
        Page<User> userPage;
        
        if (keyword != null && !keyword.isEmpty()) {
            userPage = userRepository.findByNameLikeOrFuriganaLike("%" + keyword + "%", "%" + keyword + "%", pageable);                   
        } else {
            userPage = userRepository.findAll(pageable);
        }        
        
        model.addAttribute("userPage", userPage);        
        model.addAttribute("keyword", keyword);                
        
        return "admin/users/index";
    }
    
    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
        User user = userRepository.getReferenceById(id);
        
        model.addAttribute("user", user);
        
        return "admin/users/show";
    } 
    
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") Integer id ,RedirectAttributes redirectAttributes) {
        // 外部キー制約を削除
    	userService.dropForeignKeyFromFavorites();
        userService.dropForeignKeyConstraintFromReviews();
        
        // お気に入りから該当ユーザ情報を削除
//        favoriteService.removeFavoriteForUser(id);
        
        // レビューから該当ユーザ情報を削除
//        reviewService.deleteReviewForUserId(id);
        
        // ユーザを削除
        userService.delete(id);
        
        redirectAttributes.addFlashAttribute("successMessage", "会員情報を削除しました。");
        
        // リダイレクト        
        return "redirect:/admin/users";
    }
}
