package com.lh.shop.service.user.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lh.shop.commons.controller.BaseController;
import com.lh.shop.commons.dto.*;
import com.lh.shop.commons.entity.User;
import com.lh.shop.service.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Neo
 * @date 2020/5/8 22:22
 */
@Controller
public class UserConsumerController extends BaseController<User>
{

    public UserConsumerController()
       {
           setService(userService);
       }


    @Reference(version = "${service.version.v1}")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "fallBack")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult in(){

        return Result.ok(userService.login("root","123456"));
    }


}
