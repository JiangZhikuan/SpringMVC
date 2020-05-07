package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.domain.SysLogLogin;
import com.jzk.simple.sys.service.LogInfoService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import com.jzk.simple.sys.vo.SysLogLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:LogInfoController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *              Controller日志记录控制器
 * @Date:2020/4/29 9:58
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("logInfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;

    /*
    * 加载所有日志
    * */
    @ResponseBody
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(SysLogLoginVo sysLogLoginVo){
        return this.logInfoService.queryAllLoginInfo(sysLogLoginVo);
    }

    /*
    * 删除选中日志
    * */
    @ResponseBody
    @RequestMapping("deleteLogInfo")
    public ResultObj deleteLogInfo(SysLogLoginVo sysLogLoginVo){
        try {
            this.logInfoService.deleteLogInfo(sysLogLoginVo.getId());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /*
    * 批量删除日志
    * */
    @ResponseBody
    @RequestMapping("deleteBatchLogInfo")
    public ResultObj deleteBatchLogInfo(SysLogLoginVo sysLogLoginVo){
        try {
            this.logInfoService.deleteBatchLogInfo(sysLogLoginVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
