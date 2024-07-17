package com.example.study.service.memberService;

import com.example.study.domain.mapping.Member;
import com.example.study.web.dto.MemberRequestDto;

public interface MemberCommandService {
    Member JoinMember(MemberRequestDto.JoinDto request);
}
