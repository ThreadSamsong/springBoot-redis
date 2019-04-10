package com.samsong.redis.springbootredis.controller;

import com.samsong.redis.springbootredis.annotation.CommonLimit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisLimitController {

    @PostMapping(value = "test3")
    @ResponseBody
    @CommonLimit
    public String getRedisData(){


        return "success";
    }
}
