package org.lucasluo.ironman.permission.service.role;

import javax.annotation.Resource;
import org.lucasluo.ironman.permission.dao.role.RoleDao;
import org.lucasluo.ironman.permission.model.role.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleDao roleDao;

    public int add(Role role) {
        return roleDao.insertSelective(role);
    }

    public Role get(long id) {
        return roleDao.selectByPrimaryKey(id);
    }
}
