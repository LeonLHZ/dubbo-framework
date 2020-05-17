package com.lh.shop.commons.controller;

import com.github.pagehelper.PageInfo;
import com.lh.shop.commons.api.BaseService;
import com.lh.shop.commons.constants.HttpStatusConstants;
import com.lh.shop.commons.dto.*;
import com.lh.shop.commons.entity.BaseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Neo
 * @date 2020/5/9 22:56
 */
public class BaseController<T extends BaseEntity>
{


    private BaseService service;

    public BaseController()
    {
    }


    @RequestMapping(value = "/page/{pageNum}/{pageSize}")
    public BaseResult page(
            @PathVariable(required = true) Integer pageNum,
            @PathVariable(required = true) Integer pageSize,
            @RequestParam(required = false) T t
    )
    {
        PageInfo pageInfo = this.service.page(pageNum, pageSize, t);
        List<T> list = pageInfo.getList();
        Result.Cursor cursor = new Result().getCursor();
        cursor.setTotal(new Long(pageInfo.getTotal()).intValue());
        cursor.setOffset(pageInfo.getPageNum());
        cursor.setLimit(pageInfo.getPageSize());

        return Result.ok(list, cursor);
    }

    public void setService(BaseService service)
    {
        service = this.service;
    }

    public BaseResult fallBack()
    {
        return ErrorResult.notOk(String.valueOf(HttpStatusConstants.BAD_GETWAT.getStatus()),
                HttpStatusConstants.BAD_GETWAT.getContent());
    }

}
