package com.uwjx.spring.security.auth.server.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "order")
@Slf4j
public class OrderController {


    @GetMapping(value = "list")
//    @PreAuthorize("hasAuthority('worker')")
    public String list(){
        log.warn("接收到请求: GET order/list");
        return "list success";
    }

    @GetMapping(value = "add")
    @PreAuthorize("hasRole('ADMIN')")
    public String add(){
        log.warn("接收到请求: GET order/add");
        return "add success";
    }

    @GetMapping(value = "delete")
    @PreAuthorize("hasAuthority('delete')")
    public String delete(){
        log.warn("接收到请求: GET order/delete");
        return "delete success";
    }

    @GetMapping(value = "hasRoleWorker")
    @PreAuthorize("hasRole('worker')")
    public String hasRoleWorker(){
        log.warn("接收到请求: GET order/hasRoleWorker");
        return "hasRoleWorker success";
    }

    @GetMapping(value = "hasAuthorityE1")
    @PreAuthorize("hasAuthority('e1')")
    public String hasAuthorityE1(){
        log.warn("接收到请求: GET order/hasAuthorityE1");
        return "hasAuthorityE1 success";
    }
}
