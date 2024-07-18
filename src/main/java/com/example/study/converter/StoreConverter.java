package com.example.study.converter;

import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.web.dto.StoreRequestDto;
import com.example.study.web.dto.StoreResponseDto;
import com.example.study.web.dto.review.ReviewRequestDto;

import java.util.ArrayList;

public class StoreConverter {

    public static StoreResponseDto.StoreRegisterResponseDto toStoreRegisterResponseDto(StoreRequestDto.StoreRegisterRequestDto requestDto) {
        return StoreResponseDto.StoreRegisterResponseDto.builder()
                .name(requestDto.getName())
                .build();
    }

    public static Store toStore(StoreRequestDto.StoreRegisterRequestDto request) {
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(request.getScore())
                .build();
    }

    public static Review toReview(ReviewRequestDto.ReviewtDto request) {

        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
