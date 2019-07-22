package org.lucasluo.ironman.user.view.user;

import lombok.NoArgsConstructor;
import org.lucasluo.ironman.base.view.BaseResponse;
import org.lucasluo.ironman.user.model.User;

@NoArgsConstructor
public class GetUserResponse extends BaseResponse<User> {

    public GetUserResponse(String message) {
        super(message);
    }
}
