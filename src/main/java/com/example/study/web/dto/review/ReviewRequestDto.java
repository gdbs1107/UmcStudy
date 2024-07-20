package com.example.study.web.dto.review;

import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewRequestDto {

    @Getter
    public static class ReviewSaveRequestDto {

        String title;

        String body;

        Float score;
        Long memberMappingId;
        Long storeMappingId;
    }
    @Getter
    public static class ReviewtDto {

        String title;

        String body;

        Float score;

    }


}
