package com.bekey.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SPA 单页面应用
 * 前后端分离控制器，只负责将项目页面转发到index，其他交互完全靠接口
 * Created by bekey on 2017/12/8.
 */
@Controller
public class HomeController {

    private static Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"/","/index"})
    public String vue() {
        return "/index.html";
    }

}
