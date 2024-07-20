package com.example.study.web.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDto {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class ReviewSaveResponseDto{

        String title;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class createReviewResultDto {
        Long id;
        LocalDateTime createAt;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class ReviewPreViewDto {
        Float Score;
        String body;
        LocalDateTime createAt;
    }
}
