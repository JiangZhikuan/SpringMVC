package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.service.SysRoleService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import com.jzk.simple.sys.vo.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:RoleController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *
 * @Date:2020/4/27 15:43
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /*
    * 加载角色列表
    * */
    @ResponseBody
    @RequestMapping("loadAllRole")
    public DataGridView loadAllRole(SysRoleVo sysRoleVo){
        return this.sysRoleService.queryAllRole(sysRoleVo);
    }

    /*
    * 添加角色
    * */
    @ResponseBody
    @RequestMapping("addRole")
    public ResultObj addRole(SysRoleVo sysRoleVo){
        try {
            this.sysRoleService.addRole(sysRoleVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /*
    * 修改角色
    * */
    @ResponseBody
    @RequestMapping("updateRole")
    public ResultObj updateRole(SysRoleVo sysRoleVo){
        try {
            this.sysRoleService.updateRole(sysRoleVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /*
    * 删除角色
    * */
    @ResponseBody
    @RequestMapping("deleteRole")
    public ResultObj deleteRole(SysRoleVo sysRoleVo){
        try {
            this.sysRoleService.deleteRole(sysRoleVo.getRoleid());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /*
    * 批量删除角色
    * */
    @ResponseBody
    @RequestMapping("deleteBatchRole")
    public ResultObj deleteBatchRole(SysRoleVo sysRoleVo){
        try {
            this.sysRoleService.deleteBatchRole(sysRoleVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /*
    * 加载角色管理
    * */
    @ResponseBody
    @RequestMapping("initRoleMenuTreeJson")
    public DataGridView initRoleMenuTreeJson(Integer roleid){
        return this.sysRoleService.initRoleMenuTreeJson(roleid);
    }

    /*
    *保存角色和菜单关系
    * */
    @ResponseBody
    @RequestMapping("saveRoleMenu")
    public ResultObj saveRoleMenu(SysRoleVo sysRoleVo){
        try {
            this.sysRoleService.saveRoleMenu(sysRoleVo);
            return ResultObj.DISPATCH_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }

}
