package org.lucasluo.ironman.user.view.login;

import org.lucasluo.ironman.base.view.BaseResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginResponse extends BaseResponse {

    public LoginResponse(String msg) {
        super(msg);
    }
}
