package com.service;

import com.entity.Xinwen;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName XinwenService
 * @Description 新闻模块业务层
 */
public interface XinwenService {

    //保存或更新新闻表数据
    Integer saveOrUpdate(Xinwen instance);

    //查询所有新闻表数据
    List<Xinwen> findAll();

    //根据条件(字符类型模糊)查询新闻表数据
    List<Xinwen> find(Xinwen instance);

    //根据条件(字符类型完全匹配)查询新闻表数据
    List<Xinwen> findByEqualTo(Xinwen instance);

    //根据条件(字符类型模糊)查询查询第一条新闻表数据
    Xinwen findOne(Xinwen instance);

    //根据条件(字符类型完全匹配)查询查询第一条新闻表数据
    Xinwen findOneByEqualTo(Xinwen instance);

    //根据id列查询新闻表数据
    Xinwen findById(Integer id);

    //根据id列删除新闻表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询新闻表数据
    PageData<Xinwen> findPage(PageWrap<Xinwen> pageWrap);

    //根据条件(字符类型完全匹配)分页查询新闻表数据
    PageData<Xinwen> findPageByEqualTo(PageWrap<Xinwen> pageWrap);
}
