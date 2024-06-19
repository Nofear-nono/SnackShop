package com.service.impl;

import com.dao.ZhifufangshiMapper;
import com.entity.Zhifufangshi;
import com.entity.ZhifufangshiExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ZhifufangshiService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ZhifufangshiServiceImpl
 * @Description 支付方式模块业务实现层
 */

@Service
public class ZhifufangshiServiceImpl implements ZhifufangshiService {
    @Autowired
    private ZhifufangshiMapper zhifufangshiMapper;

    //保存或更新支付方式表zhifufangshi
    @Override
    public Integer saveOrUpdate(Zhifufangshi instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            zhifufangshiMapper.updateByPrimaryKeySelective(instance);
        }else {
            zhifufangshiMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询支付方式表zhifufangshi
    @Override
    public List<Zhifufangshi> findAll() {
        List<Zhifufangshi> list = zhifufangshiMapper.selectByExample(null);
        for (Zhifufangshi info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询支付方式表zhifufangshi
    @Override
    public List<Zhifufangshi> find(Zhifufangshi instance) {
        ZhifufangshiExample zhifufangshiExample = getZhifufangshiExampleByLike(instance);
        zhifufangshiExample.setOrderByClause(" id desc");
        List<Zhifufangshi> list = zhifufangshiMapper.selectByExample(zhifufangshiExample);
        for (Zhifufangshi info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型完全匹配)查询支付方式表zhifufangshi
    @Override
    public List<Zhifufangshi> findByEqualTo(Zhifufangshi instance) {
        ZhifufangshiExample zhifufangshiExample = getZhifufangshiExampleByEqualTo(instance);
        zhifufangshiExample.setOrderByClause(" id desc");
        List<Zhifufangshi> list = zhifufangshiMapper.selectByExample(zhifufangshiExample);
        for (Zhifufangshi info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询支付方式表zhifufangshi最后一条数据
    @Override
    public Zhifufangshi findOne(Zhifufangshi instance) {
        List<Zhifufangshi> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询支付方式表zhifufangshi最后一条数据
    @Override
    public Zhifufangshi findOneByEqualTo(Zhifufangshi instance) {
        List<Zhifufangshi> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询支付方式表zhifufangshi数据
    @Override
    public Zhifufangshi findById(Integer id) {
        Zhifufangshi info = zhifufangshiMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除支付方式表zhifufangshi数据
    @Override
    public int deleteById(Integer id) {
        return zhifufangshiMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询支付方式表zhifufangshi数据
    @Override
    public PageData<Zhifufangshi> findPage(PageWrap<Zhifufangshi> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ZhifufangshiExample zhifufangshiExample = getZhifufangshiExampleByLike(pageWrap.getModel());
        zhifufangshiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Zhifufangshi> list = zhifufangshiMapper.selectByExample(zhifufangshiExample);
        for (Zhifufangshi info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询支付方式表zhifufangshi数据
    @Override
    public PageData<Zhifufangshi> findPageByEqualTo(PageWrap<Zhifufangshi> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ZhifufangshiExample zhifufangshiExample = getZhifufangshiExampleByEqualTo(pageWrap.getModel());
        zhifufangshiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Zhifufangshi> list = zhifufangshiMapper.selectByExample(zhifufangshiExample);
        for (Zhifufangshi info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Zhifufangshi info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private ZhifufangshiExample getZhifufangshiExampleByLike(Zhifufangshi instance) {
        ZhifufangshiExample zhifufangshiExample = new ZhifufangshiExample();
        ZhifufangshiExample.Criteria criteria = zhifufangshiExample.createCriteria();
        //支付方式id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //支付方式mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        return zhifufangshiExample;
    }

    //字符类型完全相等查询条件构造器
    private ZhifufangshiExample getZhifufangshiExampleByEqualTo(Zhifufangshi instance) {
        ZhifufangshiExample zhifufangshiExample = new ZhifufangshiExample();
        ZhifufangshiExample.Criteria criteria = zhifufangshiExample.createCriteria();
        //支付方式id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //支付方式mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        return zhifufangshiExample;
    }
}