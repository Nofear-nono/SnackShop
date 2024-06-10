package com.entity;

/**
 * @ClassName Payment
 * @Description 支付方式模块实体层
 */
public class Payment {
    private int id;
    private String mingcheng;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMingcheng() {
        return mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", mingcheng='" + mingcheng + '\'' +
                '}';
    }
}