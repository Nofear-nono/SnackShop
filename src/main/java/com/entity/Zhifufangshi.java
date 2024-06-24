package com.entity;


/**
 * @ClassName Zhifufangshi
 * @Description 支付方式模块实体层
 */
public class Zhifufangshi {
    //id列
    private Integer id;


    //支付方式
    private String mingcheng;


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
    * 获取 支付方式
    *
    * @return mingcheng 支付方式
    */
    public String getMingcheng() {
        return this.mingcheng;
    }

    /**
    * 设置 支付方式
    *
    * @param mingcheng 支付方式
    */
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

}
