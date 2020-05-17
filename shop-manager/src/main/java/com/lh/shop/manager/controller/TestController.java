package com.lh.shop.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lhz
 * @date 2020/5/15
 */
@Controller
public class TestController {
    public TestController() {
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String in(){
        return "hello";
    }
}
