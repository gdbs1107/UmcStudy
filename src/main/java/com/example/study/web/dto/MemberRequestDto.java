package com.example.study.web.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MemberRequestDto {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String email;
        String specAddress;
        List<Long> preferCategory;
    }
}
