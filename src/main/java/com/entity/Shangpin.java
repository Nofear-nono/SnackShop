package com.entity;


/**
 * @ClassName Shangpin
 * @Description 零食模块实体层
 */
public class Shangpin {
    //id列
    private Integer id;


    //名称
    private String mingcheng;
    //编号
    private String bianhao;
    //分类id
    private Integer pinleiid;
    //内容介绍
    private String neirong;
    //图片
    private String image;
    //原价
    private Integer yuanshijiage;
    //现价
    private Integer jiage;
    //单位
    private String danwei;
    //是否特价
    private String shenhe;
    //库存数量
    private Integer kucunshuliang;
    //销售数量
    private Integer xiaoshoushuliang;
    //父表：分类表pinlei
    private Pinlei pinlei;


    /**
    * 获取 id列
    *
    * @return id id列
    */
    public Integer getId() {
        return this.id;
    }

    /**
    * 设置 id列
    *
    * @param id id列
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * 获取 名称
    *
    * @return mingcheng 名称
    */
    public String getMingcheng() {
        return this.mingcheng;
    }

    /**
    * 设置 名称
    *
    * @param mingcheng 名称
    */
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }
    /**
    * 获取 编号
    *
    * @return bianhao 编号
    */
    public String getBianhao() {
        return this.bianhao;
    }

    /**
    * 设置 编号
    *
    * @param bianhao 编号
    */
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }
    /**
    * 获取 分类id
    *
    * @return pinleiid 分类id
    */
    public Integer getPinleiid() {
        return this.pinleiid;
    }

    /**
    * 设置 分类id
    *
    * @param pinleiid 分类id
    */
    public void setPinleiid(Integer pinleiid) {
        this.pinleiid = pinleiid;
    }
    /**
    * 获取 内容介绍
    *
    * @return neirong 内容介绍
    */
    public String getNeirong() {
        return this.neirong;
    }

    /**
    * 设置 内容介绍
    *
    * @param neirong 内容介绍
    */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    /**
    * 获取 图片
    *
    * @return image 图片
    */
    public String getImage() {
        return this.image;
    }

    /**
    * 设置 图片
    *
    * @param image 图片
    */
    public void setImage(String image) {
        this.image = image;
    }
    /**
    * 获取 原价
    *
    * @return yuanshijiage 原价
    */
    public Integer getYuanshijiage() {
        return this.yuanshijiage;
    }

    /**
    * 设置 原价
    *
    * @param yuanshijiage 原价
    */
    public void setYuanshijiage(Integer yuanshijiage) {
        this.yuanshijiage = yuanshijiage;
    }
    /**
    * 获取 现价
    *
    * @return jiage 现价
    */
    public Integer getJiage() {
        return this.jiage;
    }

    /**
    * 设置 现价
    *
    * @param jiage 现价
    */
    public void setJiage(Integer jiage) {
        this.jiage = jiage;
    }
    /**
    * 获取 单位
    *
    * @return danwei 单位
    */
    public String getDanwei() {
        return this.danwei;
    }

    /**
    * 设置 单位
    *
    * @param danwei 单位
    */
    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }
    /**
    * 获取 是否特价
    *
    * @return shenhe 是否特价
    */
    public String getShenhe() {
        return this.shenhe;
    }

    /**
    * 设置 是否特价
    *
    * @param shenhe 是否特价
    */
    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }
    /**
    * 获取 库存数量
    *
    * @return kucunshuliang 库存数量
    */
    public Integer getKucunshuliang() {
        return this.kucunshuliang;
    }

    /**
    * 设置 库存数量
    *
    * @param kucunshuliang 库存数量
    */
    public void setKucunshuliang(Integer kucunshuliang) {
        this.kucunshuliang = kucunshuliang;
    }
    /**
    * 获取 销售数量
    *
    * @return xiaoshoushuliang 销售数量
    */
    public Integer getXiaoshoushuliang() {
        return this.xiaoshoushuliang;
    }

    /**
    * 设置 销售数量
    *
    * @param xiaoshoushuliang 销售数量
    */
    public void setXiaoshoushuliang(Integer xiaoshoushuliang) {
        this.xiaoshoushuliang = xiaoshoushuliang;
    }
    /**
    * 获取 父表：分类表pinlei
    *
    * @return pinlei 父表：分类表pinlei
    */
    public Pinlei getPinlei() {
        return this.pinlei;
    }

    /**
    * 设置 父表：分类表pinlei
    *
    * @param pinlei 父表：分类表pinlei
    */
    public void setPinlei(Pinlei pinlei) {
        this.pinlei = pinlei;
    }

}
