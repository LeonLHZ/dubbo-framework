package com.lh.shop.commons.interceptor;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lh.shop.commons.constants.Constant;
import com.lh.shop.commons.entity.User;
import com.lh.shop.commons.utils.*;
import com.lh.shop.service.redis.api.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.*;

import javax.servlet.http.*;

/**
 * @author lhz
 * @date 2020/5/8
 */
@Component
@Slf4j
public class SsoInterceptor implements HandlerInterceptor {

    @Reference(version = "${service.version.v1}")
    private RedisService redisService;

    @Value(value = "${hosts.sso}")
    private String HOSTS_SSO;

    public SsoInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtils.getCookieValue(request, Constant.COOKIE_TOKEN);
        if (StringUtils.isBlank(token)) {
            response.sendRedirect(String.format("%s/loginPage?url=%s", HOSTS_SSO, HttpServletUtils.getFullPath(request)));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPreviousPrincipals();
        if (user != null) {
            //if(modelAndView!=null){
            // modelAndView.addObject(Constant.SESSION_USER,user);
            // }
        } else {
            String token = CookieUtils.getCookieValue(request, Constant.COOKIE_TOKEN);

            if (StringUtils.isNotBlank(token)) {
                String loginCode = (String) redisService.get(token);
                if (StringUtils.isNotBlank(loginCode)) {
                    String json = (String) redisService.get(loginCode);
                    if (StringUtils.isNotBlank(json)) {
                        user = MapperUtils.json2pojo(json, User.class);
                        // request.getSession().setAttribute(Constant.SESSION_USER,user);
                        //if(modelAndView!=null){
                        // modelAndView.addObject(Constant.SESSION_USER,user);
                        // }
                        UsernamePasswordToken t = new UsernamePasswordToken(user.getUsername(), user.getPassword());
                        try {
                            //执行登录方法

                            subject.login(t);

                            //登录成功
                        } catch (Exception e) {
                            //登录失败

                            log.info(e.getMessage());
                            response.sendRedirect(String.format("%s/login?url=%s", HOSTS_SSO, HttpServletUtils.getFullPath(request)));
                        }
                        if (subject.isAuthenticated()) {
                            return;
                        }

                    }

                }
            }

        }
        response.sendRedirect(String.format("%s/login?url=%s", HOSTS_SSO, HttpServletUtils.getFullPath(request)));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

    }
}
