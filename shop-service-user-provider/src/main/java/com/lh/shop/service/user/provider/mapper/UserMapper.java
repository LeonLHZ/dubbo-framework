package com.lh.shop.service.user.provider.mapper;


import com.lh.shop.commons.entity.User;
import com.lh.shop.commons.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.BaseMapper;
@CacheNamespace(implementation = RedisCache.class)
public interface UserMapper extends BaseMapper<User> {
}