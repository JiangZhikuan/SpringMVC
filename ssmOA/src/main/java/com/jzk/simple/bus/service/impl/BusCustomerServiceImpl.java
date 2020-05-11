package com.jzk.simple.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.bus.domain.BusCustomer;
import com.jzk.simple.bus.mapper.BusCustomerMapper;
import com.jzk.simple.bus.service.BusCustomerService;
import com.jzk.simple.bus.vo.BusCustomerVo;
import com.jzk.simple.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:BusCustomerServiceImpl
 * Package:com.jzk.simple.bus.service.impl
 * Description:
 *
 * @Date:2020/5/9 10:23
 * @Author:JiangZhikuan
 */
@Service
public class BusCustomerServiceImpl implements BusCustomerService {

    @Autowired
    private BusCustomerMapper busCustomerMapper;

    /*
    * 查询所有客户列表
    * */
    @Override
    public DataGridView queryAllBusCustomer(BusCustomerVo busCustomerVo) {

        Page<Object> page=
                PageHelper.startPage(busCustomerVo.getPage(),busCustomerVo.getLimit());
        List<BusCustomer> busCustomers=this.busCustomerMapper.queryAllCustomer(busCustomerVo);
        return new DataGridView(page.getTotal(),busCustomers);
    }

    /*
    * 添加客户
    * */
    @Override
    public void addCustomer(BusCustomerVo busCustomerVo) {
        this.busCustomerMapper.insertSelective(busCustomerVo);
    }

    /*
    * 修改客户
    * */
    @Override
    public void updateCustomer(BusCustomerVo busCustomerVo) {
        this.busCustomerMapper.updateByPrimaryKeySelective(busCustomerVo);
    }

    /*
    * 删除客户
    * */
    @Override
    public void deleteCustomer(String identity) {
        this.busCustomerMapper.deleteByPrimaryKey(identity);
    }

    /*
    * 批量删除
    * */
    @Override
    public void deleteBatchCustomer(String[] identitys) {
        for (String identity:identitys){
            deleteCustomer(identity);
        }
    }
}
