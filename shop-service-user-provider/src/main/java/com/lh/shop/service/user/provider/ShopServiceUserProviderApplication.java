package com.lh.shop.service.user.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lhz
 * @date 2020/5/6
 */
@EnableHystrix
@SpringBootApplication
@ComponentScan(basePackages = {"com.lh.shop.commons.context","com.lh.shop.commons.config"})
@MapperScan("com.lh.shop.service.user.provider.mapper")
public class ShopServiceUserProviderApplication
{
    public static void main(String[] args) {
        SpringApplication.run(ShopServiceUserProviderApplication.class, args);
        Main.main(args);
    }
}
