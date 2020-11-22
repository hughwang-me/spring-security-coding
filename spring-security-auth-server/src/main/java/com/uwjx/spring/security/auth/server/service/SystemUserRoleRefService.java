package com.uwjx.spring.security.auth.server.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.uwjx.spring.security.auth.server.entity.SystemUserRoleRef;
import com.uwjx.spring.security.auth.server.mapper.SystemUserRoleRefMapper;
@Service
public class SystemUserRoleRefService{

    @Resource
    private SystemUserRoleRefMapper systemUserRoleRefMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return systemUserRoleRefMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(SystemUserRoleRef record) {
        return systemUserRoleRefMapper.insert(record);
    }

    
    public int insertSelective(SystemUserRoleRef record) {
        return systemUserRoleRefMapper.insertSelective(record);
    }

    
    public SystemUserRoleRef selectByPrimaryKey(Integer id) {
        return systemUserRoleRefMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(SystemUserRoleRef record) {
        return systemUserRoleRefMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(SystemUserRoleRef record) {
        return systemUserRoleRefMapper.updateByPrimaryKey(record);
    }

}
