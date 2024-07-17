package com.example.study.converter;

import com.example.study.domain.Enum.Gender;
import com.example.study.domain.mapping.Member;
import com.example.study.web.dto.MemberRequestDto;
import com.example.study.web.dto.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDto.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDto.JoinDto request){
        Gender gender=null;

        switch (request.getGender()){
            case 1:
                gender=Gender.MAN;
                break;
            case 2:
                gender=Gender.WOMAN;
                break;
            case 3:
                gender=Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
