package com.lucasluo.ironman.common.entity.error.user;

import com.lucasluo.ironman.common.entity.error.BaseError;

public class NoSuchUserError extends BaseError {

    private static final String ERROR_CODE = "ERR_USR_0001";
    private static final String ERROR_MSG = "Unable to find the specific user, the user may not exist!";

    public NoSuchUserError() {
        init(ERROR_CODE, ERROR_MSG);
    }
}
