package com.lh.shop.commons.dto;

import lombok.*;

/**
 * @author Neo
 * @date 2020/5/9 22:20
 */
@Data
public class Result extends BaseResult
{
    public Result()
    {
    }

    private static final String RESULT_OK = "ok";
    private static final String SUCCESS = "成功操作";

    private String result;
    private Object data;
    private String success;
    private Cursor cursor;

    public static Result ok()
    {
        return createResult(RESULT_OK, null, SUCCESS, null);
    }

    public static Result ok(Object data)
    {
        return createResult(RESULT_OK, data, SUCCESS, null);
    }

    public static Result ok(Object data, Cursor cursor)
    {
        return createResult(RESULT_OK, data, SUCCESS, cursor);
    }


    private static Result createResult(String result, Object data, String success, Cursor cursor
    )
    {
        Result r = new Result();
        r.setResult(result);
        r.setData(data);
        r.setSuccess(success);
        r.setCursor(cursor);
        return r;
    }


    //分页内部类
    @Data
    public static class Cursor
    {
        private int total;
        private int offset;
        private int limit;
    }



}
