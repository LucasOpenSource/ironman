package org.lucasluo.user.view;

import org.lucasluo.base.view.BaseResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginResponse extends BaseResponse {

    public LoginResponse(String msg) {
        super(msg);
    }
}
