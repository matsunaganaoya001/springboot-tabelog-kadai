package com.example.nagoyameshi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int rating;

    @Column(name = "review_text")  // カラム名を「review_text」に合わせる
    private String reviewText;

    private LocalDateTime createdAt;

	public void setUser(User user2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setStore(Store store2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setReviewText(String reviewText2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setRating(int rating2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

    // Getters and setters
}
