package com.example.springbootweather.weathercontroller;

import com.alibaba.fastjson.JSON;
import com.example.springbootweather.common.Common;
import com.example.springbootweather.tools.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    Logger logger=LoggerFactory.getLogger(WeatherController.class);

    @Value("${juhe.weather.Appkey}")
    private String weatherAppkey;

    @RequestMapping("/searchweather")
    public Common search(@RequestParam("city") String  city){
        String s = HttpRequest.sendGet("http://v.juhe.cn/weather/index", "cityname="+city+"&key="+weatherAppkey);
        Object s1 = JSON.parse(s);
        logger.info("查询情况：{}"+weatherAppkey+s1);
        return new Common(200,"成功返回",s1);

    }
}
