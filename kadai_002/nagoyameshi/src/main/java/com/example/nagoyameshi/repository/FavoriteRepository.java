package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    boolean existsByUserAndStore(User user, Store store);

    Favorite findByUserAndStore(User user, Store store);
    
//    @Modifying
//    @Query("DELETE FROM Favorite e where e.user_id = :userId")
//    void deleteByUserId(Integer userId);
}