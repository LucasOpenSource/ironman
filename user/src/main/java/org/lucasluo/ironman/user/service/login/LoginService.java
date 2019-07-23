package org.lucasluo.ironman.user.service.login;

import com.lucasluo.ironman.common.utils.JwtUtils;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lucasluo.ironman.base.result.ResultMessage;
import org.lucasluo.ironman.shiro.token.JwtToken;
import org.lucasluo.ironman.user.entity.login.LoginUserEntity;
import org.lucasluo.ironman.user.model.User;
import org.lucasluo.ironman.user.service.user.UserService;
import org.lucasluo.ironman.user.utils.UserUtils;
import org.lucasluo.ironman.user.view.login.LoginRequest;
import org.lucasluo.ironman.user.view.login.LoginResponse;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("loginService")
@Log
public class LoginService {
    public LoginResponse login(LoginRequest request) {
        LoginUserEntity loginUserEntity = request.getData();
        if(loginUserEntity == null) {
            return new LoginResponse(ResultMessage.INVALID_PARAMETER.getValue());
        }
        String username = loginUserEntity.getUsername();
        String password = loginUserEntity.getPassword();
        if(StringUtils.isEmpty(username)
            || StringUtils.isEmpty(password)) {
            return new LoginResponse(ResultMessage.INVALID_PARAMETER.getValue());
        }
        Subject subject = SecurityUtils.getSubject();
        User user = null;
        if(user == null) {
            return new LoginResponse(ResultMessage.NO_SUCH_USER.getValue());
        }
        String signedPassword = UserUtils.getSignedPassword(username, password, user.getSalt());
        JwtToken token = new JwtToken(JwtUtils.sign(username, signedPassword));
        try {
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return new LoginResponse(ResultMessage.LOGIN_AUTH_FAILED.getValue());
        } catch (Exception e) {
            return new LoginResponse(ResultMessage.FAIL.toString());
        }
        return new LoginResponse(ResultMessage.LOGIN_SUCCESS.getValue());
    }
}
