package com.lh.shop.commons.lambda.wrapper;

@FunctionalInterface
public interface CheckedExceptionSupplierWrapper<T, E extends Exception> {
    T get() throws E;
}
