package com.jzk.simple.bus.controller;

import com.jzk.simple.bus.domain.BusCustomer;
import com.jzk.simple.bus.service.BusCustomerService;
import com.jzk.simple.bus.service.BusRentService;
import com.jzk.simple.bus.vo.BusRentVo;
import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.RandomUtils;
import com.jzk.simple.sys.utils.ResultObj;
import com.jzk.simple.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * ClassName:BusRentController
 * Package:com.jzk.simple.bus.controller
 * Description:
 *
 * @Date:2020/5/14 9:52
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("rent")
public class BusRentController {

    @Autowired
    private BusCustomerService busCustomerService;

    @Autowired
    private BusRentService busRentService;

    @ResponseBody
    @RequestMapping("checkCustomerExist")
    public ResultObj checkCustomerExits(BusRentVo busRentVo){
        BusCustomer busCustomer=
                this.busCustomerService.queryCustomerByIdentity(busRentVo.getIdentity());
        if(busCustomer!=null){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }

    @ResponseBody
    @RequestMapping("loadAllRent")
    public DataGridView loadAllRent(BusRentVo busRentVo){
        return  this.busRentService.queryAllRent(busRentVo);
    }

    @ResponseBody
    @RequestMapping("updateRent")
    public ResultObj updateRent(BusRentVo busRentVo){
        try {
            //保存
            this.busRentService.updateRent(busRentVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @ResponseBody
    @RequestMapping("deleteRent")
    public ResultObj deleteRent(BusRentVo busRentVo){
        try {
            this.busRentService.deleteRent(busRentVo.getRentid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }

    /**
     * 初始化添加出租单的表单数据
     */
    @ResponseBody
    @RequestMapping("initRentFrom")
    public BusRentVo initRentFrom(BusRentVo rentVo) {
        //生成出租单号
        rentVo.setRentid(RandomUtils.careteTandomStringUseTime(SysConstast.CAR_ORDER_CZ));
        //设置起租时间
        rentVo.setBegindate(new Date());

        SysUser user=(SysUser) WebUtils.getHttpSession().getAttribute("user");
        //设置操作员
        rentVo.setOpername(user.getRealname());
        return rentVo;
    }

    /**
     * 保存出租单信息
     */
    @ResponseBody
    @RequestMapping("saveRent")
    public ResultObj saveRent(BusRentVo rentVo) {
        try {
            //设置创建时间
            rentVo.setCreatetime(new Date());
            //设置归还状态
            rentVo.setRentflag(SysConstast.RENT_BACK_FALSE);

            //保存
            this.busRentService.addRent(rentVo);

            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
}
