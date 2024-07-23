package com.example.study.converter;

import com.example.study.domain.mapping.Member;
import com.example.study.domain.mapping.Snack;
import com.example.study.domain.mapping.SnackOrder;
import com.example.study.web.dto.SnackDto;

public class SnackConverter {

    public static SnackOrder toSnackOrder (Member member,Snack snack) {

        return SnackOrder.builder()
                .member(member)
                .snack(snack)
                .build();
    }

    }

