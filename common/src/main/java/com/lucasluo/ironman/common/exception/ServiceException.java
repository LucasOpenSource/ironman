package com.lucasluo.ironman.common.exception;

import com.lucasluo.ironman.common.entity.error.BaseError;

public class ServiceException extends RuntimeException {

    private BaseError errorEntity;

    public ServiceException(BaseError errorEntity) {
        this.errorEntity = errorEntity;
    }
}
