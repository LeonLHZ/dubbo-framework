package com.lh.shop.service.redis.provider.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author lhz
 * @date 2020/5/11
 */
public class RedisUtils {
    public RedisUtils() {
    }

    @Autowired
    private static RedisTemplate redisTemplate;

    private static final Long LOCK_EXPIRE = 123123L;
    //1、常用的分布式锁加强版

    /**
     * 最终加强分布式锁
     *
     * @param key key值
     * @return 是否获取到
     */
    public static boolean lock(String key) {
        String lock = LOCK_EXPIRE + key;
        // 利用lambda表达式
        return (Boolean) redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;
                Boolean acquire = redisConnection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
                if (acquire) {
                    return true;
                } else {
                    byte[] value = redisConnection.get(lock.getBytes());
                    if (Objects.nonNull(value) && value.length > 0) {
                        long expireTime = Long.parseLong(new String(value));
                        if (expireTime < System.currentTimeMillis()) {
                            // 如果锁已经过期
                            byte[] oldValue = redisConnection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());
                            // 防止死锁
                            return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                        }
                    }
                }
                return false;
            }
        });
    }


    //2、 删除锁

    /**
     * 删除锁
     *
     * @param key
     */
    public static void delete(String key) {
        redisTemplate.delete(key);
    }


    //3、指定缓存失效时间

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public static boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //4、根据key 获取过期时间

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public static long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
    // 5、判断key是否存在

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public static boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // 6、删除缓存


    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public static void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }


}
