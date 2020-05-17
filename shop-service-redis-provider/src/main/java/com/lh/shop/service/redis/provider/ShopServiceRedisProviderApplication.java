package com.lh.shop.service.redis.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author lhz
 * @date 2020/5/6
 */
@EnableHystrix
@SpringBootApplication
@ComponentScan(basePackages = {"com.lh.shop.commons.config"})
public class ShopServiceRedisProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServiceRedisProviderApplication.class, args);
        Main.main(args);
    }
}
