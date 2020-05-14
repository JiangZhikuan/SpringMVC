package com.jzk.simple.bus.vo;

import com.jzk.simple.bus.domain.BusRent;
import com.sun.xml.internal.ws.spi.db.DatabindingException;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName:BusRentVo
 * Package:com.jzk.simple.bus.vo
 * Description:
 *
 * @Date:2020/5/14 9:49
 * @Author:JiangZhikuan
 */
public class BusRentVo extends BusRent {

    /*
     * 分页参数
     * */
    private Integer page;
    private Integer limit;

    /*
    * 时间
    * */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
