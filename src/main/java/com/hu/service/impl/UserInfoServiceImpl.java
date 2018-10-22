package com.hu.service.impl;

import com.hu.dao.UserInfoDao;
import com.hu.entity.SysPermission;
import com.hu.entity.SysRole;
import com.hu.entity.UserInfo;
import com.hu.service.UserInfoService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        if (!StringUtils.isEmpty(userInfo.getPassword())){
            UserInfo userInfo1 = findByUsername(userInfo.getUsername());
            //修改密码
            SimpleHash simpleHash = new SimpleHash("md5", userInfo.getPassword() , userInfo1.getCredentialsSalt() , 2);
            userInfo.setPassword(simpleHash.toString());
        }
        userInfoDao.updateUser(userInfo);
    }

    @Override
    public List<Map<String , Object>> findRoles(Integer page , Integer limit) {
        return userInfoDao.findRoles(page , limit);
    }

    @Override
    public void addRole(SysRole role) {
       userInfoDao.addRole(role);
    }

    @Override
    public void removeRole(Integer id) {
        userInfoDao.removeRole(id);
    }

    @Override
    public void updateRole(SysRole role) {
        userInfoDao.updateRole(role);
    }

    @Override
    public List<SysPermission> getAllPermission() {
        return userInfoDao.getAllPermission();
    }

    @Override
    public List<SysPermission> getRolePermission(Integer id) {
        return userInfoDao.getRolePermission(id);
    }

}
