package com.entity;


/**
 * @ClassName Dingdan
 * @Description 订单模块实体层
 */
public class Dingdan {
    //id列
    private Integer id;


    //编号
    private String bianhao;
    //订单金额
    private Integer jine;
    //是否支付
    private String zhifushenhe;
    //是否发货
    private String fahuoshenhe;
    //是否收货
    private String shouhuoshenhe;
    //支付方式
    private Integer zhifufangshiid;
    //姓名
    private String xingming;
    //电话
    private String dianhua;
    //送货地址
    private String dizhi;
    //时间
    private String shijian;
    //物流信息
    private String wuliu;
    //备注
    private String beizhu;
    //用户id
    private Integer usersid;
    //父表：支付方式表zhifufangshi
    private Zhifufangshi zhifufangshi;
    //父表：用户表users
    private Users users;


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
    * 获取 订单金额
    *
    * @return jine 订单金额
    */
    public Integer getJine() {
        return this.jine;
    }

    /**
    * 设置 订单金额
    *
    * @param jine 订单金额
    */
    public void setJine(Integer jine) {
        this.jine = jine;
    }
    /**
    * 获取 是否支付
    *
    * @return zhifushenhe 是否支付
    */
    public String getZhifushenhe() {
        return this.zhifushenhe;
    }

    /**
    * 设置 是否支付
    *
    * @param zhifushenhe 是否支付
    */
    public void setZhifushenhe(String zhifushenhe) {
        this.zhifushenhe = zhifushenhe;
    }
    /**
    * 获取 是否发货
    *
    * @return fahuoshenhe 是否发货
    */
    public String getFahuoshenhe() {
        return this.fahuoshenhe;
    }

    /**
    * 设置 是否发货
    *
    * @param fahuoshenhe 是否发货
    */
    public void setFahuoshenhe(String fahuoshenhe) {
        this.fahuoshenhe = fahuoshenhe;
    }
    /**
    * 获取 是否收货
    *
    * @return shouhuoshenhe 是否收货
    */
    public String getShouhuoshenhe() {
        return this.shouhuoshenhe;
    }

    /**
    * 设置 是否收货
    *
    * @param shouhuoshenhe 是否收货
    */
    public void setShouhuoshenhe(String shouhuoshenhe) {
        this.shouhuoshenhe = shouhuoshenhe;
    }
    /**
    * 获取 支付方式
    *
    * @return zhifufangshiid 支付方式
    */
    public Integer getZhifufangshiid() {
        return this.zhifufangshiid;
    }

    /**
    * 设置 支付方式
    *
    * @param zhifufangshiid 支付方式
    */
    public void setZhifufangshiid(Integer zhifufangshiid) {
        this.zhifufangshiid = zhifufangshiid;
    }
    /**
    * 获取 姓名
    *
    * @return xingming 姓名
    */
    public String getXingming() {
        return this.xingming;
    }

    /**
    * 设置 姓名
    *
    * @param xingming 姓名
    */
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }
    /**
    * 获取 电话
    *
    * @return dianhua 电话
    */
    public String getDianhua() {
        return this.dianhua;
    }

    /**
    * 设置 电话
    *
    * @param dianhua 电话
    */
    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }
    /**
    * 获取 送货地址
    *
    * @return dizhi 送货地址
    */
    public String getDizhi() {
        return this.dizhi;
    }

    /**
    * 设置 送货地址
    *
    * @param dizhi 送货地址
    */
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
    /**
    * 获取 时间
    *
    * @return shijian 时间
    */
    public String getShijian() {
        return this.shijian;
    }

    /**
    * 设置 时间
    *
    * @param shijian 时间
    */
    public void setShijian(String shijian) {
        this.shijian = shijian;
    }
    /**
    * 获取 物流信息
    *
    * @return wuliu 物流信息
    */
    public String getWuliu() {
        return this.wuliu;
    }

    /**
    * 设置 物流信息
    *
    * @param wuliu 物流信息
    */
    public void setWuliu(String wuliu) {
        this.wuliu = wuliu;
    }
    /**
    * 获取 备注
    *
    * @return beizhu 备注
    */
    public String getBeizhu() {
        return this.beizhu;
    }

    /**
    * 设置 备注
    *
    * @param beizhu 备注
    */
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
    /**
    * 获取 用户id
    *
    * @return usersid 用户id
    */
    public Integer getUsersid() {
        return this.usersid;
    }

    /**
    * 设置 用户id
    *
    * @param usersid 用户id
    */
    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }
    /**
    * 获取 父表：支付方式表zhifufangshi
    *
    * @return zhifufangshi 父表：支付方式表zhifufangshi
    */
    public Zhifufangshi getZhifufangshi() {
        return this.zhifufangshi;
    }

    /**
    * 设置 父表：支付方式表zhifufangshi
    *
    * @param zhifufangshi 父表：支付方式表zhifufangshi
    */
    public void setZhifufangshi(Zhifufangshi zhifufangshi) {
        this.zhifufangshi = zhifufangshi;
    }
    /**
    * 获取 父表：用户表users
    *
    * @return users 父表：用户表users
    */
    public Users getUsers() {
        return this.users;
    }

    /**
    * 设置 父表：用户表users
    *
    * @param users 父表：用户表users
    */
    public void setUsers(Users users) {
        this.users = users;
    }

}
