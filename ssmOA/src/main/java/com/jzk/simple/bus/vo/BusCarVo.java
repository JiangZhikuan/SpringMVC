package com.jzk.simple.bus.vo;

import com.jzk.simple.bus.domain.BusCar;

/**
 * ClassName:BusCarVo
 * Package:com.jzk.simple.bus.vo
 * Description:
 *
 * @Date:2020/5/9 15:08
 * @Author:JiangZhikuan
 */
public class BusCarVo extends BusCar {
    /*
     * 分页参数
     * */
    private Integer page;
    private Integer limit;

    //接收多个ids
    private String[] ids;

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

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
