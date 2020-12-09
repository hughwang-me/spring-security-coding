package com.uwjx.springsecurityresourcesclient01server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "normal")
@Slf4j
public class NormalController {

    @GetMapping(value = "list")
    public String list(){
        log.warn("test list");
        return "test list";
    }
}
