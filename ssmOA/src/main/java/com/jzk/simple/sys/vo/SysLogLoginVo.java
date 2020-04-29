package com.jzk.simple.sys.vo;

import com.jzk.simple.sys.domain.SysLogLogin;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName:SysLogLoginVo
 * Package:com.jzk.simple.sys.vo
 * Description:
 *
 * @Date:2020/4/29 9:33
 * @Author:JiangZhikuan
 */
public class SysLogLoginVo extends SysLogLogin {

    private Integer page;
    private Integer limit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

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

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
