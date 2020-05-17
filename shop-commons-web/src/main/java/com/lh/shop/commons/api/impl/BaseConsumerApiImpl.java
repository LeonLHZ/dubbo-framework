package com.lh.shop.commons.api.impl;

import com.lh.shop.commons.api.BaseConsumerApi;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Neo
 * @date 2020/5/8 22:09
 */
public class BaseConsumerApiImpl implements BaseConsumerApi
{

    @Value("${server.port}")
    private String port;

    public BaseConsumerApiImpl()
    {
    }


    @Override
    public String info()
    {
        return port;
    }
}
