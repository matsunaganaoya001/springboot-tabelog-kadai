package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Store;

//public interface StoreRepository extends JpaRepository<Store, Integer>{ 
	public interface StoreRepository extends JpaRepository<Store, Integer> {
	
	public Page<Store> findByNameLike(String keyword, Pageable pageable);
	

    public Page<Store> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword, Pageable pageable);  
    public Page<Store> findByNameLikeOrAddressLikeOrderByPriceLowAsc(String nameKeyword, String addressKeyword, Pageable pageable);  
    public Page<Store> findByAddressLikeOrderByCreatedAtDesc(String area, Pageable pageable);
    public Page<Store> findByAddressLikeOrderByPriceLowAsc(String area, Pageable pageable);
    public Page<Store> findByPriceLowLessThanEqualOrderByCreatedAtDesc(Integer PriceLow, Pageable pageable);
    public Page<Store> findByPriceLowLessThanEqualOrderByPriceLowAsc(Integer PriceLow, Pageable pageable); 
    public Page<Store> findAllByOrderByCreatedAtDesc(Pageable pageable);
    public Page<Store> findAllByOrderByPriceLowAsc(Pageable pageable); 
    
    public List<Store> findTop10ByOrderByCreatedAtDesc();
    
}
