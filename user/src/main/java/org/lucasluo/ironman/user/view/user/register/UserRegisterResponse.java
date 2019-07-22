package org.lucasluo.ironman.user.view.user.register;

import lombok.NoArgsConstructor;
import org.lucasluo.ironman.base.view.BaseResponse;
import org.lucasluo.ironman.user.model.User;

@NoArgsConstructor
public class UserRegisterResponse extends BaseResponse<User> {

    public UserRegisterResponse(String message) {
        super(message);
    }
}
