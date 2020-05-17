package com.lh.shop.commons.lambda;


import lombok.extern.slf4j.Slf4j;

/**
 * 接口运行时异常
 *
 * @author yiuman
 * @date 2020/2/12
 */
@Slf4j
public class ApiRuntimeException extends RuntimeException {

    private Integer statusCode;

    public ApiRuntimeException(String message) {
        super(message);
    }

    public ApiRuntimeException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ApiRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ApiRuntimeException(String message, Integer statusCode, Throwable throwable) {
        super(message, throwable);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
