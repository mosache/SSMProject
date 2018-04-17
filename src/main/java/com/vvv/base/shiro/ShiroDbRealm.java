package com.vvv.base.shiro;

import com.vvv.models.User;
import com.vvv.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroDbRealm extends AuthorizingRealm{

    private Logger logger = Logger.getLogger(ShiroDbRealm.class);

    @Autowired
    private UserService userService;

    public static final String SESSION_USER_KEY = "SESSION_USER_KEY";

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("======用户授权认证======");
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(SESSION_USER_KEY);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(user.getRole().trim());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("======用户登陆认证======");
        User user = tokenToUser((UsernamePasswordToken) authenticationToken);
        User loginUser = userService.login(user);
        if (loginUser == null){
            return null;
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SESSION_USER_KEY,loginUser);
        Object principal = authenticationToken.getPrincipal();
        return new SimpleAuthenticationInfo(principal,loginUser.getPassword(),this.getName());
    }

    private User tokenToUser(UsernamePasswordToken token){
        User u = new User();
        u.setUsername(token.getUsername());
        u.setPassword(String.valueOf(token.getPassword()));
        return u;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
