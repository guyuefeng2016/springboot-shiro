package com.hu.dao;

import com.hu.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao{
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
    /**更新用户*/
    public void updateUser(UserInfo userInfo);
}
