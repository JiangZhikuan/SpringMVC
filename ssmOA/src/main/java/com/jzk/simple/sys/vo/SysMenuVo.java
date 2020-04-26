package com.jzk.simple.sys.vo;

import com.jzk.simple.sys.domain.SysMenu;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:SysMenuVo
 * Package:com.jzk.simple.sys.vo
 * Description:
 *
 * @Date:2020/4/24 11:34
 * @Author:JiangZhikuan
 */
public class SysMenuVo extends SysMenu  {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

