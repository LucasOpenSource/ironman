package org.lucasluo.ironman.user.business.user;

import lombok.extern.java.Log;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.lucasluo.ironman.base.result.ResultMessage;
import org.lucasluo.ironman.user.model.User;
import org.lucasluo.ironman.user.view.user.register.UserRegisterRequest;
import org.lucasluo.ironman.user.view.user.register.UserRegisterResponse;
import org.springframework.stereotype.Service;

@Service
@Log
public class UserBusiness {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithm = "md5";
    private int hasIteration = 2;

    public UserRegisterResponse userRegister(UserRegisterRequest request) {
        UserRegisterResponse response = new UserRegisterResponse();
        User user = request.getData();
        if(user == null) {
            response.setMessage(ResultMessage.INVALID_PARAMETER.getValue());
            return response;
        }
        String salt = randomNumberGenerator.nextBytes().toHex();
        log.info("Salt: " + salt);
        user.setSalt(salt);
        String newPwd = new SimpleHash(algorithm, user.getPassword(),
            ByteSource.Util.bytes(user.getCredentialsSalt()), hasIteration).toHex();
        user.setPassword(newPwd);
        response.setMessage(ResultMessage.REGISTER_USER_SUCCEED.getValue());
        return response;
    }
}
