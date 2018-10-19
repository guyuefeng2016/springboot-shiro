package com.hu.dao;

import com.hu.entity.SysRole;
import com.hu.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserInfoDao{
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
    /**更新用户*/
    void updateUser(UserInfo userInfo);
    /**查询所有的角色信息*/
    List<Map<String , Object>> findRoles(@Param("page") Integer page , @Param("limit") Integer limit);
}
