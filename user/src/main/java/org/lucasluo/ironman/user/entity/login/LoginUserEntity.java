package org.lucasluo.ironman.user.entity.login;

import lombok.Getter;
import lombok.Setter;
import org.lucasluo.ironman.base.entity.BaseEntity;

@Setter
@Getter
public class LoginUserEntity extends BaseEntity {
    private String username;
    private String password;
}
