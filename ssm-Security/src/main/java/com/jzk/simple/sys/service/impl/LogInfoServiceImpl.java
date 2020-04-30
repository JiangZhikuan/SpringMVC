package com.jzk.simple.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.sys.domain.SysLogLogin;
import com.jzk.simple.sys.mapper.SysLogLoginMapper;
import com.jzk.simple.sys.service.LogInfoService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysLogLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:LogInfoServiceImpl
 * Package:com.jzk.simple.sys.service.impl
 * Description:
 *
 * @Date:2020/4/29 9:49
 * @Author:JiangZhikuan
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private SysLogLoginMapper sysLogLoginMapper;

    @Override
    public DataGridView queryAllLoginInfo(SysLogLoginVo sysLogLoginVo) {
        Page<Object> page= PageHelper.startPage(sysLogLoginVo.getPage(),sysLogLoginVo.getLimit());
        List<SysLogLogin> data=this.sysLogLoginMapper.queryAllLoginInfo(sysLogLoginVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addLogInfo(SysLogLoginVo sysLogLoginVo) {
        this.sysLogLoginMapper.insertSelective(sysLogLoginVo);
    }

    @Override
    public void deleteLogInfo(Integer logInfoId) {
        this.sysLogLoginMapper.deleteByPrimaryKey(logInfoId);
    }

    @Override
    public void deleteBatchLogInfo(Integer[] ids) {
        for (Integer id:ids){
            this.deleteLogInfo(id);
        }
    }
}
