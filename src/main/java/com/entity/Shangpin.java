package com.entity;

/**
 * @ClassName Shangpin
 * @Description 零食模块实体层
 */

public class Shangpin {
    private Integer id;
    private String mingcheng;
    private String bianhao;
    private Integer pinleiid;
    private String neirong;
    private String image;
    private Integer yuanshijiage;
    private Integer jiage;
    private String danwei;
    private String shenhe;
    private Integer kucunshuliang;
    private Integer xiaoshoushuliang;
    private Pinlei pinlei;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMingcheng() {
        return this.mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

    public String getBianhao() {
        return this.bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public Integer getPinleiid() {
        return this.pinleiid;
    }

    public void setPinleiid(Integer pinleiid) {
        this.pinleiid = pinleiid;
    }

    public String getNeirong() {
        return this.neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getYuanshijiage() {
        return this.yuanshijiage;
    }

    public void setYuanshijiage(Integer yuanshijiage) {
        this.yuanshijiage = yuanshijiage;
    }

    public Integer getJiage() {
        return this.jiage;
    }

    public void setJiage(Integer jiage) {
        this.jiage = jiage;
    }

    public String getDanwei() {
        return this.danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getShenhe() {
        return this.shenhe;
    }

    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }

    public Integer getKucunshuliang() {
        return this.kucunshuliang;
    }

    public void setKucunshuliang(Integer kucunshuliang) {
        this.kucunshuliang = kucunshuliang;
    }

    public Integer getXiaoshoushuliang() {
        return this.xiaoshoushuliang;
    }

    public void setXiaoshoushuliang(Integer xiaoshoushuliang) {
        this.xiaoshoushuliang = xiaoshoushuliang;
    }

    public Pinlei getPinlei() {
        return this.pinlei;
    }

    public void setPinlei(Pinlei pinlei) {
        this.pinlei = pinlei;
    }
}
