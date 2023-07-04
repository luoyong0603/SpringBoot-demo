package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/6/13 16:48
 */
@Controller
@RequestMapping("/html")
@Api(tags = "静态访问模块", description = "静态访问模块")
public class HtmlController {

    @RequestMapping("/mail")
    public String hello(ModelMap model) {
        model.addAttribute("school", "闵行小学");
        model.addAttribute("className", "六(2)班");
        model.addAttribute("name", "赵云");
        return "mail";
    }


}
