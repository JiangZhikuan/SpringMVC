package com.jzk.simple.bus.service;

import com.jzk.simple.bus.vo.BusCheckVo;
import com.jzk.simple.sys.utils.DataGridView;

import java.util.Map;

/**
 * InterfaceName:BusCheckService
 * Package:com.jzk.simple.bus.service
 * Description:
 *
 * @Date:2020/5/14 12:50
 * @Author:JiangZhikuan
 */

public interface BusCheckService {


    Map<String, Object> initCheckFormData(String rentId);

    DataGridView queryAllCheck(BusCheckVo busCheckVo);

    void updateCheck(BusCheckVo busCheckVo);

    void addCheck(BusCheckVo checkVo);
}
