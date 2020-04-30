package com.jzk.simple.sys.service;

import com.jzk.simple.sys.domain.SysNews;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysNewsVo;

/**
 * InterfaceName:SysNewsService
 * Package:com.jzk.simple.sys.service
 * Description:
 *
 * @Date:2020/4/29 12:52
 * @Author:JiangZhikuan
 */

public interface SysNewsService {

    DataGridView queryAllNews(SysNewsVo sysNewsVo);

    void addNews(SysNewsVo sysNewsVo);

    void updateNews(SysNewsVo sysNewsVo);

    void deleteNews(Integer newId);

    void deleteBatchNews(Integer[] ids);

    SysNews loadNewsById(Integer id);
}
