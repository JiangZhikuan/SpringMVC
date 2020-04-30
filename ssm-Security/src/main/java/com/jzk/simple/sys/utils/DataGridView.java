package com.jzk.simple.sys.utils;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName:DataGridView
 * Package:com.jzk.simple.sys.utils
 * Description:
 *
 * @Date:2020/4/24 15:23
 * @Author:JiangZhikuan
 */
public class DataGridView {

    private Integer code=0;
    private String msg="";
    private long count;
    private Object data;

    public DataGridView(){

    }

    public DataGridView(Object data){
        super();
        this.data=data;
    }
    public DataGridView(long count,Object data){
        super();
        this.count= count;
        this.data=data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
