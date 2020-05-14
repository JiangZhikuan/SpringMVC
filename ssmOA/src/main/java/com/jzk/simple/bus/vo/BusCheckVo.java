package com.jzk.simple.bus.vo;

import com.jzk.simple.bus.domain.BusCheck;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName:BusCheckVo
 * Package:com.jzk.simple.bus.vo
 * Description:
 *
 * @Date:2020/5/14 12:48
 * @Author:JiangZhikuan
 */
public class BusCheckVo extends BusCheck {

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
    /**
     * 时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
