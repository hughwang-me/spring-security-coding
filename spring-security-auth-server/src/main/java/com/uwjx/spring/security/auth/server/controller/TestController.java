package com.uwjx.spring.security.auth.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
@Slf4j
public class TestController {


    @GetMapping(value = "test1")
    public String test1(){
        log.warn("接收到请求: GET test/test1");
        return "test1 ok";
    }
}
