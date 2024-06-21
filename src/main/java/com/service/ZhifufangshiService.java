package com.service;

import com.entity.Zhifufangshi;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName ZhifufangshiService
 * @Description 支付方式模块业务层
 */

public interface ZhifufangshiService {
    //保存或更新支付方式表数据
    Integer saveOrUpdate(Zhifufangshi instance);

    //查询所有支付方式表数据
    List<Zhifufangshi> findAll();

    //根据条件(字符类型模糊)查询支付方式表数据
    List<Zhifufangshi> find(Zhifufangshi instance);

    //根据条件(字符类型完全匹配)查询支付方式表数据
    List<Zhifufangshi> findByEqualTo(Zhifufangshi instance);

    //根据条件(字符类型模糊)查询查询第一条支付方式表数据
    Zhifufangshi findOne(Zhifufangshi instance);

    //根据条件(字符类型完全匹配)查询查询第一条支付方式表数据
    Zhifufangshi findOneByEqualTo(Zhifufangshi instance);

    //根据id列查询支付方式表数据
    Zhifufangshi findById(Integer id);

    //根据id列删除支付方式表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询支付方式表数据
    PageData<Zhifufangshi> findPage(PageWrap<Zhifufangshi> pageWrap);

    //根据条件(字符类型完全匹配)分页查询支付方式表数据
    PageData<Zhifufangshi> findPageByEqualTo(PageWrap<Zhifufangshi> pageWrap);
}