package com.lh.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Neo
 * @date 2020/5/7 22:29
 */
@EnableHystrix
@SpringBootApplication
public class ShopApiGatewayApplication {
    public ShopApiGatewayApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopApiGatewayApplication.class);
    }
}
