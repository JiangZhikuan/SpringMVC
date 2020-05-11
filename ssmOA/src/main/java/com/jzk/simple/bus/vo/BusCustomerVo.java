package com.jzk.simple.bus.vo;

import com.jzk.simple.bus.domain.BusCustomer;

/**
 * ClassName:BusCustomerVo
 * Package:com.jzk.simple.bus.vo
 * Description:
 *
 * @Date:2020/5/9 10:17
 * @Author:JiangZhikuan
 */
public class BusCustomerVo extends BusCustomer {

    /*
    * 分页参数
    * */
    private Integer page;
    private Integer limit;

    //接收多个ids
    private String[] identitys;

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

    public String[] getIdentitys() {
        return identitys;
    }

    public void setIdentitys(String[] identitys) {
        this.identitys = identitys;
    }
}
