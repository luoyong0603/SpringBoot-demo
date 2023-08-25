package com.example.demo.controller;

import com.example.demo.component.weather.Weather;
import com.example.demo.component.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/24 11:11
 */
@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    //
    @RequestMapping("/weather/{cityCode}")
    public String  getWeather(@PathVariable String cityCode, Model model) throws IOException {
        //获取天气数据
        List<Weather> weathers = weatherService.getWeather(cityCode);
        model.addAttribute("weathers", weathers);
        return "weather";
    }
}
