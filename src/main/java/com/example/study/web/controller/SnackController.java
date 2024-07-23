package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.SnackConverter;
import com.example.study.converter.TempConverter;
import com.example.study.domain.mapping.Snack;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.SnackRepository;
import com.example.study.service.SnackService;
import com.example.study.web.dto.MemberRequestDto;
import com.example.study.web.dto.SnackDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/snack")
public class SnackController {

    private final SnackRepository snackRepository;
    private final SnackService service;

    /*@GetMapping("/")
    public List<SnackDto.SnackGetDto> GetALlSnack(){
        List<SnackDto.SnackGetDto> result = snackRepository.findAll().stream()
                .map(snack -> {
                    return SnackConverter.toSnackDto(snack);
                })
                .collect(Collectors.toList());
        return result;
    }*/

    @PostMapping("/")
    public ApiResponse<String> orderSnack(@RequestBody SnackDto.SnackOrderRequestDto request) {
        service.save(request);
        return ApiResponse.onSuccess("ss");
    }
}
