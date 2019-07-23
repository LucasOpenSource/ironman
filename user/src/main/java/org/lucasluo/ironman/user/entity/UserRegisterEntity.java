package org.lucasluo.ironman.user.entity;

import lombok.Getter;
import lombok.Setter;
import org.lucasluo.ironman.base.entity.BaseEntity;

@Setter
@Getter
public class UserRegisterEntity extends BaseEntity {

    private String username;
    private String password;
    private String realname;
}
