package com.uwjx.spring.security.resources.server.controller;

import com.uwjx.spring.security.resources.server.okhttp.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "auth")
public class AuthController {


    @GetMapping(value = "callback")
    public String callback(@RequestParam("code")String code){
        log.warn("auth/callback");
        log.warn("code : {}" , code);

        HttpRequest httpRequest = new HttpRequest();
        String url = "http://localhost:8080/authServer/oauth/token?grant_type=authorization_code&code=" + code + "&scope=all&redirect_uri=http://localhost:8081/auth/callback";
        try {
            String resp = httpRequest.post(url , "client-01" , "123123");
            log.warn("resp : {}" , resp);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "resources server : test/test1 ok!";
    }
}
