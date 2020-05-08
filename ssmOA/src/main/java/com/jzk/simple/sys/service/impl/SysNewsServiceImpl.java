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

    /**
     * @param sysNewsVo
     * @return com.jzk.simple.sys.utils.DataGridView
     * @author JiangZhikuan
     * @Description: 查询所用新闻
     * @date 2020/5/7 17:06
     */
    @Override
    public DataGridView queryAllNews(SysNewsVo sysNewsVo) {
        Page<Object> page= PageHelper.startPage(sysNewsVo.getPage(),sysNewsVo.getLimit());
        List<SysNews> data=this.sysNewsMapper.queryAllNews(sysNewsVo);
        return new DataGridView(page.getTotal(),data);
    }
    /**
     * @param sysNewsVo
     * @return void
     * @author JiangZhikuan
     * @Description: 增加新闻
     * @date 2020/5/7 17:06
     */
    @Override
    public void addNews(SysNewsVo sysNewsVo) {
        this.sysNewsMapper.insertSelective(sysNewsVo);
    }
    /**
     * @param sysNewsVo
     * @return void
     * @author JiangZhikuan
     * @Description: 修改新闻
     * @date 2020/5/7 17:08
     */
    @Override
    public void updateNews(SysNewsVo sysNewsVo) {
        this.sysNewsMapper.updateByPrimaryKey(sysNewsVo);
    }

    /**
     * @param newId 
     * @return void
     * @author JiangZhikuan
     * @Description: 删除新闻
     * @date 2020/5/7 17:10
     */
    @Override
    public void deleteNews(Integer newId) {
        this.sysNewsMapper.deleteByPrimaryKey(newId);
    }

    /**
     * @param: ids
     * @return: void
     * @author:JiangZhikuan
     * @Description: 批量删除
     * @date: 2020/5/7 17:11
     */
    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer id:ids){
            this.deleteNews(id);
        }
    }

    /**
     * @param id 
     * @return com.jzk.simple.sys.domain.SysNews
     * @author JiangZhikuan
     * @Description:g根据新闻id加载
     * @date 2020/5/7 17:11
     */
    @Override
    public SysNews loadNewsById(Integer id) {
        return this.sysNewsMapper.selectByPrimaryKey(id);
    }
}
