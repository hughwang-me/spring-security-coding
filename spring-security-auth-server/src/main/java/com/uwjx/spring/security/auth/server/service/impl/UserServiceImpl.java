package com.uwjx.spring.security.auth.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.uwjx.spring.security.auth.server.entity.SystemUser;
import com.uwjx.spring.security.auth.server.entity.SystemUserRoleRef;
import com.uwjx.spring.security.auth.server.mapper.SystemUserMapper;
import com.uwjx.spring.security.auth.server.mapper.SystemUserRoleRefMapper;
import com.uwjx.spring.security.auth.server.service.UserService;
import com.uwjx.spring.security.auth.server.service.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    SystemUserMapper systemUserMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    SystemUserRoleRefMapper systemUserRoleRefMapper;

    @Override
    public UserBean findByUsername(String username) {

        SystemUser systemUser = systemUserMapper.selectByUsername(username);
        if(systemUser == null){
            return null;
        }
        log.warn("用户:{}" , JSON.toJSONString(systemUser));

        List<SystemUserRoleRef> systemUserRoleRefs = systemUserRoleRefMapper.selectByUserId(systemUser.getUserId());

        List<String> roles = new ArrayList<>();
        roles.add("default");
        if(systemUserRoleRefs != null && systemUserRoleRefs.size() > 0){
            List<GrantedAuthority> authorities = new ArrayList<>(systemUserRoleRefs.size());
            for (SystemUserRoleRef systemUserRoleRef : systemUserRoleRefs) {
                authorities.add(new SimpleGrantedAuthority(systemUserRoleRef.getRoleName()));
            }
            log.warn("角色信息:{}" , authorities.size());

//            authorities.a

            UserBean userBean = new UserBean(systemUser.getUserName() ,
                    passwordEncoder.encode(systemUser.getUserPassword())  ,
                    AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
            log.warn("userBean信息:{}" , userBean);
            return userBean;
        }
        return new UserBean(systemUser.getUserName() ,
                passwordEncoder.encode(systemUser.getUserPassword())  ,
                AuthorityUtils.NO_AUTHORITIES);
    }
}
