package com.lh.shop.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lh.shop.commons.entity.User;
import com.lh.shop.commons.service.impl.BaseServiceImpl;
import com.lh.shop.service.user.api.UserService;
import com.lh.shop.service.user.provider.mapper.UserMapper;

/**
 * @author Neo
 * @date 2020/5/8 23:14
 */
@Service(version = "${service.version.v1}")
public class UserServiceImpl extends BaseServiceImpl<User,UserMapper> implements UserService
{
    public UserServiceImpl()
    {
    }

    @Override
    public User login(String loginCode, String password)
    {
        if ("root".equals(loginCode)&&"123456".equals(password))
            return new User();
        return null;
    }
}
