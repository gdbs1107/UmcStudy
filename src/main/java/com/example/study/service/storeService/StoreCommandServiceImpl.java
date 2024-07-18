package com.example.study.service.storeService;

import com.example.study.converter.StoreConverter;
import com.example.study.domain.Store;
import com.example.study.repository.StoreRepository;
import com.example.study.web.dto.StoreRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    @Override
    public Store registerStore(StoreRequestDto.StoreRegisterRequestDto request){

        Store newStore = StoreConverter.toStore(request);
        return storeRepository.save(newStore);
    }
}
