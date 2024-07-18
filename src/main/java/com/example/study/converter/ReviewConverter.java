package com.example.study.converter;

import com.example.study.domain.Review;
import com.example.study.web.dto.review.ReviewRequestDto;
import com.example.study.web.dto.review.ReviewResponseDto;

public class ReviewConverter {



    public static ReviewResponseDto.ReviewSaveResponseDto toReviewSaveResponseDto(ReviewRequestDto.ReviewSaveRequestDto request) {

        return ReviewResponseDto.ReviewSaveResponseDto.builder()
                .title(request.getTitle())
                .build();
    }

    public static Review toReview(ReviewRequestDto.ReviewSaveRequestDto request) {

        return Review.builder()
                .body(request.getBody())
                .title(request.getTitle())
                .score(request.getScore())
                .build();

    }
}
