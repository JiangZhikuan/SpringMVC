package com.jzk.simple.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzk.simple.sys.domain.SysNews;
import com.jzk.simple.sys.mapper.SysNewsMapper;
import com.jzk.simple.sys.service.SysNewsService;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysNewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:SysNewsServiceImpl
 * Package:com.jzk.simple.sys.service.impl
 * Description:
 *
 * @Date:2020/4/29 12:52
 * @Author:JiangZhikuan
 */
@Service
public class SysNewsServiceImpl implements SysNewsService {

    @Autowired
    private SysNewsMapper sysNewsMapper;

    @Override
    public DataGridView queryAllNews(SysNewsVo sysNewsVo) {
        Page<Object> page= PageHelper.startPage(sysNewsVo.getPage(),sysNewsVo.getLimit());
        List<SysNews> data=this.sysNewsMapper.queryAllNews(sysNewsVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addNews(SysNewsVo sysNewsVo) {
        this.sysNewsMapper.insertSelective(sysNewsVo);
    }

    @Override
    public void updateNews(SysNewsVo sysNewsVo) {
        this.sysNewsMapper.updateByPrimaryKey(sysNewsVo);
    }

    @Override
    public void deleteNews(Integer newId) {
        this.sysNewsMapper.deleteByPrimaryKey(newId);
    }

    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer id:ids){
            this.deleteNews(id);
        }
    }
}
