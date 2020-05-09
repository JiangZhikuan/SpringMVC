package com.jzk.simple.bus.service;

import com.jzk.simple.bus.domain.BusCar;
import com.jzk.simple.bus.vo.BusCarVo;
import com.jzk.simple.sys.utils.DataGridView;

import javax.print.DocFlavor;

/**
 * InterfaceName:BusCarService
 * Package:com.jzk.simple.bus.service
 * Description:
 *
 * @Date:2020/5/9 15:09
 * @Author:JiangZhikuan
 */

public interface BusCarService {

    DataGridView queryAllCar(BusCarVo busCarVo);

    BusCar queryCarByCarNumber(String carNumber);

    void addCar(BusCarVo busCarVo);

    void  updateCar(BusCarVo busCarVo);

    void deleteCar(String carNumber);

    void deleteBatchCar(String[] carNumbers);
}
