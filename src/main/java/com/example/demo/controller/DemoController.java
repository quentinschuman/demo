package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qianshu on 2018/5/9.
 */
@Controller
public class DemoController {
    @RequestMapping(value = "demo")
    public String demo(){
        return "/demo";
    }
}
