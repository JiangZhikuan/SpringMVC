package com.jzk.simple.bus.service;

import com.jzk.simple.bus.vo.BusCustomerVo;
import com.jzk.simple.sys.utils.DataGridView;

/**
 * ClassName:BusCustomerService
 * Package:com.jzk.simple.bus.service
 * Description:
 *
 * @Date:2020/5/9 10:20
 * @Author:JiangZhikuan
 */
public interface BusCustomerService {

    DataGridView queryAllBusCustomer(BusCustomerVo busCustomerVo);

    void addCustomer(BusCustomerVo busCustomerVo);

    void updateCustomer(BusCustomerVo busCustomerVo);

    void deleteCustomer(String identity);

    void deleteBatchCustomer(String[] identitys);

}
