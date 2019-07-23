package org.lucasluo.ironman.user.view.login;

import lombok.NoArgsConstructor;
import org.lucasluo.ironman.base.view.BaseResponse;
import org.lucasluo.ironman.user.entity.login.LoginUserEntity;

@NoArgsConstructor
public class LoginResponse extends BaseResponse<LoginUserEntity> {

    public LoginResponse(String msg) {
        super(msg);
    }
}
