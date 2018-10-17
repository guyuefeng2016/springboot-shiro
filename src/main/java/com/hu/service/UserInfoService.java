package com.hu.service;

import com.hu.entity.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

    /**更新用户信息 **/
    public void updateUser(UserInfo userInfo);
}
