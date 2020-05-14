package com.jzk.simple.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.bus.domain.BusCar;
import com.jzk.simple.bus.domain.BusCheck;
import com.jzk.simple.bus.domain.BusCustomer;
import com.jzk.simple.bus.domain.BusRent;
import com.jzk.simple.bus.mapper.BusCarMapper;
import com.jzk.simple.bus.mapper.BusCheckMapper;
import com.jzk.simple.bus.mapper.BusCustomerMapper;
import com.jzk.simple.bus.mapper.BusRentMapper;
import com.jzk.simple.bus.service.BusCheckService;
import com.jzk.simple.bus.vo.BusCheckVo;
import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.RandomUtils;
import com.jzk.simple.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:BusCheckServiceImpl
 * Package:com.jzk.simple.bus.service.impl
 * Description:
 *
 * @Date:2020/5/14 12:51
 * @Author:JiangZhikuan
 */
@Service
public class BusCheckServiceImpl implements BusCheckService {

    @Autowired
    private BusCheckMapper busCheckMapper;

    @Autowired
    private BusCustomerMapper busCustomerMapper;

    @Autowired
    private BusRentMapper busRentMapper;
    @Autowired
    private BusCarMapper busCarMapper;

    @Override
    public Map<String, Object> initCheckFormData(String rentId) {
       //查询出租单
        BusRent rent=this.busRentMapper.selectByPrimaryKey(rentId);
        //查询客户
        BusCustomer customer=this.busCustomerMapper.selectByPrimaryKey(rent.getIdentity());
        //查询车辆
        BusCar car=this.busCarMapper.selectByPrimaryKey(rent.getCarnumber());
        //组装Check
        BusCheck check=new BusCheck();
        check.setCheckid(RandomUtils.careteTandomStringUseTime(SysConstast.CAR_ORDER_JC));
        check.setRentid(rentId);
        check.setCheckdate(new Date());
        SysUser user=(SysUser) WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());

        Map<String, Object> map= new HashMap<>();

        map.put("rent", rent);
        map.put("customer", customer);
        map.put("car", car);
        map.put("check", check);
        return map;
    }

    @Override
    public DataGridView queryAllCheck(BusCheckVo busCheckVo) {
        Page<Object> page=
                PageHelper.startPage(busCheckVo.getPage(),busCheckVo.getLimit());
        List<BusCheck> busChecks=
                this.busCheckMapper.queryAllCheck(busCheckVo);
        return new DataGridView(page.getTotal(),busChecks);
    }

    @Override
    public void updateCheck(BusCheckVo busCheckVo) {
        this.busCheckMapper.updateByPrimaryKeySelective(busCheckVo);
    }

    @Override
    public void addCheck(BusCheckVo checkVo) {
        this.busCheckMapper.insertSelective(checkVo);
        //更改出租单的状态
        BusRent rent=this.busRentMapper.selectByPrimaryKey(checkVo.getRentid());
        rent.setRentflag(SysConstast.RENT_BACK_TRUE);
        this.busRentMapper.updateByPrimaryKeySelective(rent);
        //更改汽车的状态
        BusCar car=new BusCar();
        car.setCarnumber(rent.getCarnumber());
        car.setIsrenting(SysConstast.RENT_CAR_FALSE);
        this.busCarMapper.updateByPrimaryKeySelective(car);
    }
}
