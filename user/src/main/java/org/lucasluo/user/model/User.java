package org.lucasluo.user.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String primaryKey;
    private String userName;
    private String password;
    private String realName;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifyTime;
}
