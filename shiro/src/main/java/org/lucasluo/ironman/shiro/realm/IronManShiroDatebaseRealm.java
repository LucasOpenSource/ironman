package org.lucasluo.ironman.shiro.realm;

import com.lucasluo.ironman.common.utils.JwtUtils;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lucasluo.ironman.user.model.User;
import org.lucasluo.ironman.user.service.user.UserService;

@Slf4j
public class IronManShiroDatebaseRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
        throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JwtUtils.getUserName(token);
        User user = userService.getByUserName(username);
        if(user != null) {
            return new SimpleAuthenticationInfo(token, token, getName());
        }
        return null;
    }
}
