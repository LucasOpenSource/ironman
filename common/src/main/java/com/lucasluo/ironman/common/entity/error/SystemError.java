package com.lucasluo.ironman.common.entity.error;

public class SystemError extends BaseError {

    private final String ERROR_CODE = "SYS9999";
    private final String ERROR_MSG = "System error, please contact the system administrator!";

    public SystemError() {
        init(ERROR_CODE, ERROR_MSG);
    }

    protected void init(String errorCode, String errorMsg) {
        super.init(errorCode, errorMsg);
    }
}
