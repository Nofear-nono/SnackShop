package com.service.impl;

import com.dao.GouwucheMapper;
import com.dao.ShangpinMapper;
import com.dao.UsersMapper;
import com.entity.Gouwuche;
import com.entity.GouwucheExample;
import com.entity.Shangpin;
import com.entity.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.GouwucheService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GouwucheServiceImpl
 * @Description 购物车模块业务实现层
 */
@Service
public class GouwucheServiceImpl implements GouwucheService {

    @Autowired
    private GouwucheMapper gouwucheMapper;

    @Autowired
    private ShangpinMapper shangpinMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新购物车表gouwuche
    @Override
    public Integer saveOrUpdate(Gouwuche instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            gouwucheMapper.updateByPrimaryKeySelective(instance);
        }else {
            gouwucheMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询购物车表gouwuche
    @Override
    public List<Gouwuche> findAll() {
        List<Gouwuche> list = gouwucheMapper.selectByExample(null);
        for (Gouwuche info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询购物车表gouwuche
    @Override
    public List<Gouwuche> find(Gouwuche instance) {
        GouwucheExample gouwucheExample = getGouwucheExampleByLike(instance);
        gouwucheExample.setOrderByClause(" id desc");
        List<Gouwuche> list = gouwucheMapper.selectByExample(gouwucheExample);
        for (Gouwuche info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询购物车表gouwuche
    @Override
    public List<Gouwuche> findByEqualTo(Gouwuche instance) {
        GouwucheExample gouwucheExample = getGouwucheExampleByEqualTo(instance);
        gouwucheExample.setOrderByClause(" id desc");
        List<Gouwuche> list = gouwucheMapper.selectByExample(gouwucheExample);
        for (Gouwuche info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询购物车表gouwuche最后一条数据
    @Override
    public Gouwuche findOne(Gouwuche instance) {
        List<Gouwuche> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询购物车表gouwuche最后一条数据
    @Override
    public Gouwuche findOneByEqualTo(Gouwuche instance) {
        List<Gouwuche> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询购物车表gouwuche数据
    @Override
    public Gouwuche findById(Integer id) {
        Gouwuche info = gouwucheMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除购物车表gouwuche数据
    @Override
    public int deleteById(Integer id) {
        return gouwucheMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询购物车表gouwuche数据
    @Override
    public PageData<Gouwuche> findPage(PageWrap<Gouwuche> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        GouwucheExample gouwucheExample = getGouwucheExampleByLike(pageWrap.getModel());
        gouwucheExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Gouwuche> list = gouwucheMapper.selectByExample(gouwucheExample);
        for (Gouwuche info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询购物车表gouwuche数据
    @Override
    public PageData<Gouwuche> findPageByEqualTo(PageWrap<Gouwuche> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        GouwucheExample gouwucheExample = getGouwucheExampleByEqualTo(pageWrap.getModel());
        gouwucheExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Gouwuche> list = gouwucheMapper.selectByExample(gouwucheExample);
        for (Gouwuche info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Gouwuche info){
        if (null != info){
            Shangpin shangpin= shangpinMapper.selectByPrimaryKey(info.getShangpinid());
            info.setShangpin(shangpin);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private GouwucheExample getGouwucheExampleByLike(Gouwuche instance) {
        GouwucheExample gouwucheExample = new GouwucheExample();
        GouwucheExample.Criteria criteria = gouwucheExample.createCriteria();
        //购物车id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //商品idshangpinid完全匹配
        if (null != instance.getShangpinid()) {
            criteria.andShangpinidEqualTo(instance.getShangpinid());
        }
        //商品数量goumaishuliang完全匹配
        if (null != instance.getGoumaishuliang()) {
            criteria.andGoumaishuliangEqualTo(instance.getGoumaishuliang());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return gouwucheExample;
    }

    //字符类型完全相等查询条件构造器
    private GouwucheExample getGouwucheExampleByEqualTo(Gouwuche instance) {
        GouwucheExample gouwucheExample = new GouwucheExample();
        GouwucheExample.Criteria criteria = gouwucheExample.createCriteria();
        //购物车id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //商品idshangpinid完全匹配
        if (null != instance.getShangpinid()) {
            criteria.andShangpinidEqualTo(instance.getShangpinid());
        }
        //商品数量goumaishuliang完全匹配
        if (null != instance.getGoumaishuliang()) {
            criteria.andGoumaishuliangEqualTo(instance.getGoumaishuliang());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return gouwucheExample;
    }
}
