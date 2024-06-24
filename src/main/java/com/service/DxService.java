package com.service;

import com.entity.Dx;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName DxService
 * @Description 信息介绍模块业务层
 */
public interface DxService {

    //保存或更新信息介绍表数据
    Integer saveOrUpdate(Dx instance);

    //查询所有信息介绍表数据
    List<Dx> findAll();

    //根据条件(字符类型模糊)查询信息介绍表数据
    List<Dx> find(Dx instance);

    //根据条件(字符类型完全匹配)查询信息介绍表数据
    List<Dx> findByEqualTo(Dx instance);

    //根据条件(字符类型模糊)查询查询第一条信息介绍表数据
    Dx findOne(Dx instance);

    //根据条件(字符类型完全匹配)查询查询第一条信息介绍表数据
    Dx findOneByEqualTo(Dx instance);

    //根据id列查询信息介绍表数据
    Dx findById(Integer id);

    //根据id列删除信息介绍表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询信息介绍表数据
    PageData<Dx> findPage(PageWrap<Dx> pageWrap);

    //根据条件(字符类型完全匹配)分页查询信息介绍表数据
    PageData<Dx> findPageByEqualTo(PageWrap<Dx> pageWrap);
}
