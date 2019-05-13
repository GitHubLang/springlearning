package com.Lang.pojo;

public class ProductCategory {
    private Integer catid;

    private String name;

    private Integer sorderorder=999;

    private Integer status=0;

    private Integer parentId=0;

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSorderorder() {
        return sorderorder;
    }

    public void setSorderorder(Integer sorderorder) {
        this.sorderorder = sorderorder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}