package com.example.nagoyameshi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.service.ReviewService;

@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public ReviewController(ReviewService reviewService, StoreRepository storeRepository, UserRepository userRepository) {
        this.reviewService = reviewService;
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/stores/{storeId}/reviews")
    public String showReviews(@PathVariable Integer storeId, Model model) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("Invalid store Id:" + storeId));
        model.addAttribute("store", store);
        // 他の必要なデータを追加
        return "stores/reviews";
    }

    @PostMapping("/stores/{storeId}/reviews")
    public String postReview(@PathVariable Integer storeId, @RequestParam String reviewText, @RequestParam int rating, RedirectAttributes redirectAttributes) {
        User user = getAuthenticatedUser();
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("Invalid store Id:" + storeId));
        reviewService.postReview(user, store, reviewText, rating);
        redirectAttributes.addFlashAttribute("message", "レビューを投稿しました");
        return "redirect:/stores/" + storeId + "/reviews";
    }

    @PostMapping("/stores/{storeId}/reviews/{reviewId}/delete")
    public String deleteReview(@PathVariable Integer storeId, @PathVariable Long reviewId, RedirectAttributes redirectAttributes) {
        User user = getAuthenticatedUser();
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("Invalid store Id:" + storeId));
        reviewService.deleteReview(user, store); // レビューIDを追加
        redirectAttributes.addFlashAttribute("message", "レビューを削除しました");
        return "redirect:/stores/" + storeId + "/reviews";
    }
    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            return userRepository.findByName(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        } else {
            throw new IllegalStateException("User not authenticated");
        }
    }
}