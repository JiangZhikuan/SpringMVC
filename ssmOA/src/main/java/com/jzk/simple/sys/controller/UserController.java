package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.service.SysUserService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import com.jzk.simple.sys.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:UserController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *
 * @Date:2020/4/28 13:23
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    /*
    * 返回user列表
    * */
    @ResponseBody
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(SysUserVo sysUserVo){
        return this.sysUserService.queryAllUser(sysUserVo);
    }

    /*
    * 增加用户
    * */
    @ResponseBody
    @RequestMapping("addUser")
    public ResultObj addUser(SysUserVo sysUserVo){
        try {
            this.sysUserService.addUser(sysUserVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /*
    * 修改用户
    * */
    @ResponseBody
    @RequestMapping("updateUser")
    public ResultObj updateUser(SysUserVo sysUserVo){
        try {
            this.sysUserService.updateUser(sysUserVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /*
    * 删除用户
    * */
    @ResponseBody
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(SysUserVo sysUserVo){
        try {
            this.sysUserService.deleteUser(sysUserVo.getUserid());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /*
    *批量删除用户
    * */
    @ResponseBody
    @RequestMapping("deleteBatchUser")
    public ResultObj deleteBatchUser(SysUserVo sysUserVo){
        try {
            this.sysUserService.deleteBatchUser(sysUserVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return  ResultObj.DELETE_ERROR;
        }
    }

    /*
    * 重置密码
    * */
    @ResponseBody
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(SysUserVo sysUserVo){
        try {
            this.sysUserService.resetUserPwd(sysUserVo.getUserid());
            return ResultObj.RESET_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }

    /*
    * 加载用户管理分配角色
    * */
    @ResponseBody
    @RequestMapping("initUserRole")
    public DataGridView initUserRole(SysUserVo sysUserVo){
        return this.sysUserService.queryUserRole(sysUserVo.getUserid());
    }

    /*
    * 保存用户角色关系
    * */
    @ResponseBody
    @RequestMapping("saveUserRole")
    public ResultObj saveUserRole(SysUserVo sysUserVo){
        try {
            this.sysUserService.saveUserRole(sysUserVo);
            return ResultObj.DISPATCH_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }
}
