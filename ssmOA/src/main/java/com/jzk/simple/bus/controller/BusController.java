package com.jzk.simple.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:BusController
 * Package:com.jzk.simple.bus.controller
 * Description:
 *
 * @Date:2020/5/9 10:33
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("bus")
public class BusController {

    @RequestMapping("toCustomerManager")
    public String toCustomerManager(){
        return "business/customer/customerManager";
    }

    @RequestMapping("toCarManager")
    public String toCarManager(){
        return "business/car/carManager";
    }

    @RequestMapping("toRentCarManager")
    public String toRentCarManager(){
        return "business/rent/rentCarManager";
    }
    /**
     * 跳转到出租单管理的页面
     */
    @RequestMapping("toRentManager")
    public String toRentManager() {
        return "business/rent/rentManager";
    }

    /**
     * 跳转到汽车入库管理的页面
     */
    @RequestMapping("toCheckCarManager")
    public String toCheckCarManager() {
        return "business/check/checkCarManager";
    }

    /**
     * 跳转到检查单管理的页面
     */
    @RequestMapping("toCheckManager")
    public String toCheckManager() {
        return "business/check/checkManager";
    }
}
