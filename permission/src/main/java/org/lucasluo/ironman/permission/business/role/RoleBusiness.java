package org.lucasluo.ironman.permission.business.role;

import com.lucasluo.ironman.common.entity.error.param.ParamError;
import com.lucasluo.ironman.common.entity.error.perm.CreateRoleSucceed;
import com.lucasluo.ironman.common.utils.PrimaryKeyUtils;
import com.lucasluo.ironman.common.utils.StringUtils;
import java.util.Date;
import javax.annotation.Resource;
import org.lucasluo.ironman.permission.entity.role.RoleEntity;
import org.lucasluo.ironman.permission.model.role.Role;
import org.lucasluo.ironman.permission.service.role.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleBusiness {

    @Resource
    private RoleService roleService;

    public ResponseEntity<?> add(RequestEntity<RoleEntity> requestEntity) {
        RoleEntity roleEntity = requestEntity.getBody();
        if(roleEntity == null
            || StringUtils.isNullOrWhitespace(roleEntity.getRoleName())) {
            return new ResponseEntity<>(new ParamError(), HttpStatus.BAD_REQUEST);
        }
        Date now = new Date();
        long primaryKey = PrimaryKeyUtils.generatePrimaryKey();
        Role role = new Role();
        role.setRoleId(primaryKey);
        role.setRoleName(roleEntity.getRoleName());
        role.setRoleDesc(roleEntity.getRoleDesc());
        role.setCreator(roleEntity.getCreator());
        role.setCreateTime(now);
        role.setModifier(roleEntity.getModifier());
        role.setModifyTime(now);
        roleService.add(role);

        roleEntity.setRoleId(primaryKey);
        return new ResponseEntity<>(new CreateRoleSucceed<>(roleEntity), HttpStatus.OK);
    }
}
