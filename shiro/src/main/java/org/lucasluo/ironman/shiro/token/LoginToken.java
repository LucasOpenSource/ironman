package org.lucasluo.ironman.shiro.token;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

@Getter
@Setter
public class LoginToken extends UsernamePasswordToken {

    private String type;
    private String token;

    public LoginToken(String username, String password, String type, String token) {
        super(username, password);
        this.type = type;
        this.token = token;
    }
}
