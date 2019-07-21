package org.lucasluo.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lucasluo.user.model.User;

@Mapper
public interface UserDao {

    User selectByUserName(@Param("username") String username);
}
