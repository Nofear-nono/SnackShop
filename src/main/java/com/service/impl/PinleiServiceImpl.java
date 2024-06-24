package com.service.impl;

import com.dao.PinleiMapper;
import com.entity.Pinlei;
import com.entity.PinleiExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.PinleiService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PinleiServiceImpl
 * @Description 分类模块业务实现层
 */
@Service
public class PinleiServiceImpl implements PinleiService {

    @Autowired
    private PinleiMapper pinleiMapper;



    //保存或更新分类表pinlei
    @Override
    public Integer saveOrUpdate(Pinlei instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            pinleiMapper.updateByPrimaryKeySelective(instance);
        }else {
            pinleiMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询分类表pinlei
    @Override
    public List<Pinlei> findAll() {
        List<Pinlei> list = pinleiMapper.selectByExample(null);
        for (Pinlei info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询分类表pinlei
    @Override
    public List<Pinlei> find(Pinlei instance) {
        PinleiExample pinleiExample = getPinleiExampleByLike(instance);
        pinleiExample.setOrderByClause(" id desc");
        List<Pinlei> list = pinleiMapper.selectByExample(pinleiExample);
        for (Pinlei info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询分类表pinlei
    @Override
    public List<Pinlei> findByEqualTo(Pinlei instance) {
        PinleiExample pinleiExample = getPinleiExampleByEqualTo(instance);
        pinleiExample.setOrderByClause(" id desc");
        List<Pinlei> list = pinleiMapper.selectByExample(pinleiExample);
        for (Pinlei info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询分类表pinlei最后一条数据
    @Override
    public Pinlei findOne(Pinlei instance) {
        List<Pinlei> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询分类表pinlei最后一条数据
    @Override
    public Pinlei findOneByEqualTo(Pinlei instance) {
        List<Pinlei> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询分类表pinlei数据
    @Override
    public Pinlei findById(Integer id) {
        Pinlei info = pinleiMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除分类表pinlei数据
    @Override
    public int deleteById(Integer id) {
        return pinleiMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询分类表pinlei数据
    @Override
    public PageData<Pinlei> findPage(PageWrap<Pinlei> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        PinleiExample pinleiExample = getPinleiExampleByLike(pageWrap.getModel());
        pinleiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Pinlei> list = pinleiMapper.selectByExample(pinleiExample);
        for (Pinlei info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询分类表pinlei数据
    @Override
    public PageData<Pinlei> findPageByEqualTo(PageWrap<Pinlei> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        PinleiExample pinleiExample = getPinleiExampleByEqualTo(pageWrap.getModel());
        pinleiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Pinlei> list = pinleiMapper.selectByExample(pinleiExample);
        for (Pinlei info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Pinlei info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private PinleiExample getPinleiExampleByLike(Pinlei instance) {
        PinleiExample pinleiExample = new PinleiExample();
        PinleiExample.Criteria criteria = pinleiExample.createCriteria();
        //分类id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        return pinleiExample;
    }

    //字符类型完全相等查询条件构造器
    private PinleiExample getPinleiExampleByEqualTo(Pinlei instance) {
        PinleiExample pinleiExample = new PinleiExample();
        PinleiExample.Criteria criteria = pinleiExample.createCriteria();
        //分类id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        return pinleiExample;
    }
}
