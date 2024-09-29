package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.FavoriteRepository;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    // お気に入りを追加するメソッド
    @Transactional
    public void addFavorite(User user, Store store) {
        Favorite favorite = new Favorite(user, store);
        favoriteRepository.save(favorite);
    }

    // お気に入りを削除するメソッド
    @Transactional
    public void removeFavorite(User user, Store store) {
        Favorite favorite = favoriteRepository.findByUserAndStore(user, store);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        }
    }
    
    // お気に入りをユーザIDで削除するメソッド
//    @Transactional
//    public void removeFavoriteForUser(Integer userId) {
//        favoriteRepository.deleteByUserId(userId);
//    }
    

    // お気に入りが存在するかどうかを確認するメソッド
    public boolean hasFavorite(User user, Store store) {
        return favoriteRepository.existsByUserAndStore(user, store);
    }
}