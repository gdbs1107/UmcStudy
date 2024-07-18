package com.example.study.service.storeService;

import com.example.study.domain.Store;
import com.example.study.web.dto.StoreRequestDto;

public interface StoreCommandService {
    Store registerStore(StoreRequestDto.StoreRegisterRequestDto request);
}
