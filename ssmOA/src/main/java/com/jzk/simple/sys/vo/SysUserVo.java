package com.jzk.simple.sys.vo;

import com.jzk.simple.sys.domain.SysUser;

/**
 * ClassName:SysUserVo
 * Package:com.jzk.simple.sys.vo
 * Description:
 *
 * @Date:2020/4/22 21:54
 * @Author:JZK
 */
public class SysUserVo extends SysUser {

    private Integer page;
    private Integer limit;

    private Integer[] ids;

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

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
