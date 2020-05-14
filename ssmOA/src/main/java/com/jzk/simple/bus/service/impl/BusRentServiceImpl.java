package com.jzk.simple.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.bus.domain.BusCar;
import com.jzk.simple.bus.domain.BusRent;
import com.jzk.simple.bus.mapper.BusCarMapper;
import com.jzk.simple.bus.mapper.BusRentMapper;
import com.jzk.simple.bus.service.BusRentService;
import com.jzk.simple.bus.vo.BusRentVo;
import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:BusRentServiceImpl
 * Package:com.jzk.simple.bus.service.impl
 * Description:
 *
 * @Date:2020/5/14 9:50
 * @Author:JiangZhikuan
 */
@Service
public class BusRentServiceImpl implements BusRentService {

    @Autowired
    private BusRentMapper busRentMapper;

    @Autowired
    private BusCarMapper busCarMapper;

    @Override
    public void addRent(BusRentVo busRentVo) {
        this.busRentMapper.insertSelective(busRentVo);
        BusCar busCar=new BusCar();
        busCar.setCarnumber(busRentVo.getCarnumber());
        busCar.setIsrenting(SysConstast.RENT_CAR_TRUE);
        this.busCarMapper.updateByPrimaryKeySelective(busCar);
    }

    @Override
    public DataGridView queryAllRent(BusRentVo busRentVo) {
        Page<Object> page=
                PageHelper.startPage(busRentVo.getPage(),busRentVo.getLimit());
        List<BusRent> busRents=
                this.busRentMapper.queryAllRent(busRentVo);
        return new DataGridView(page.getTotal(),busRents);
    }

    @Override
    public void updateRent(BusRentVo busRentVo) {
        this.busRentMapper.updateByPrimaryKeySelective(busRentVo);
    }

    @Override
    public void deleteRent(String rentId) {
        this.busRentMapper.deleteByPrimaryKey(rentId);
    }

    @Override
    public BusRent queryRentByRentId(String renId) {
        return this.busRentMapper.selectByPrimaryKey(renId);
    }
}
