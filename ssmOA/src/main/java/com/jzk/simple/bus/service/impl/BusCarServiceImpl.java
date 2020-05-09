package com.jzk.simple.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.bus.domain.BusCar;
import com.jzk.simple.bus.mapper.BusCarMapper;
import com.jzk.simple.bus.service.BusCarService;
import com.jzk.simple.bus.vo.BusCarVo;
import com.jzk.simple.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:BusCarServiceImpl
 * Package:com.jzk.simple.bus.service.impl
 * Description:
 *
 * @Date:2020/5/9 15:09
 * @Author:JiangZhikuan
 */
@Service
public class BusCarServiceImpl implements BusCarService {

    @Autowired
    private BusCarMapper busCarMapper;

    @Override
    public DataGridView queryAllCar(BusCarVo busCarVo) {

        Page<Object> page= PageHelper.startPage(busCarVo.getPage(),busCarVo.getLimit());
        List<BusCar> busCars=this.busCarMapper.queryAllCar(busCarVo);
        return new DataGridView(page.getTotal(),busCars);
    }

    @Override
    public BusCar queryCarByCarNumber(String carNumber) {
        return this.busCarMapper.selectByPrimaryKey(carNumber);
    }

    @Override
    public void addCar(BusCarVo busCarVo) {
        this.busCarMapper.insertSelective(busCarVo);
    }

    @Override
    public void updateCar(BusCarVo busCarVo) {
        this.busCarMapper.updateByPrimaryKeySelective(busCarVo);
    }

    @Override
    public void deleteCar(String carNumber) {
        this.busCarMapper.deleteByPrimaryKey(carNumber);
    }

    @Override
    public void deleteBatchCar(String[] carNumbers) {
        for (String carName:carNumbers){
            this.deleteCar(carName);
        }
    }
}
