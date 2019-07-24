package com.lucasluo.ironman.common.entity.error.login;

import com.lucasluo.ironman.common.entity.error.BaseError;

public class LoginAuthError extends BaseError {

    private static final String ERROR_CODE = "ERR_LGN_0001";
    private static final String ERROR_MSG = "Authentication failed, either username or password is incorrect!";

    public LoginAuthError() {
        init(ERROR_CODE, ERROR_MSG);
    }
}
