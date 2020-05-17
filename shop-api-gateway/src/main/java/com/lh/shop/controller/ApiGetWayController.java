package com.lh.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.lh.shop.commons.api.UserConsumerApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Neo
 * @date 2020/5/5 20:48
 */
@Controller

public class ApiGetWayController
{
    @Reference(version = "${service.version.v1}")
    private UserConsumerApi userConsumerApi;

    public ApiGetWayController()
    {
    }

   @RequestMapping(value = "/user/{path}",method = RequestMethod.GET)
    public String user(@PathVariable String path)throws Exception{
        String port = userConsumerApi.info();

        return getRequest(path, port);

    }

    private String getRequest(String path,String port){
        if (RpcContext.getContext().isConsumerSide()){
            return String.format("redirect:http://%s:%s/%s",RpcContext.getContext().getRemoteHost(),port,path);
        }
        return null;
    }







}
