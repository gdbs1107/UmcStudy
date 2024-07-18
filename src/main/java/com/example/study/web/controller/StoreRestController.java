package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.StoreConverter;
import com.example.study.domain.Store;
import com.example.study.repository.StoreRepository;
import com.example.study.service.storeService.StoreCommandService;
import com.example.study.service.storeService.StoreCommandServiceImpl;
import com.example.study.web.dto.StoreRequestDto;
import com.example.study.web.dto.StoreResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandServiceImpl service;

    @PostMapping("/")
    public ApiResponse<StoreResponseDto.StoreRegisterResponseDto> registerStore(@RequestBody @Valid StoreRequestDto.StoreRegisterRequestDto request) {

        Store store=service.registerStore(request);

        return ApiResponse.onSuccess(StoreConverter.toStoreRegisterResponseDto(request));
    }

    @GetMapping("/")
    public ApiResponse<StoreResponseDto.ReviewPreViewListDto> getReviewList(@PathVariable(name = "storeId") Long storeId) {
        return null;
    }
}
