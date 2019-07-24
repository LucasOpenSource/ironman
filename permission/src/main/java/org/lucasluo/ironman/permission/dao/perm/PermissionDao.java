package org.lucasluo.ironman.permission.dao.perm;

import org.lucasluo.ironman.permission.model.perm.Permission;

public interface PermissionDao {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}