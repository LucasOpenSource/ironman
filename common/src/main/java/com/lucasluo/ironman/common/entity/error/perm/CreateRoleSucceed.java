package com.lucasluo.ironman.common.entity.error.perm;

import com.lucasluo.ironman.common.entity.error.BaseSuccess;

public class CreateRoleSucceed<T> extends BaseSuccess<T> {
    private static final String ERROR_MSG = "Role has been created!";

    public CreateRoleSucceed() {
        init(ERROR_MSG);
    }

    public CreateRoleSucceed(T data) {
        super(data);
        init(ERROR_MSG);
    }
}
