package com.lh.shop.commons.dto;

import lombok.*;

import java.util.List;

/**
 * @author Neo
 * @date 2020/5/10 22:27
 */
@Data
@AllArgsConstructor
public class ErrorResult extends BaseResult
{
    private static final String NOT_OK = "error";
    private static final String FAIL = "失败";
    private String field;
    private String message;
    private List<Error> errors;

    public ErrorResult()
    {

    }

    public static ErrorResult notOk(){
        return creatError(NOT_OK,FAIL);
    }

    public static ErrorResult notOk(String message){
            return creatError(NOT_OK,message);
        }

    public static ErrorResult notOk(String field,String message){
            return creatError(field,message);
        }

    public static ErrorResult creatError(String field, String message)
    {
        ErrorResult error = new ErrorResult();
        error.setField(field);
        error.setMessage(message);
        return error;
    }

}
