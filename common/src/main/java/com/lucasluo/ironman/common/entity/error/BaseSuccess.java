package com.lucasluo.ironman.common.entity.error;

public abstract class BaseSuccess<T> extends BaseError<T> {
    private static final String ERROR_CODE = "INF0000";

    public BaseSuccess() {}
    public BaseSuccess(T data) {
        super(data);
    }

    protected void init(String errorMsg) {
        init(ERROR_CODE, errorMsg);
    }
}
