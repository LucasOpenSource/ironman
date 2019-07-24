package org.lucasluo.ironman.login.entity;

import lombok.Getter;
import lombok.Setter;
import org.lucasluo.ironman.base.entity.BaseEntity;

@Setter
@Getter
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String token;
}
