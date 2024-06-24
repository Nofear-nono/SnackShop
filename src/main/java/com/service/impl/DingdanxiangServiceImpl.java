package com.service.impl;

import com.dao.DingdanMapper;
import com.dao.DingdanxiangMapper;
import com.dao.ShangpinMapper;
import com.dao.UsersMapper;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.DingdanxiangService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DingdanxiangServiceImpl
 * @Description 订单项模块业务实现层
 */
@Service
public class DingdanxiangServiceImpl implements DingdanxiangService {

    @Autowired
    private DingdanxiangMapper dingdanxiangMapper;

    @Autowired
    private DingdanMapper dingdanMapper;
    @Autowired
    private ShangpinMapper shangpinMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新订单项表dingdanxiang
    @Override
    public Integer saveOrUpdate(Dingdanxiang instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            dingdanxiangMapper.updateByPrimaryKeySelective(instance);
        }else {
            dingdanxiangMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询订单项表dingdanxiang
    @Override
    public List<Dingdanxiang> findAll() {
        List<Dingdanxiang> list = dingdanxiangMapper.selectByExample(null);
        for (Dingdanxiang info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询订单项表dingdanxiang
    @Override
    public List<Dingdanxiang> find(Dingdanxiang instance) {
        DingdanxiangExample dingdanxiangExample = getDingdanxiangExampleByLike(instance);
        dingdanxiangExample.setOrderByClause(" id desc");
        List<Dingdanxiang> list = dingdanxiangMapper.selectByExample(dingdanxiangExample);
        for (Dingdanxiang info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询订单项表dingdanxiang
    @Override
    public List<Dingdanxiang> findByEqualTo(Dingdanxiang instance) {
        DingdanxiangExample dingdanxiangExample = getDingdanxiangExampleByEqualTo(instance);
        dingdanxiangExample.setOrderByClause(" id desc");
        List<Dingdanxiang> list = dingdanxiangMapper.selectByExample(dingdanxiangExample);
        for (Dingdanxiang info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询订单项表dingdanxiang最后一条数据
    @Override
    public Dingdanxiang findOne(Dingdanxiang instance) {
        List<Dingdanxiang> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询订单项表dingdanxiang最后一条数据
    @Override
    public Dingdanxiang findOneByEqualTo(Dingdanxiang instance) {
        List<Dingdanxiang> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询订单项表dingdanxiang数据
    @Override
    public Dingdanxiang findById(Integer id) {
        Dingdanxiang info = dingdanxiangMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除订单项表dingdanxiang数据
    @Override
    public int deleteById(Integer id) {
        return dingdanxiangMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询订单项表dingdanxiang数据
    @Override
    public PageData<Dingdanxiang> findPage(PageWrap<Dingdanxiang> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        DingdanxiangExample dingdanxiangExample = getDingdanxiangExampleByLike(pageWrap.getModel());
        dingdanxiangExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Dingdanxiang> list = dingdanxiangMapper.selectByExample(dingdanxiangExample);
        for (Dingdanxiang info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询订单项表dingdanxiang数据
    @Override
    public PageData<Dingdanxiang> findPageByEqualTo(PageWrap<Dingdanxiang> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        DingdanxiangExample dingdanxiangExample = getDingdanxiangExampleByEqualTo(pageWrap.getModel());
        dingdanxiangExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Dingdanxiang> list = dingdanxiangMapper.selectByExample(dingdanxiangExample);
        for (Dingdanxiang info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Dingdanxiang info){
        if (null != info){
            Dingdan dingdan= dingdanMapper.selectByPrimaryKey(info.getDingdanid());
            info.setDingdan(dingdan);
            Shangpin shangpin= shangpinMapper.selectByPrimaryKey(info.getShangpinid());
            info.setShangpin(shangpin);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private DingdanxiangExample getDingdanxiangExampleByLike(Dingdanxiang instance) {
        DingdanxiangExample dingdanxiangExample = new DingdanxiangExample();
        DingdanxiangExample.Criteria criteria = dingdanxiangExample.createCriteria();
        //订单项id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //订单iddingdanid完全匹配
        if (null != instance.getDingdanid()) {
            criteria.andDingdanidEqualTo(instance.getDingdanid());
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

        return dingdanxiangExample;
    }

    //字符类型完全相等查询条件构造器
    private DingdanxiangExample getDingdanxiangExampleByEqualTo(Dingdanxiang instance) {
        DingdanxiangExample dingdanxiangExample = new DingdanxiangExample();
        DingdanxiangExample.Criteria criteria = dingdanxiangExample.createCriteria();
        //订单项id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //订单iddingdanid完全匹配
        if (null != instance.getDingdanid()) {
            criteria.andDingdanidEqualTo(instance.getDingdanid());
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

        return dingdanxiangExample;
    }
}
