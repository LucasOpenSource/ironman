package com.lucasluo.ironman.common.entity.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseError<T> {
    private String errorCode;
    private String errorMsg;
    protected T data;

    public BaseError() {}
    public BaseError(T data) {
        this.data = data;
    }

    protected void init(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
