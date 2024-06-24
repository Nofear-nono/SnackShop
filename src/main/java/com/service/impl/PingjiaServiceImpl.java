package com.service.impl;

import com.dao.PingjiaMapper;
import com.dao.ShangpinMapper;
import com.dao.UsersMapper;
import com.entity.Pingjia;
import com.entity.PingjiaExample;
import com.entity.Shangpin;
import com.entity.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.PingjiaService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PingjiaServiceImpl
 * @Description 评论模块业务实现层
 */
@Service
public class PingjiaServiceImpl implements PingjiaService {

    @Autowired
    private PingjiaMapper pingjiaMapper;

    @Autowired
    private ShangpinMapper shangpinMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新评论表pingjia
    @Override
    public Integer saveOrUpdate(Pingjia instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            pingjiaMapper.updateByPrimaryKeySelective(instance);
        }else {
            pingjiaMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询评论表pingjia
    @Override
    public List<Pingjia> findAll() {
        List<Pingjia> list = pingjiaMapper.selectByExample(null);
        for (Pingjia info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询评论表pingjia
    @Override
    public List<Pingjia> find(Pingjia instance) {
        PingjiaExample pingjiaExample = getPingjiaExampleByLike(instance);
        pingjiaExample.setOrderByClause(" id desc");
        List<Pingjia> list = pingjiaMapper.selectByExample(pingjiaExample);
        for (Pingjia info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询评论表pingjia
    @Override
    public List<Pingjia> findByEqualTo(Pingjia instance) {
        PingjiaExample pingjiaExample = getPingjiaExampleByEqualTo(instance);
        pingjiaExample.setOrderByClause(" id desc");
        List<Pingjia> list = pingjiaMapper.selectByExample(pingjiaExample);
        for (Pingjia info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询评论表pingjia最后一条数据
    @Override
    public Pingjia findOne(Pingjia instance) {
        List<Pingjia> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询评论表pingjia最后一条数据
    @Override
    public Pingjia findOneByEqualTo(Pingjia instance) {
        List<Pingjia> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询评论表pingjia数据
    @Override
    public Pingjia findById(Integer id) {
        Pingjia info = pingjiaMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除评论表pingjia数据
    @Override
    public int deleteById(Integer id) {
        return pingjiaMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询评论表pingjia数据
    @Override
    public PageData<Pingjia> findPage(PageWrap<Pingjia> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        PingjiaExample pingjiaExample = getPingjiaExampleByLike(pageWrap.getModel());
        pingjiaExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Pingjia> list = pingjiaMapper.selectByExample(pingjiaExample);
        for (Pingjia info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询评论表pingjia数据
    @Override
    public PageData<Pingjia> findPageByEqualTo(PageWrap<Pingjia> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        PingjiaExample pingjiaExample = getPingjiaExampleByEqualTo(pageWrap.getModel());
        pingjiaExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Pingjia> list = pingjiaMapper.selectByExample(pingjiaExample);
        for (Pingjia info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Pingjia info){
        if (null != info){
            Shangpin shangpin= shangpinMapper.selectByPrimaryKey(info.getShangpinid());
            info.setShangpin(shangpin);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private PingjiaExample getPingjiaExampleByLike(Pingjia instance) {
        PingjiaExample pingjiaExample = new PingjiaExample();
        PingjiaExample.Criteria criteria = pingjiaExample.createCriteria();
        //评论id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //评语biaoti模糊匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiLike("%" + instance.getBiaoti() + "%");
        }
        //分数（范围1-5）fenshu模糊匹配
        if (null != instance.getFenshu() && !instance.getFenshu().equals("")) {
            criteria.andFenshuLike("%" + instance.getFenshu() + "%");
        }
        //时间shijian模糊匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianLike("%" + instance.getShijian() + "%");
        }
        //零食idshangpinid完全匹配
        if (null != instance.getShangpinid()) {
            criteria.andShangpinidEqualTo(instance.getShangpinid());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return pingjiaExample;
    }

    //字符类型完全相等查询条件构造器
    private PingjiaExample getPingjiaExampleByEqualTo(Pingjia instance) {
        PingjiaExample pingjiaExample = new PingjiaExample();
        PingjiaExample.Criteria criteria = pingjiaExample.createCriteria();
        //评论id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //评语biaoti完全匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiEqualTo(instance.getBiaoti());
        }
        //分数（范围1-5）fenshu完全匹配
        if (null != instance.getFenshu() && !instance.getFenshu().equals("")) {
            criteria.andFenshuEqualTo(instance.getFenshu());
        }
        //时间shijian完全匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianEqualTo(instance.getShijian());
        }
        //零食idshangpinid完全匹配
        if (null != instance.getShangpinid()) {
            criteria.andShangpinidEqualTo(instance.getShangpinid());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return pingjiaExample;
    }
}
