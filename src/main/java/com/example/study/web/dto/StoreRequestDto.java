package com.example.study.web.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StoreRequestDto {

    @Getter
    public static class StoreRegisterRequestDto{

        String name;

        String address;

        Float score;

    }
}
