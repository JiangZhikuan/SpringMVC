package com.jzk.simple.bus.controller;

import com.jzk.simple.bus.domain.BusRent;
import com.jzk.simple.bus.service.BusCheckService;
import com.jzk.simple.bus.service.BusRentService;
import com.jzk.simple.bus.vo.BusCheckVo;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * ClassName:BusCheckController
 * Package:com.jzk.simple.bus.controller
 * Description:
 *
 * @Date:2020/5/14 12:55
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("check")
public class BusCheckController {

    @Autowired
    private BusRentService busRentService;

    @Autowired
    private BusCheckService busCheckService;

    /***
     * 根据出租单号查询出租单信息
     */
    @ResponseBody
    @RequestMapping("checkRentExist")
    public BusRent checkRentExist(String rentid) {
        BusRent rent=this.busRentService.queryRentByRentId(rentid);//null   返回对象
        return rent;
    }

    /**
     * 根据出租单号加载检查单的表单数据
     */
    @ResponseBody
    @RequestMapping("initCheckFormData")
    public Map<String,Object> initCheckFormData(String rentId){
        return this.busCheckService.initCheckFormData(rentId);
    }


    @ResponseBody
    @RequestMapping("loadAllCheck")
    public DataGridView loadAllCheck(BusCheckVo busCheckVo){
        return this.busCheckService.queryAllCheck(busCheckVo);
    }

    /**
     * 保存检查单数据
     */
    @ResponseBody
    @RequestMapping("saveCheck")
    public ResultObj saveCheck(BusCheckVo checkVo) {
        try {
            checkVo.setCreatetime(new Date());
            this.busCheckService.addCheck(checkVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改检查单数据
     */
    @ResponseBody
    @RequestMapping("updateCheck")
    public ResultObj updateCheck(BusCheckVo checkVo) {
        try {
            this.busCheckService.updateCheck(checkVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
}
