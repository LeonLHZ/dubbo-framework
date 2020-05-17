package com.lh.shop.commons.api;

import com.github.pagehelper.PageInfo;
import com.lh.shop.commons.entity.BaseEntity;

/**
 * @author Neo
 * @date 2020/5/9 22:38
 */
public interface BaseService<T extends BaseEntity>
{
    int insert(T t);

    int delete(T t);

    int update(T t);

    T selectOne(T t);

    PageInfo<T> page(int pageNum, int pageSize, T t);

    int count(T t);
}