package com.lh.shop.commons.lambda.wrapper.utils;


import com.lh.shop.commons.lambda.wrapper.*;
import lombok.extern.slf4j.Slf4j;

import java.util.function.*;

/**
 * @author ldp
 * @date 2019-07-08
 */
@Slf4j
public class LambdaUtils {

    public static <T> Consumer<T> handlingConsumerWrapper(CheckedExceptionConsumeWrapper<T, Exception> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                log.info(ex.getMessage());
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T> Supplier<T> handlingSupplierWrapper(CheckedExceptionSupplierWrapper<T, Exception> supplier) {
        return () -> {
            try {
                return supplier.get();
            } catch (Exception ex) {
                log.info(ex.getMessage());
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T> Predicate<T> handlingPredicateWrapper(CheckedExceptionPredicateWrapper<T, Exception> predicate) {
        return t -> {
            try {
                return predicate.test(t);
            } catch (Exception ex) {
                log.info(ex.getMessage());
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T, R> Function<T, R> handlingFunctionWrapper(CheckedExceptionFunctionWrapper<T, R, Exception> function) {
        return r -> {
            try {
                return function.apply(r);
            } catch (Exception ex) {
                log.info(ex.getMessage());
                throw new RuntimeException(ex);
            }
        };
    }
}
