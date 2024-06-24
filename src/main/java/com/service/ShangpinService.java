package com.service;

import com.entity.Shangpin;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName ShangpinService
 * @Description 零食模块业务层
 */

public interface ShangpinService {
    //保存或更新零食表数据
    Integer saveOrUpdate(Shangpin instance);

    //查询所有零食表数据
    List<Shangpin> findAll();

    //根据条件(字符类型模糊)查询零食表数据
    List<Shangpin> find(Shangpin instance);

    //根据条件(字符类型完全匹配)查询零食表数据
    List<Shangpin> findByEqualTo(Shangpin instance);

    //根据条件(字符类型模糊)查询查询第一条零食表数据
    Shangpin findOne(Shangpin instance);

    //根据条件(字符类型完全匹配)查询查询第一条零食表数据
    Shangpin findOneByEqualTo(Shangpin instance);

    //根据id列查询零食表数据
    Shangpin findById(Integer id);

    //根据id列删除零食表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询零食表数据
    PageData<Shangpin> findPage(PageWrap<Shangpin> pageWrap);

    //根据条件(字符类型完全匹配)分页查询零食表数据
    PageData<Shangpin> findPageByEqualTo(PageWrap<Shangpin> pageWrap);
}
