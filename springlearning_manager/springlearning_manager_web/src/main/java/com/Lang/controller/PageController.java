package com.Lang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//页面管理
@Controller
public class PageController {

    @RequestMapping("/")
    public String requestIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String requestPage(@PathVariable String page){
        return page;
    }
}
