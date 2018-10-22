package com.hu.web;

import com.hu.common.RestResult;
import com.hu.entity.SysPermission;
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
        List<Map<String , Object>> roles = userInfoService.findRoles(page-1 , limit);
        return RestResult.SUCCESS(roles);
    }

    @RequestMapping("/addRole")
    @ResponseBody
    @RequiresPermissions("userInfo:manageRole")
    public RestResult<String> addRole(SysRole role){
        try {
            userInfoService.addRole(role);
            return RestResult.SUCCESS(null,"角色新增成功");
        } catch (Exception e){
            return RestResult.ERROR(e.getMessage());
        }
    }

    @RequestMapping("/delRole")
    @ResponseBody
    @RequiresPermissions("userInfo:manageRole")
    public RestResult<String> delRole(Integer id){
        try {
            userInfoService.removeRole(id);
            return RestResult.SUCCESS(null,"角色删除成功");
        } catch (Exception e){
            return RestResult.ERROR(e.getMessage());
        }
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    @RequiresPermissions("userInfo:manageRole")
    public RestResult<String> updateRole(SysRole role){
        try {
            userInfoService.updateRole(role);
            return RestResult.SUCCESS(null,"角色更新成功");
        } catch (Exception e){
            return RestResult.ERROR(e.getMessage());
        }
    }

    @RequestMapping("/getAllPermission")
    @ResponseBody
    @RequiresPermissions("userInfo:manageRole")
    public RestResult<SysPermission> getAllPermission(){
        try {
            List<SysPermission> permissions = userInfoService.getAllPermission();
            return RestResult.SUCCESS(permissions,"查询所有权限成功");
        } catch (Exception e){
            return RestResult.ERROR(e.getMessage());
        }
    }

    @RequestMapping("/getRolePermission")
    @ResponseBody
    @RequiresPermissions("userInfo:manageRole")
    public RestResult<SysPermission> getRolePermission(Integer id){
        try {
            List<SysPermission> permissions = userInfoService.getRolePermission(id);
            return RestResult.SUCCESS(permissions,"查询角色权限成功");
        } catch (Exception e){
            return RestResult.ERROR(e.getMessage());
        }
    }


}
