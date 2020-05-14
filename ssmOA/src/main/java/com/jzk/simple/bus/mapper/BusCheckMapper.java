package com.jzk.simple.bus.mapper;

import com.jzk.simple.bus.domain.BusCheck;
import com.jzk.simple.bus.domain.BusCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusCheckMapper {
    long countByExample(BusCheckExample example);

    int deleteByExample(BusCheckExample example);

    int deleteByPrimaryKey(String checkid);

    int insert(BusCheck record);

    int insertSelective(BusCheck record);

    List<BusCheck> selectByExample(BusCheckExample example);

    BusCheck selectByPrimaryKey(String checkid);

    int updateByExampleSelective(@Param("record") BusCheck record, @Param("example") BusCheckExample example);

    int updateByExample(@Param("record") BusCheck record, @Param("example") BusCheckExample example);

    int updateByPrimaryKeySelective(BusCheck record);

    int updateByPrimaryKey(BusCheck record);

    List<BusCheck> queryAllCheck(BusCheck busCheck);
}