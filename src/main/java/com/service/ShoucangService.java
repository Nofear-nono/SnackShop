package com.service;

import com.entity.Shoucang;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName ShoucangService
 * @Description 收藏模块业务层
 */
public interface ShoucangService {

    //保存或更新收藏表数据
    Integer saveOrUpdate(Shoucang instance);

    //查询所有收藏表数据
    List<Shoucang> findAll();

    //根据条件(字符类型模糊)查询收藏表数据
    List<Shoucang> find(Shoucang instance);

    //根据条件(字符类型完全匹配)查询收藏表数据
    List<Shoucang> findByEqualTo(Shoucang instance);

    //根据条件(字符类型模糊)查询查询第一条收藏表数据
    Shoucang findOne(Shoucang instance);

    //根据条件(字符类型完全匹配)查询查询第一条收藏表数据
    Shoucang findOneByEqualTo(Shoucang instance);

    //根据id列查询收藏表数据
    Shoucang findById(Integer id);

    //根据id列删除收藏表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询收藏表数据
    PageData<Shoucang> findPage(PageWrap<Shoucang> pageWrap);

    //根据条件(字符类型完全匹配)分页查询收藏表数据
    PageData<Shoucang> findPageByEqualTo(PageWrap<Shoucang> pageWrap);
}
