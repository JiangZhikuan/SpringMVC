package com.jzk.simple.sys.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MenuVo {
    private Integer id;

    @JsonProperty("parentId")
    private Integer pid;

    private String title;

    private String icon;

    private String href;

    private String target;

    private Boolean status;

    private List<MenuVo> child;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<MenuVo> getChild() {
        return child;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setChild(List<MenuVo> child) {
        this.child = child;
    }
}
