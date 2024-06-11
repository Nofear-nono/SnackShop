package com.entity;


/**
 * @ClassName Pingjia
 * @Description 评论模块实体层
 */
public class Pingjia {
    //id列
    private Integer id;


    //评语
    private String biaoti;
    //分数（范围1-5）
    private String fenshu;
    //时间
    private String shijian;
    //零食id
    private Integer shangpinid;
    //用户id
    private Integer usersid;
    //父表：零食表shangpin
    private Shangpin shangpin;
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
     * 获取 评语
     *
     * @return biaoti 评语
     */
    public String getBiaoti() {
        return this.biaoti;
    }

    /**
     * 设置 评语
     *
     * @param biaoti 评语
     */
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }
    /**
     * 获取 分数（范围1-5）
     *
     * @return fenshu 分数（范围1-5）
     */
    public String getFenshu() {
        return this.fenshu;
    }

    /**
     * 设置 分数（范围1-5）
     *
     * @param fenshu 分数（范围1-5）
     */
    public void setFenshu(String fenshu) {
        this.fenshu = fenshu;
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
     * 获取 零食id
     *
     * @return shangpinid 零食id
     */
    public Integer getShangpinid() {
        return this.shangpinid;
    }

    /**
     * 设置 零食id
     *
     * @param shangpinid 零食id
     */
    public void setShangpinid(Integer shangpinid) {
        this.shangpinid = shangpinid;
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
     * 获取 父表：零食表shangpin
     *
     * @return shangpin 父表：零食表shangpin
     */
    public Shangpin getShangpin() {
        return this.shangpin;
    }

    /**
     * 设置 父表：零食表shangpin
     *
     * @param shangpin 父表：零食表shangpin
     */
    public void setShangpin(Shangpin shangpin) {
        this.shangpin = shangpin;
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