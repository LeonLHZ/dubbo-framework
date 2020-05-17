package com.lh.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lh.shop.commons.constants.Constant;
import com.lh.shop.commons.dto.*;
import com.lh.shop.commons.entity.User;
import com.lh.shop.commons.utils.*;
import com.lh.shop.service.redis.api.RedisService;
import com.lh.shop.service.user.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.UUID;

/**
 * @author Neo
 * @date 2020/5/7 22:30
 */
@Slf4j
@Controller
public class SsoController {

    @Reference(version = "${service.version.v1}")
    private RedisService redisService;

    @Reference(version = "${service.version.v1}")
    private UserService userService;


    public SsoController() {
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String url, HttpServletRequest request, Model model) {
        String token = CookieUtils.getCookieValue(request, "token");
        if (StringUtils.isNotBlank(token)) {
            String loginCode = (String) redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                String json = (String) redisService.get(loginCode);
                if (StringUtils.isNotBlank(json)) {
                    try {
                        User user = MapperUtils.json2pojo(json, User.class);
                        if (StringUtils.isNotBlank(url))
                            return "redirect:" + url;
                        model.addAttribute("admin", user);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (StringUtils.isNotBlank(url))
            model.addAttribute("url", url);
        return "login";
    }

    /* @RequestMapping(value = "login", method = RequestMethod.POST)
     @ResponseBody
     public String login(String loginCode, String password, @RequestParam(required = false) String url,
                         HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
         User user = userService.login(loginCode, password);
         if (user == null) {
             redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新输入！");
         } else {
             String token = UUID.randomUUID().toString();
             redisService.set(token, loginCode, 60 * 60 * 24);

             CookieUtils.setCookie(request, response, "token", token, 60 * 60 * 24);
             if (StringUtils.isNotBlank(url))
                 return "redirect:" + url;

             redirectAttributes.addFlashAttribute("message", "服务器异常，请稍后再试！");


         }


         return "redirect:/login";
     }
 */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(required = false) String url, Model model) {
        CookieUtils.deleteCookie(request, response, "token");
        return login(url, request, model);
    }

    @RequestMapping(value = "/loginPage")
    public String toLoginPage() {
        return "redirect:" + Constant.LOGIN_PAGE_URL;
    }

    @RequestMapping(value = "/unauthorizedPage")
    public String toUnauthorizedPage() {
        return "redirect:" + Constant.UNAUTHORIZED_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult toLogin(String name, String password) throws Exception {
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            //3.执行登录方法

            subject.login(token);


        } catch (UnknownAccountException e) {
            //5.登录失败

            log.info(e.getMessage());
            return ErrorResult.notOk(Constant.LOGIN_ERROR_USERNAME);
        } catch (IncorrectCredentialsException e) {
            log.info(e.getMessage());
            return ErrorResult.notOk(Constant.LOGIN_ERROR_PASSWORD);
        }
        //登录成功
        if (subject.isAuthenticated()) {
            String c_token = UUID.randomUUID().toString();
            redisService.set(c_token, name, 60 * 60 * 24);
            redisService.set(name, MapperUtils.obj2json((User) subject.getPreviousPrincipals()), 60 * 60 * 24);
            return Result.ok(c_token);
        }


        //CookieUtils.setCookie(request, response, "token", token, 60 * 60 * 24);
        return ErrorResult.notOk();
    }
}
