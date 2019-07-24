package com.lucasluo.ironman.common.entity.error.param;

import com.lucasluo.ironman.common.entity.error.BaseError;

public class ParamError extends BaseError {

    private static final String ERROR_CODE = "ERR_PARAM_0001";
    private static final String ERROR_MSG = "Illegal parameter, please check your inputs again!";

    public ParamError() {
        init(ERROR_CODE, ERROR_MSG);
    }
}
