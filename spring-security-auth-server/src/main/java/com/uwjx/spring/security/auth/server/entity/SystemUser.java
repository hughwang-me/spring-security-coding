package com.uwjx.spring.security.auth.server.entity;

import lombok.Data;

@Data
public class SystemUser {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userNickname;

    private String userMail;

    private String userPhone;
}