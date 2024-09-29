package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.form.ReservationInputForm;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.repository.StoreRepository;

@Controller
@RequestMapping("/stores")
public class StoreController {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;  // ReviewRepository を追加

    public StoreController(StoreRepository storeRepository, ReviewRepository reviewRepository) {
        this.storeRepository = storeRepository;
        this.reviewRepository = reviewRepository;  // ReviewRepository を初期化
    }

    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,
                        @RequestParam(name = "area", required = false) String area,
                        @RequestParam(name = "PriceLow", required = false) Integer PriceLow,
                        @RequestParam(name = "order", required = false) String order,
                        @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
                        Model model) {
        Page<Store> storePage;

        if (keyword != null && !keyword.isEmpty()) {
            if (order != null && order.equals("priceAsc")) {
                storePage = storeRepository.findByNameLikeOrAddressLikeOrderByPriceLowAsc("%" + keyword + "%", "%" + keyword + "%", pageable);
            } else {
                storePage = storeRepository.findByNameLikeOrAddressLikeOrderByCreatedAtDesc("%" + keyword + "%", "%" + keyword + "%", pageable);
            }
        } else if (area != null && !area.isEmpty()) {
            if (order != null && order.equals("priceAsc")) {
                storePage = storeRepository.findByAddressLikeOrderByPriceLowAsc("%" + area + "%", pageable);
            } else {
                storePage = storeRepository.findByAddressLikeOrderByCreatedAtDesc("%" + area + "%", pageable);
            }
        } else if (PriceLow != null) {
            if (order != null && order.equals("priceAsc")) {
                storePage = storeRepository.findByPriceLowLessThanEqualOrderByPriceLowAsc(PriceLow, pageable);
            } else {
                storePage = storeRepository.findByPriceLowLessThanEqualOrderByCreatedAtDesc(PriceLow, pageable);
            }
        } else {
            if (order != null && order.equals("priceAsc")) {
                storePage = storeRepository.findAllByOrderByPriceLowAsc(pageable);
            } else {
                storePage = storeRepository.findAllByOrderByCreatedAtDesc(pageable);
            }
        }

        model.addAttribute("storePage", storePage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("area", area);
        model.addAttribute("PriceLow", PriceLow);
        model.addAttribute("order", order);

        return "stores/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
        // 店舗情報を取得
        Store store = storeRepository.getReferenceById(id);
        model.addAttribute("store", store);

        // 店舗に紐づくレビューを取得
        List<Review> reviews = reviewRepository.findByStore(store);
        model.addAttribute("reviews", reviews);  // レビューをモデルに追加

        model.addAttribute("reservationInputForm", new ReservationInputForm());
        return "stores/show";
    }
}
