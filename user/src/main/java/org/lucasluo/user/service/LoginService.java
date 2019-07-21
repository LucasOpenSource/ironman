package org.lucasluo.user.service;

import javax.annotation.Resource;
import org.lucasluo.user.dao.UserDao;
import org.lucasluo.user.entity.LoginUserEntity;
import org.lucasluo.user.model.User;
import org.lucasluo.user.view.LoginRequest;
import org.lucasluo.user.view.LoginResponse;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("loginService")
@Log
public class LoginService {

    @Resource
    private UserDao userDao;

    public LoginResponse login(LoginRequest request) {
        LoginUserEntity loginUserEntity = request.getData();
        if(loginUserEntity == null) {
            return new LoginResponse("参数不合法");
        }
        String username = loginUserEntity.getUsername();
        String password = loginUserEntity.getPassword();
        if(StringUtils.isEmpty(username)
            || StringUtils.isEmpty(password)) {
            return new LoginResponse("参数不合法");
        }

        /*
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (Exception ex) {
            return new LoginResponse("登录异常");
        }
        */
        User user = userDao.selectByUserName(username);
        log.info("登录验证中");
        log.info("用户：" + user.getUserName() + "； 密码：" + user.getPassword());
        return new LoginResponse("登录成功");
    }
}
