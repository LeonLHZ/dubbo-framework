package com.lh.shop.commons.lambda.wrapper;

@FunctionalInterface
public interface CheckedExceptionPredicateWrapper<T, E extends Exception> {
    boolean test(T t) throws E;
}