package com.uwjx.spring.security.auth.server.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "userInfo")
@Slf4j
public class UserInfoController {


    @GetMapping(value = "principal")
    public String principal(Principal principal){
        log.warn("接收到请求: GET userInfo/principal");
        return JSON.toJSONString(principal);
    }

    @GetMapping(value = "userDetails")
    public String userDetails(@AuthenticationPrincipal UserDetails userDetails){
        log.warn("接收到请求: GET userInfo/userDetails");
        return JSON.toJSONString(userDetails);
    }

    @GetMapping(value = "authentication")
    public String userDetails(Authentication authentication){
        log.warn("接收到请求: GET userInfo/authentication");

        return JSON.toJSONString(authentication);
    }
}
