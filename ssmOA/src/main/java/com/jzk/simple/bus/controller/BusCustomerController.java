package com.jzk.simple.bus.controller;

import com.jzk.simple.bus.service.BusCustomerService;
import com.jzk.simple.bus.vo.BusCustomerVo;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * ClassName:BusCustomerController
 * Package:com.jzk.simple.bus.controller
 * Description:
 *
 * @Date:2020/5/9 10:29
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("customer")
public class BusCustomerController {

    @Autowired
    private BusCustomerService busCustomerService;


    /*
    * 查询所有客户列表
    * */
    @ResponseBody
    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(BusCustomerVo busCustomerVo){
        return this.busCustomerService.queryAllBusCustomer(busCustomerVo);
    }

    /*
    * 增加客户信息
    * */
    @ResponseBody
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(BusCustomerVo busCustomerVo){
        try {
            busCustomerVo.setCreatetime(new Date());
            this.busCustomerService.addCustomer(busCustomerVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /*
    * 修改客户信息
    * */
    @ResponseBody
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(BusCustomerVo busCustomerVo){
        try {
            this.busCustomerService.updateCustomer(busCustomerVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /*
    * 删除客户
    * */
    @ResponseBody
    @RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(BusCustomerVo busCustomerVo){
        try {
            this.busCustomerService.deleteCustomer(busCustomerVo.getIdentity());
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
    @RequestMapping("deleteBatchCustomer")
    public ResultObj deleteBatchCustomer(BusCustomerVo busCustomerVo){
        try {
            this.busCustomerService.deleteBatchCustomer(busCustomerVo.getIdentitys());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
