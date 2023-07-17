package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/echarts")
@Api(tags = "echarts图表演示", description = "echarts图表演示")
public class EchartsController {

    @GetMapping("/basic-line")
    public String index() {
        return "eCharts";
    }

}
