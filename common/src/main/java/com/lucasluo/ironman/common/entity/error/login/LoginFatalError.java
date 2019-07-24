package com.lucasluo.ironman.common.entity.error.login;

import com.lucasluo.ironman.common.entity.error.BaseError;

public class LoginFatalError extends BaseError {

    private static final String ERROR_CODE = "ERR_LGN_0002";
    private static final String ERROR_MSG = "Login fatal error!";

    public LoginFatalError() {
        init(ERROR_CODE, ERROR_MSG);
    }
}
