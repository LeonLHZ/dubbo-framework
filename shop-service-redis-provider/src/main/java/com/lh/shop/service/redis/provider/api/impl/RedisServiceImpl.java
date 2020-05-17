package com.lh.shop.service.redis.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lh.shop.service.redis.api.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Neo
 * @date 2020/5/7 21:52
 */
@Service(version = "${service.version.v1}")
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedisTemplate redisTemplate;

    private final Long LOCK_EXPIRE = 123123L;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, int seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }




}
