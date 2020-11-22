package com.uwjx.spring.security.auth.server.mapper;

import com.uwjx.spring.security.auth.server.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Integer userId);

    SystemUser selectByUsername(String username);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);
}
