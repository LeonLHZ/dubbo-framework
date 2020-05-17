package com.lh.shop.commons.lambda.wrapper;

/**
 * @author yiuman
 * @date 2020/2/14
 */
public interface CheckedExceptionFunctionWrapper<T,R,E extends Exception> {

    R apply(T t) throws E;
}