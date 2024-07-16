package com.example.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    @Builder
    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public static class TempTestDto{
        String testString;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public static class TempExceptionDto{
        Integer flag;
    }
}
