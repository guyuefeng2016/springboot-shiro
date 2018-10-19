package com.hu.web;

import com.hu.common.RestResult;
import com.hu.entity.SysRole;
import com.hu.entity.UserInfo;
import com.hu.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;


    /**
     *
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }

    //用户更新
    @RequestMapping("/userUpl")
    @RequiresPermissions("userInfo:upl")//权限管理;
    public String userUpdate(UserInfo userInfo ){
       userInfoService.updateUser(userInfo);
       return "userInfoUpl";
    }

    @RequestMapping("/userRole")
    @RequiresPermissions("userInfo:manageRole")
    public String roleManager(){
       return "role";
    }

    @RequestMapping("/getRole")
    @ResponseBody
    @RequiresPermissions("userInfo:manageRole")
    public RestResult<Map<String , Object>>  getRoles(Integer page , Integer limit){
        List<Map<String , Object>> roles = userInfoService.findRoles(page , limit);
        return RestResult.SUCCESS(roles);
    }

}
