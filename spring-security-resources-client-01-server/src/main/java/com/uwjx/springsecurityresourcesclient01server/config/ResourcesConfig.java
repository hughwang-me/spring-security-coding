package com.uwjx.springsecurityresourcesclient01server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

//@Slf4j
//@EnableResourceServer
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ResourcesConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/order/**").denyAll()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/test/**")
        ;//配置需要保护的资源路径
    }
}
