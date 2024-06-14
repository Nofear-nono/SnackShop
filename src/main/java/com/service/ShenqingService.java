package com.service;

import com.entity.Shenqing;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName ShenqingService
 * @Description 售后申请模块业务层
 */
public interface ShenqingService {

    //保存或更新售后申请表数据
    Integer saveOrUpdate(Shenqing instance);

    //查询所有售后申请表数据
    List<Shenqing> findAll();

    //根据条件(字符类型模糊)查询售后申请表数据
    List<Shenqing> find(Shenqing instance);

    //根据条件(字符类型完全匹配)查询售后申请表数据
    List<Shenqing> findByEqualTo(Shenqing instance);

    //根据条件(字符类型模糊)查询查询第一条售后申请表数据
    Shenqing findOne(Shenqing instance);

    //根据条件(字符类型完全匹配)查询查询第一条售后申请表数据
    Shenqing findOneByEqualTo(Shenqing instance);

    //根据id列查询售后申请表数据
    Shenqing findById(Integer id);

    //根据id列删除售后申请表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询售后申请表数据
    PageData<Shenqing> findPage(PageWrap<Shenqing> pageWrap);

    //根据条件(字符类型完全匹配)分页查询售后申请表数据
    PageData<Shenqing> findPageByEqualTo(PageWrap<Shenqing> pageWrap);
}
