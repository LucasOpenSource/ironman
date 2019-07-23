package org.lucasluo.ironman.user.business.login;

import com.lucasluo.ironman.common.utils.JwtUtils;
import javax.annotation.Resource;
import org.apache.shiro.util.Assert;
import org.lucasluo.ironman.base.result.ResultMessage;
import org.lucasluo.ironman.user.entity.login.LoginUserEntity;
import org.lucasluo.ironman.user.model.User;
import org.lucasluo.ironman.user.service.user.UserService;
import org.lucasluo.ironman.user.utils.UserUtils;
import org.lucasluo.ironman.user.view.login.LoginRequest;
import org.lucasluo.ironman.user.view.login.LoginResponse;
import org.springframework.stereotype.Service;

@Service("loginBusiness")
public class LoginBusiness {

    @Resource
    private UserService userService;

    public LoginResponse login(LoginRequest request) {
        LoginUserEntity loginUser = request.getData();
        Assert.notNull(loginUser);

        String username = loginUser.getUsername();
        String password = loginUser.getPassword();

        Assert.notNull(username, "Username cannot be null!");
        Assert.notNull(password, "Password cannot be null!");

        User user = userService.getByUserName(username);
        LoginResponse response = new LoginResponse();
        if(user == null) {
            response.setMessage(ResultMessage.NO_SUCH_USER.getValue());
        } else {
            if(!user.getPassword().equals(UserUtils.getSignedPassword(username, password, user.getSalt()))) {
                response.setMessage(ResultMessage.LOGIN_AUTH_FAILED.getValue());
            } else {
                loginUser.setPassword(null);
                loginUser.setToken(JwtUtils.sign(username, password));
                response.setData(loginUser);
            }
        }
        return response;
    }
}
