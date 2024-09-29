package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    boolean existsByUserAndStore(User user, Store store);

    Review findByUserAndStore(User user, Store store);
//    void deleteByUserId(Integer userId);

	List<Review> findByStore(Store store);
}
