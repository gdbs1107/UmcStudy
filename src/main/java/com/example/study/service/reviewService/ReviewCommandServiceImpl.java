package com.example.study.service.reviewService;

import com.example.study.ResourceNotFoundException;
import com.example.study.converter.ReviewConverter;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.domain.mapping.Member;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.ReviewRepository;
import com.example.study.repository.StoreRepository;
import com.example.study.web.dto.review.ReviewRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;


    public Review createReview(ReviewRequestDto.ReviewSaveRequestDto request) {

        Optional<Store> store = storeRepository.findById(request.getStoreMappingId());
        Optional<Member> member = memberRepository.findById(request.getMemberMappingId());

        Optional<Store> storeOptional = storeRepository.findById(request.getStoreMappingId());
        Optional<Member> memberOptional = memberRepository.findById(request.getMemberMappingId());

        Store newstore = storeOptional.orElseThrow(() -> new ResourceNotFoundException("Store not found with id " + request.getStoreMappingId()));
        Member newmember = memberOptional.orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + request.getMemberMappingId()));

        Review newReview = ReviewConverter.toReview(request);
        newReview.setMember(newmember);
        newReview.setStore(newstore);

        return newReview;

    }
}
