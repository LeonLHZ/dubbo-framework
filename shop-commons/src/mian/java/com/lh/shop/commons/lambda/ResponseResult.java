package com.lh.shop.commons.lambda;


import java.util.*;

/**
 * 数据响应格式
 *
 * @author yiuman
 * @date 2019-05-15
 */
public class ResponseResult<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 数据内容
     */
    private T data;

    /**
     * 错误描述信息
     */
    private String message = "";

    public ResponseResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseResult<T> ok() {
        return ResponseResult.ok(null);
    }

    public static <T> ResponseResult<T> ok(T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(ResponseStatusCode.OK);
        responseResult.setData(data);
        return responseResult;
    }

    public static <T> ResponseResult<Map<String, Object>> ok(List<T> list, Integer totalCount) {
        Map<String, Object> data = new HashMap<>(2);
        data.put("totalCount", totalCount);
        data.put("list", list);

        ResponseResult<Map<String, Object>> responseResult = new ResponseResult<>();
        responseResult.setCode(ResponseStatusCode.OK);
        responseResult.setData(data);
        return responseResult;
    }

    public static <T> ResponseResult<T> badRequest(String errmsg) {
        return error(ResponseStatusCode.BAD_REQUEST, errmsg);
    }

    public static <T> ResponseResult<T> error(String errmsg) {
        return error(ResponseStatusCode.SERVER_ERROR, errmsg);
    }

    public static <T> ResponseResult<T> error(Integer errcode, String errmsg) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(errcode);
        responseResult.setMessage(errmsg);
        return responseResult;
    }
}
