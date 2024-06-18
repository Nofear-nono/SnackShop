package com.service;

import com.entity.Dingdanxiang;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName DingdanxiangService
 * @Description 订单项模块业务层
 */
public interface DingdanxiangService {

    //保存或更新订单项表数据
    Integer saveOrUpdate(Dingdanxiang instance);

    //查询所有订单项表数据
    List<Dingdanxiang> findAll();

    //根据条件(字符类型模糊)查询订单项表数据
    List<Dingdanxiang> find(Dingdanxiang instance);

    //根据条件(字符类型完全匹配)查询订单项表数据
    List<Dingdanxiang> findByEqualTo(Dingdanxiang instance);

    //根据条件(字符类型模糊)查询查询第一条订单项表数据
    Dingdanxiang findOne(Dingdanxiang instance);

    //根据条件(字符类型完全匹配)查询查询第一条订单项表数据
    Dingdanxiang findOneByEqualTo(Dingdanxiang instance);

    //根据id列查询订单项表数据
    Dingdanxiang findById(Integer id);

    //根据id列删除订单项表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询订单项表数据
    PageData<Dingdanxiang> findPage(PageWrap<Dingdanxiang> pageWrap);

    //根据条件(字符类型完全匹配)分页查询订单项表数据
    PageData<Dingdanxiang> findPageByEqualTo(PageWrap<Dingdanxiang> pageWrap);
}
