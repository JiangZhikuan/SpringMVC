package com.jzk.simple.bus.mapper;

import com.jzk.simple.bus.domain.BusCar;
import com.jzk.simple.bus.domain.BusCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusCarMapper {
    long countByExample(BusCarExample example);

    int deleteByExample(BusCarExample example);

    int deleteByPrimaryKey(String carnumber);

    int insert(BusCar record);

    int insertSelective(BusCar record);

    List<BusCar> selectByExample(BusCarExample example);

    BusCar selectByPrimaryKey(String carnumber);

    int updateByExampleSelective(@Param("record") BusCar record, @Param("example") BusCarExample example);

    int updateByExample(@Param("record") BusCar record, @Param("example") BusCarExample example);

    int updateByPrimaryKeySelective(BusCar record);

    int updateByPrimaryKey(BusCar record);

    List<BusCar> queryAllCar(BusCar busCar);
}