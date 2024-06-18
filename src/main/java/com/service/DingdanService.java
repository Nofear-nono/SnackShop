package com.service;

import com.entity.Dingdan;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName DingdanService
 * @Description 订单模块业务层
 */
public interface DingdanService {

    //保存或更新订单表数据
    Integer saveOrUpdate(Dingdan instance);

    //查询所有订单表数据
    List<Dingdan> findAll();

    //根据条件(字符类型模糊)查询订单表数据
    List<Dingdan> find(Dingdan instance);

    //根据条件(字符类型完全匹配)查询订单表数据
    List<Dingdan> findByEqualTo(Dingdan instance);

    //根据条件(字符类型模糊)查询查询第一条订单表数据
    Dingdan findOne(Dingdan instance);

    //根据条件(字符类型完全匹配)查询查询第一条订单表数据
    Dingdan findOneByEqualTo(Dingdan instance);

    //根据id列查询订单表数据
    Dingdan findById(Integer id);

    //根据id列删除订单表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询订单表数据
    PageData<Dingdan> findPage(PageWrap<Dingdan> pageWrap);

    //根据条件(字符类型完全匹配)分页查询订单表数据
    PageData<Dingdan> findPageByEqualTo(PageWrap<Dingdan> pageWrap);
}
