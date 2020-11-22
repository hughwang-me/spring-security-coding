package com.uwjx.spring.security.auth.server.service;

import com.uwjx.spring.security.auth.server.service.bean.UserBean;

public interface UserService {

    UserBean findByUsername(String username);
}
