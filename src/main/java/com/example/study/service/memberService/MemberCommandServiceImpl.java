package com.example.study.service.memberService;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.study.converter.MemberConverter;
import com.example.study.converter.MemberPreferConverter;
import com.example.study.domain.FoodCategory;
import com.example.study.domain.mapping.Member;
import com.example.study.domain.mapping.MemberPrefer;
import com.example.study.repository.FoodCategoryRepository;
import com.example.study.repository.MemberRepository;
import com.example.study.web.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member JoinMember(MemberRequestDto.JoinDto request) {
        Member newMember= MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                        return foodCategoryRepository.findById(category).orElseThrow(()->new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)
                    );}).collect(Collectors.toList());

        List<MemberPrefer> memberPrefers= MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPrefers.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
        return memberRepository.save(newMember);
    }
}
