package com.uwjx.spring.security.auth.server.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "userInfo")
@Slf4j
public class UserInfoController {


    @GetMapping(value = "principal")
    public String test1(Principal principal){
        log.warn("接收到请求: GET userInfo/principal");
        return JSON.toJSONString(principal);
    }
}
