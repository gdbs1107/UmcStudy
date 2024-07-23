package com.example.study.apiPayload.exception.handler;

import com.example.study.apiPayload.code.BaseErrorCode;
import com.example.study.apiPayload.exception.GeneralException;

public class RegionCategoryHandler extends GeneralException {

    public RegionCategoryHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
