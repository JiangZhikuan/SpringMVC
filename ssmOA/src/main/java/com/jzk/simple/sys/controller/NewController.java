package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.service.SysNewsService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import com.jzk.simple.sys.vo.SysNewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:NewController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *
 * @Date:2020/4/29 13:01
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("news")
public class NewController {

    @Autowired
    private SysNewsService sysNewsService;

    @ResponseBody
    @RequestMapping("loadAllNews")
    public DataGridView loadAllNews(SysNewsVo sysNewsVo){
        return this.sysNewsService.queryAllNews(sysNewsVo);
    }

    @ResponseBody
    @RequestMapping("addNews")
    public ResultObj addNews(SysNewsVo sysNewsVo){
        try {
            this.sysNewsService.addNews(sysNewsVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("updateNews")
    public ResultObj updateNews(SysNewsVo sysNewsVo){
        try {
            this.sysNewsService.updateNews(sysNewsVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            return ResultObj.UPDATE_ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("deleteNews")
    public ResultObj deleteNews(SysNewsVo sysNewsVo){
        try {
            this.sysNewsService.deleteNews(sysNewsVo.getId());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("deleteBatchNews")
    public ResultObj deleteBatchNews(SysNewsVo sysNewsVo){
        try {
            this.sysNewsService.deleteBatchNews(sysNewsVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
