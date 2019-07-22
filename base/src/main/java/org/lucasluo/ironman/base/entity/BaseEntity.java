package org.lucasluo.ironman.base.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseEntity {
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifyTime;
    private Long version;
}
