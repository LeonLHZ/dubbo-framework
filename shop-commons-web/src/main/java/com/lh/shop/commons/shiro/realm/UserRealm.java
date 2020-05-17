package com.lh.shop.commons.shiro.realm;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lh.shop.commons.entity.User;
import com.lh.shop.service.user.api.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.*;

/**
 * @author Neo
 * @date 2020/5/10 21:34
 */
public class UserRealm extends AuthorizingRealm
{

    @Reference(version = "service.version.v1")
    private static UserService userService;

    public UserRealm()
    {
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException
    {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null)
        {
            return null;
        }
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = new User();
        user.setUsername(token.getUsername());
        user.setPassword(String.valueOf(token.getPassword()));
        User u = userService.selectOne(user);
        if (u == null)
            return null;
        return new SimpleAuthenticationInfo(u, u.getPassword(), getName());
    }

    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        info.addStringPermission("user:add");

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPreviousPrincipals();
        /*for (Role role : user.) {
                   //添加角色
                   info.addRole(role.getName());
                   //添加权限
                   for (Permissions permissions : role.) {
                       info.addStringPermission(permissions.getPermissionsName());
                   }
               }*/

        return info;
    }
}
