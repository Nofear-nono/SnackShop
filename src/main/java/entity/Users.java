package com.entity;

public class Users {
    //id列
    private Integer id;
    //用户名称
    private String loginname;
    //密码
    private String loginpw;
    //类型
    private String type;
    //类型名称
    private String typename;
    //姓名
    private String xingming;
    //性别
    private String xingbie;
    //年龄
    private String nianling;
    //地址
    private String address;
    //电话
    private String dianhua;
    //审核
    private String shenhe;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return this.loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpw() {
        return this.loginpw;
    }

    public void setLoginpw(String loginpw) {
        this.loginpw = loginpw;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypename() {
        return this.typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getXingming() {
        return this.xingming;
    }

    void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getXingbie() {
        return this.xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public String getNianling() {
        return this.nianling;
    }

    public void setNianling(String nianling) {
        this.nianling = nianling;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDianhua() {
        return this.dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    public String getShenhe() {
        return this.shenhe;
    }

    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }

}
