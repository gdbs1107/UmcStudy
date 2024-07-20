package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.StoreConverter;
import com.example.study.domain.Store;
import com.example.study.repository.StoreRepository;
import com.example.study.service.storeService.StoreCommandService;
import com.example.study.service.storeService.StoreCommandServiceImpl;
import com.example.study.service.storeService.StoreQueryService;
import com.example.study.web.dto.StoreRequestDto;
import com.example.study.web.dto.StoreResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandServiceImpl service;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDto.StoreRegisterResponseDto> registerStore(@RequestBody @Valid StoreRequestDto.StoreRegisterRequestDto request) {

        Store store=service.registerStore(request);

        return ApiResponse.onSuccess(StoreConverter.toStoreRegisterResponseDto(request));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDto.ReviewPreViewListDto> getReviewList(@PathVariable(name = "storeId") Long storeId,@RequestParam(name = "page") Integer page){
        storeQueryService.getReviewList(storeId,page);
        return null;
    }
}
