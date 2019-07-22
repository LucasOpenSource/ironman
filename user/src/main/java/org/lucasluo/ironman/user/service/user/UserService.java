package org.lucasluo.ironman.user.service.user;

import com.lucasluo.ironman.common.utils.StringUtils;
import javax.annotation.Resource;
import org.lucasluo.ironman.user.dao.UserDao;
import org.lucasluo.ironman.user.model.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Resource
    private UserDao userDao;

    public User getByUserName(String username) {
        if(StringUtils.isNullOrWhitespace(username)) {
            throw new IllegalArgumentException("username");
        }

        return userDao.selectByUserName(username);
    }
}
