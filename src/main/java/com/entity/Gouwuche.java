package com.entity;


/**
 * @ClassName Gouwuche
 * @Description 购物车模块实体层
 */
public class Gouwuche {
    //id列
    private Integer id;


    //商品id
    private Integer shangpinid;
    //商品数量
    private Integer goumaishuliang;
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
    * 获取 商品id
    *
    * @return shangpinid 商品id
    */
    public Integer getShangpinid() {
        return this.shangpinid;
    }

    /**
    * 设置 商品id
    *
    * @param shangpinid 商品id
    */
    public void setShangpinid(Integer shangpinid) {
        this.shangpinid = shangpinid;
    }
    /**
    * 获取 商品数量
    *
    * @return goumaishuliang 商品数量
    */
    public Integer getGoumaishuliang() {
        return this.goumaishuliang;
    }

    /**
    * 设置 商品数量
    *
    * @param goumaishuliang 商品数量
    */
    public void setGoumaishuliang(Integer goumaishuliang) {
        this.goumaishuliang = goumaishuliang;
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
