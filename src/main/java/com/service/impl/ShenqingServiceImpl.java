package com.service.impl;

import com.dao.ShenqingMapper;
import com.dao.UsersMapper;
import com.entity.Shenqing;
import com.entity.ShenqingExample;
import com.entity.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ShenqingService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ShenqingServiceImpl
 * @Description 售后申请模块业务实现层
 */
@Service
public class ShenqingServiceImpl implements ShenqingService {

    @Autowired
    private ShenqingMapper shenqingMapper;

    @Autowired
    private UsersMapper usersMapper;


    //保存或更新售后申请表shenqing
    @Override
    public Integer saveOrUpdate(Shenqing instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            shenqingMapper.updateByPrimaryKeySelective(instance);
        }else {
            shenqingMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询售后申请表shenqing
    @Override
    public List<Shenqing> findAll() {
        List<Shenqing> list = shenqingMapper.selectByExample(null);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询售后申请表shenqing
    @Override
    public List<Shenqing> find(Shenqing instance) {
        ShenqingExample shenqingExample = getShenqingExampleByLike(instance);
        shenqingExample.setOrderByClause(" id desc");
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询售后申请表shenqing
    @Override
    public List<Shenqing> findByEqualTo(Shenqing instance) {
        ShenqingExample shenqingExample = getShenqingExampleByEqualTo(instance);
        shenqingExample.setOrderByClause(" id desc");
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询售后申请表shenqing最后一条数据
    @Override
    public Shenqing findOne(Shenqing instance) {
        List<Shenqing> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询售后申请表shenqing最后一条数据
    @Override
    public Shenqing findOneByEqualTo(Shenqing instance) {
        List<Shenqing> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询售后申请表shenqing数据
    @Override
    public Shenqing findById(Integer id) {
        Shenqing info = shenqingMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除售后申请表shenqing数据
    @Override
    public int deleteById(Integer id) {
        return shenqingMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询售后申请表shenqing数据
    @Override
    public PageData<Shenqing> findPage(PageWrap<Shenqing> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShenqingExample shenqingExample = getShenqingExampleByLike(pageWrap.getModel());
        shenqingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询售后申请表shenqing数据
    @Override
    public PageData<Shenqing> findPageByEqualTo(PageWrap<Shenqing> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShenqingExample shenqingExample = getShenqingExampleByEqualTo(pageWrap.getModel());
        shenqingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Shenqing info){
        if (null != info){
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private ShenqingExample getShenqingExampleByLike(Shenqing instance) {
        ShenqingExample shenqingExample = new ShenqingExample();
        ShenqingExample.Criteria criteria = shenqingExample.createCriteria();
        //售后申请id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //姓名xingming模糊匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingLike("%" + instance.getXingming() + "%");
        }
        //电话dianhua模糊匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaLike("%" + instance.getDianhua() + "%");
        }
        //说明neirong模糊匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongLike("%" + instance.getNeirong() + "%");
        }
        //时间shijian模糊匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianLike("%" + instance.getShijian() + "%");
        }
        //备注beizhu模糊匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuLike("%" + instance.getBeizhu() + "%");
        }
        //是否审核shenhe模糊匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheLike("%" + instance.getShenhe() + "%");
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return shenqingExample;
    }

    //字符类型完全相等查询条件构造器
    private ShenqingExample getShenqingExampleByEqualTo(Shenqing instance) {
        ShenqingExample shenqingExample = new ShenqingExample();
        ShenqingExample.Criteria criteria = shenqingExample.createCriteria();
        //售后申请id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //姓名xingming完全匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingEqualTo(instance.getXingming());
        }
        //电话dianhua完全匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaEqualTo(instance.getDianhua());
        }
        //说明neirong完全匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongEqualTo(instance.getNeirong());
        }
        //时间shijian完全匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianEqualTo(instance.getShijian());
        }
        //备注beizhu完全匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuEqualTo(instance.getBeizhu());
        }
        //是否审核shenhe完全匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheEqualTo(instance.getShenhe());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return shenqingExample;
    }
}
