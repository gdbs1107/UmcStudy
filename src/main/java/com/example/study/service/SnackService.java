package com.example.study.service;

import com.example.study.converter.SnackConverter;
import com.example.study.domain.mapping.Member;
import com.example.study.domain.mapping.Snack;
import com.example.study.domain.mapping.SnackOrder;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.SnackOrderRepository;
import com.example.study.repository.SnackRepository;
import com.example.study.web.dto.SnackDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SnackService {

    private final SnackRepository snackRepository;
    private final MemberRepository memberRepository;
    private final SnackOrderRepository snackOrderRepository;


    public void save(SnackDto.SnackOrderRequestDto request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + request.getMemberId()));
        Snack snack = snackRepository.findById(request.getSnackId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid snack ID: " + request.getSnackId()));

        SnackOrder snackOrder = SnackConverter.toSnackOrder(member, snack);

        snackOrderRepository.save(snackOrder);
        // 실제 저장 로직 추가 (예: SnackOrderRepository를 사용하여 저장)
        // snackOrderRepository.save(snackOrder);
    }


}
