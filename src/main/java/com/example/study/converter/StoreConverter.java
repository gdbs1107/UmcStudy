package com.example.study.converter;

import com.example.study.domain.Region;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.web.dto.StoreRequestDto;
import com.example.study.web.dto.StoreResponseDto;
import com.example.study.web.dto.review.ReviewRequestDto;
import com.example.study.web.dto.review.ReviewResponseDto;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDto.StoreRegisterResponseDto toStoreRegisterResponseDto(StoreRequestDto.StoreRegisterRequestDto requestDto) {
        return StoreResponseDto.StoreRegisterResponseDto.builder()
                .name(requestDto.getName())
                .build();
    }

    public static Store toStore(StoreRequestDto.StoreRegisterRequestDto request,Region region) {
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(request.getScore())
                .region(region)
                .build();
    }


    public static Review toReview(ReviewRequestDto.ReviewtDto request) {

        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDto.createReviewResultDto toCreateReviewResultDto(Review review) {

        return ReviewResponseDto.createReviewResultDto.builder()
                .id(review.getId())
                .createAt(LocalDateTime.now())
                .build();

    }

    public static StoreResponseDto.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDto.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDto.ReviewPreViewListDto reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDto.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDto.ReviewPreViewListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
