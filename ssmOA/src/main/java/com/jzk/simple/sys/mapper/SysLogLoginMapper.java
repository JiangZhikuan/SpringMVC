package com.jzk.simple.sys.mapper;

import com.jzk.simple.sys.domain.SysLogLogin;
import com.jzk.simple.sys.domain.SysLogLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogLoginMapper {
    long countByExample(SysLogLoginExample example);

    int deleteByExample(SysLogLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLogLogin record);

    int insertSelective(SysLogLogin record);

    List<SysLogLogin> selectByExample(SysLogLoginExample example);

    SysLogLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLogLogin record, @Param("example") SysLogLoginExample example);

    int updateByExample(@Param("record") SysLogLogin record, @Param("example") SysLogLoginExample example);

    int updateByPrimaryKeySelective(SysLogLogin record);

    int updateByPrimaryKey(SysLogLogin record);

    List<SysLogLogin> queryAllLoginInfo(SysLogLogin sysLogLogin);
}