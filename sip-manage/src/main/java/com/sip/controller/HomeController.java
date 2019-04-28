package com.sip.controller;

import com.sip.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    RedisOperator redisOperator;

    /**
     * 跳转到后台首页
     * @return
     */
    @RequestMapping("/index")
    public String queryIndexPage(ModelMap modelMap){

        return "/index";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/")
    public String queryLoginPage(){
        return "login";
    }

}
