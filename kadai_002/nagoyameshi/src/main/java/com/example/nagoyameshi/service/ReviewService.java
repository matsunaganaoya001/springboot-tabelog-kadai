package com.example.nagoyameshi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // レビューを投稿するメソッド
    public void postReview(User user, Store store, String reviewText, int rating) {
        Review review = new Review();
        review.setUser(user);
        review.setStore(store);
        review.setReviewText(reviewText);
        review.setRating(rating);
        reviewRepository.save(review);
    }

    // レビューを削除するメソッド
    public void deleteReview(User user, Store store) {
        Review review = reviewRepository.findByUserAndStore(user, store);
        if (review != null) {
            reviewRepository.delete(review);
        }
    }
    
//    // レビューを削除するメソッド
//    public void deleteReviewForUserId(Integer userId) {
//        reviewRepository.deleteByUserId(userId);
//    }

    // レビューが存在するかどうかを確認するメソッド
    public boolean hasReview(User user, Store store) {
        return reviewRepository.existsByUserAndStore(user, store);
    }
}
