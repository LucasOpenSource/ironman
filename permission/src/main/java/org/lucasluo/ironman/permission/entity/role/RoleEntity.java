package org.lucasluo.ironman.permission.entity.role;

import lombok.Getter;
import lombok.Setter;
import org.lucasluo.ironman.base.entity.BaseEntity;

@Getter
@Setter
public class RoleEntity extends BaseEntity {
    private Long roleId;
    private String roleName;
    private String roleDesc;
}
