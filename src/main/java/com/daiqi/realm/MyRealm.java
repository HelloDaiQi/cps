package com.daiqi.realm;

import com.daiqi.entity.User;
import com.daiqi.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    //为当前登录的用户赋予角色和权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String email = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.getRoles(email));
        return authorizationInfo;
    }

    //验证当前登录的用户
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String email = (String) authenticationToken.getPrincipal();
        try {
            User user = userService.findByEmail(email);
            if(user!=null){
                SecurityUtils.getSubject().getSession().setAttribute("user", user); // 把当前用户信息存到session中
                AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), "xxx");
                return authcInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
