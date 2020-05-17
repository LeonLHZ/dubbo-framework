package com.lh.shop.commons.lambda.wrapper;

/**
 * 用于处理lambda中抛异常的处理
 *
 * @author yiuman
 * @date 2019-12-14
 */
@FunctionalInterface
public interface CheckedExceptionConsumeWrapper<T, E extends Exception> {

    void accept(T t) throws E;
}