package com.hu.service;

import com.hu.entity.SysRole;
import com.hu.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);

    /**更新用户信息 **/
    void updateUser(UserInfo userInfo);

    /**查询所有的角色信息*/
    List<Map<String , Object>> findRoles(Integer page , Integer limit);
}
