package com.example.study.service.storeService;

import com.example.study.domain.Review;
import com.example.study.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long storeId, Integer page);
}
