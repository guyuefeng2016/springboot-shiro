package com.hu.dao;

import com.hu.entity.SysPermission;
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
    /**添加角色信息*/
    void addRole(SysRole role);
    /**删除角色*/
    void removeRole(Integer id);
    /**更新角色信息*/
    void updateRole(SysRole role);
    /**得到所有权限*/
    List<SysPermission> getAllPermission();
    /**得到某角色所有权限*/
    List<SysPermission> getRolePermission(Integer id);
}
