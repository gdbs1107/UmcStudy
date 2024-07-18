package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.ReviewConverter;
import com.example.study.service.reviewService.ReviewCommandServiceImpl;
import com.example.study.web.dto.review.ReviewRequestDto;
import com.example.study.web.dto.review.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewCommandServiceImpl reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDto.ReviewSaveResponseDto> save(@RequestBody ReviewRequestDto.ReviewSaveRequestDto request){
        reviewCommandService.createReview(request);

        return ApiResponse.onSuccess(ReviewConverter.toReviewSaveResponseDto(request));
    }
}
