package com.jzk.simple.bus.service;

import com.jzk.simple.bus.domain.BusRent;
import com.jzk.simple.bus.vo.BusRentVo;
import com.jzk.simple.sys.utils.DataGridView;

/**
 * InterfaceName:BusRentService
 * Package:com.jzk.simple.bus.service
 * Description:
 *
 * @Date:2020/5/14 9:50
 * @Author:JiangZhikuan
 */

public interface BusRentService {

    void addRent(BusRentVo busRentVo);

    DataGridView queryAllRent(BusRentVo busRentVo);

    void updateRent(BusRentVo busRentVo);

    void deleteRent(String rentId);

    BusRent queryRentByRentId(String renId);
}
