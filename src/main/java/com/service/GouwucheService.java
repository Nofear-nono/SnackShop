package com.service;

import com.entity.Gouwuche;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName GouwucheService
 * @Description 购物车模块业务层
 */
public interface GouwucheService {

    //保存或更新购物车表数据
    Integer saveOrUpdate(Gouwuche instance);

    //查询所有购物车表数据
    List<Gouwuche> findAll();

    //根据条件(字符类型模糊)查询购物车表数据
    List<Gouwuche> find(Gouwuche instance);

    //根据条件(字符类型完全匹配)查询购物车表数据
    List<Gouwuche> findByEqualTo(Gouwuche instance);

    //根据条件(字符类型模糊)查询查询第一条购物车表数据
    Gouwuche findOne(Gouwuche instance);

    //根据条件(字符类型完全匹配)查询查询第一条购物车表数据
    Gouwuche findOneByEqualTo(Gouwuche instance);

    //根据id列查询购物车表数据
    Gouwuche findById(Integer id);

    //根据id列删除购物车表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询购物车表数据
    PageData<Gouwuche> findPage(PageWrap<Gouwuche> pageWrap);

    //根据条件(字符类型完全匹配)分页查询购物车表数据
    PageData<Gouwuche> findPageByEqualTo(PageWrap<Gouwuche> pageWrap);
}
