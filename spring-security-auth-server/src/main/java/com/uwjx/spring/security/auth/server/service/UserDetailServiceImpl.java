package com.uwjx.spring.security.auth.server.service;

import com.alibaba.fastjson.JSON;
import com.uwjx.spring.security.auth.server.service.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        log.warn("准备认证用户: {}", s);

        UserBean userBean = userService.findByUsername(s);
        if(userBean != null){
            return userBean;
        }

        throw new UsernameNotFoundException("用户名或密码错误");

    }


}
