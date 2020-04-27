package com.jzk.simple.sys.vo;

import com.jzk.simple.sys.domain.SysRole;

/**
 * ClassName:SysRoleVo
 * Package:com.jzk.simple.sys.vo
 * Description:
 *
 * @Date:2020/4/27 15:30
 * @Author:JiangZhikuan
 */
public class SysRoleVo extends SysRole {

    private Integer page;
    private Integer limit;

    //多个角色
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
