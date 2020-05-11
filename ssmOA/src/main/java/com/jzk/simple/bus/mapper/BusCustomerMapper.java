package com.jzk.simple.bus.mapper;

import com.jzk.simple.bus.domain.BusCustomer;
import com.jzk.simple.bus.domain.BusCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusCustomerMapper {
    long countByExample(BusCustomerExample example);

    int deleteByExample(BusCustomerExample example);

    int deleteByPrimaryKey(String identity);

    int insert(BusCustomer record);

    int insertSelective(BusCustomer record);

    List<BusCustomer> selectByExample(BusCustomerExample example);

    BusCustomer selectByPrimaryKey(String identity);

    int updateByExampleSelective(@Param("record") BusCustomer record, @Param("example") BusCustomerExample example);

    int updateByExample(@Param("record") BusCustomer record, @Param("example") BusCustomerExample example);

    int updateByPrimaryKeySelective(BusCustomer record);

    int updateByPrimaryKey(BusCustomer record);

    List<BusCustomer> queryAllCustomer(BusCustomer busCustomer);
}