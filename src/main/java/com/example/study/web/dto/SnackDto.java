package com.example.study.web.dto;

import com.example.study.domain.mapping.Member;
import com.example.study.domain.mapping.Snack;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SnackDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SnackGetDto{

        Long id;

        String name;
        String n;
        String img;

    }

    @Getter
    public static class SnackOrderRequestDto{


        @NotNull(message = "Snack ID cannot be null")
        Long SnackId;

        @NotNull(message = "Snack ID cannot be null")
        Long memberId;

    }


}
