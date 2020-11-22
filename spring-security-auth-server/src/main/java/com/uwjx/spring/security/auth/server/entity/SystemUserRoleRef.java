package com.uwjx.spring.security.auth.server.entity;

import lombok.Data;

@Data
public class SystemUserRoleRef {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private String roleName;
}
