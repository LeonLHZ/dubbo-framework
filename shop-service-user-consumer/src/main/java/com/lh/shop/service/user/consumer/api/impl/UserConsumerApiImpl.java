package com.lh.shop.service.user.consumer.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lh.shop.commons.api.*;
import com.lh.shop.commons.api.impl.BaseConsumerApiImpl;

/**
 * @author Neo
 * @date 2020/5/8 22:02
 */
@Service(version = "${service.version.v1}")
public class UserConsumerApiImpl extends BaseConsumerApiImpl implements UserConsumerApi{

    /*@Value("${server.port}")
    private String port;

    public UserConsumerApiImpl()
    {
    }

    @Override
    public String info()
    {
        return port;
    }*/
}
