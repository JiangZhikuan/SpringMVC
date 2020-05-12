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

}
