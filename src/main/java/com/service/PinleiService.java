package com.service;

import com.entity.Pinlei;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName PinleiService
 * @Description 分类模块业务层
 */

public interface PinleiService {
    //保存或更新分类表数据
    Integer saveOrUpdate(Pinlei instance);

    //查询所有分类表数据
    List<Pinlei> findAll();

    //根据条件(字符类型模糊)查询分类表数据
    List<Pinlei> find(Pinlei instance);

    //根据条件(字符类型完全匹配)查询分类表数据
    List<Pinlei> findByEqualTo(Pinlei instance);

    //根据条件(字符类型模糊)查询查询第一条分类表数据
    Pinlei findOne(Pinlei instance);

    //根据条件(字符类型完全匹配)查询查询第一条分类表数据
    Pinlei findOneByEqualTo(Pinlei instance);

    //根据id列查询分类表数据
    Pinlei findById(Integer id);

    //根据id列删除分类表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询分类表数据
    PageData<Pinlei> findPage(PageWrap<Pinlei> pageWrap);

    //根据条件(字符类型完全匹配)分页查询分类表数据
    PageData<Pinlei> findPageByEqualTo(PageWrap<Pinlei> pageWrap);
}