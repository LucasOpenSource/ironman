package org.lucasluo.ironman.login.business;

import com.lucasluo.ironman.common.entity.error.login.LoginFatalError;
import com.lucasluo.ironman.common.entity.error.login.LoginSucceed;
import com.lucasluo.ironman.common.entity.error.param.ParamError;
import com.lucasluo.ironman.common.entity.error.user.NoSuchUserError;
import com.lucasluo.ironman.common.utils.CredentialsUtils;
import com.lucasluo.ironman.common.utils.JedisUtils;
import com.lucasluo.ironman.common.utils.JwtUtils;
import com.lucasluo.ironman.common.utils.StringUtils;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.lucasluo.ironman.login.entity.UserEntity;
import org.lucasluo.ironman.shiro.token.JwtToken;
import org.lucasluo.ironman.user.model.User;
import org.lucasluo.ironman.user.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("loginBusiness")
@Slf4j
public class LoginBusiness {

    @Resource
    private UserService userService;

    @Resource
    JedisUtils jedisUtils;

    public ResponseEntity<?> login(RequestEntity<UserEntity> requestEntity) {
        UserEntity userEntity = requestEntity.getBody();
        if(userEntity == null) {
            return new ResponseEntity<>(new ParamError(), HttpStatus.BAD_REQUEST);
        }
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        if(StringUtils.isNullOrWhitespace(username)
            || StringUtils.isNullOrWhitespace(password)) {
            return new ResponseEntity<>(new ParamError(), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getByUserName(username);
        if(user == null) {
            return new ResponseEntity<>(new NoSuchUserError(), HttpStatus.UNAUTHORIZED);
        }
        String encryptPwd = CredentialsUtils.encryptPassword(user.getSalt(), username, password);
        String jwtToken = JwtUtils.sign(username, encryptPwd);
        if(user.getPassword().equals(encryptPwd)) {
            userEntity.setToken(jwtToken);
            return new ResponseEntity<>(new LoginSucceed<>(userEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NoSuchUserError(), HttpStatus.UNAUTHORIZED);
        }
    }
}
