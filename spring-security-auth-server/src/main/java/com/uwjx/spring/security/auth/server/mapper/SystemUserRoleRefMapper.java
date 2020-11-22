package com.uwjx.spring.security.auth.server.mapper;

import com.uwjx.spring.security.auth.server.entity.SystemUserRoleRef;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemUserRoleRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUserRoleRef record);

    int insertSelective(SystemUserRoleRef record);

    SystemUserRoleRef selectByPrimaryKey(Integer id);

    List<SystemUserRoleRef> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(SystemUserRoleRef record);

    int updateByPrimaryKey(SystemUserRoleRef record);
}
