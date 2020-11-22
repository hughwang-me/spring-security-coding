package com.uwjx.spring.security.resources.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {


    @GetMapping(value = "test1")
    public String test1(){
        log.warn("test/test1 ok!");
        return "resources server : test/test1 ok!";
    }
}
