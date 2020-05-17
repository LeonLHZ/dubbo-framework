package com.lh.shop.service.user.consumer;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lhz
 * @date 2020/5/6
 */
@EnableHystrix
@SpringBootApplication
@ComponentScan(basePackages = {"com.lh.shop.commons.shiro.config", "com.lh.shop.commons.interceptor",
        "com.lh.shop.commons.config"})
public class ShopServiceUserConsumerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ShopServiceUserConsumerApplication.class, args);
        Main.main(args);
    }


}
