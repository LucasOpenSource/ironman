package com.lucasluo.ironman.common.entity.error.login;

import com.lucasluo.ironman.common.entity.error.BaseSuccess;

public class LoginSucceed<T> extends BaseSuccess<T> {
    private static final String ERROR_MSG = "Login succeed!";

    public LoginSucceed() {
        init(ERROR_MSG);
    }
    public LoginSucceed(T data) {
        super(data);
    }
}
