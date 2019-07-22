package org.lucasluo.ironman.user.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.lucasluo.ironman.base.entity.BaseEntity;

@Getter
@Setter
public class UserEntity extends BaseEntity {
    private String userName;
    private String password;
    private String realName;
}
