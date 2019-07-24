package org.lucasluo.ironman.shiro.realm;

import com.lucasluo.ironman.common.utils.CredentialsUtils;
import com.lucasluo.ironman.common.utils.JedisUtils;
import com.lucasluo.ironman.common.utils.JwtUtils;
import javax.annotation.Resource;
import javax.security.auth.login.AccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lucasluo.ironman.shiro.token.JwtToken;
import org.lucasluo.ironman.user.model.User;
import org.lucasluo.ironman.user.service.user.UserService;

@Slf4j
public class JwtShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private JedisUtils jedisUtils;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
        throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JwtUtils.getUserName(token);
        User user = userService.getByUserName(username);
        if(user != null) {
            return new SimpleAuthenticationInfo(username, token, getName());
        }
        return null;
    }
}
