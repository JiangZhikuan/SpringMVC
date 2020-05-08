package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.domain.SysNews;
import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.service.SysNewsService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import com.jzk.simple.sys.utils.WebUtils;
import com.jzk.simple.sys.vo.SysNewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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

    /*
    * 加载所用新闻
    * */
    @ResponseBody
    @RequestMapping("loadAllNews")
    public DataGridView loadAllNews(SysNewsVo sysNewsVo){
        return this.sysNewsService.queryAllNews(sysNewsVo);
    }

    /*
    * 增加新闻
    * */
    @ResponseBody
    @RequestMapping("addNews")
    public ResultObj addNews(SysNewsVo sysNewsVo){
        try {
            SysUser sysUser=(SysUser) WebUtils.getHttpSession().getAttribute("user");
            sysNewsVo.setCreatetime(new Date());
            sysNewsVo.setOpername(sysUser.getRealname());
            this.sysNewsService.addNews(sysNewsVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /*
    * 修改新闻
    * */
    @ResponseBody
    @RequestMapping("updateNews")
    public ResultObj updateNews(SysNewsVo sysNewsVo){
        try {
            SysUser sysUser=(SysUser) WebUtils.getHttpSession().getAttribute("user");
            sysNewsVo.setCreatetime(new Date());
            sysNewsVo.setOpername(sysUser.getRealname());
            this.sysNewsService.updateNews(sysNewsVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            return ResultObj.UPDATE_ERROR;
        }
    }

    /*
    * 删除新闻
    * */
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

    /*
    * 批量删除
    * */
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

    /*
    * 根据Id查找新闻
    * */
    @ResponseBody
    @RequestMapping("loadNewsById")
    public SysNews loadNewsById(Integer id){
        return this.sysNewsService.loadNewsById(id);
    }
}
