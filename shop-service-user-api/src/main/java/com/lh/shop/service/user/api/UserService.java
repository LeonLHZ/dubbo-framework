package com.lh.shop.service.user.api;

import com.lh.shop.commons.api.BaseService;
import com.lh.shop.commons.entity.User;

/**
 * @author Neo
 * @date 2020/5/8 21:09
 */
public interface UserService extends BaseService<User>
{

    User login(String loginCode, String password);


}