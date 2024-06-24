package com.service.impl;

import com.dao.ShangpinMapper;
import com.dao.ShoucangMapper;
import com.dao.UsersMapper;
import com.entity.Shangpin;
import com.entity.Shoucang;
import com.entity.ShoucangExample;
import com.entity.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ShoucangService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ShoucangServiceImpl
 * @Description 收藏模块业务实现层
 */
@Service
public class ShoucangServiceImpl implements ShoucangService {

    @Autowired
    private ShoucangMapper shoucangMapper;

    @Autowired
    private ShangpinMapper shangpinMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新收藏表shoucang
    @Override
    public Integer saveOrUpdate(Shoucang instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            shoucangMapper.updateByPrimaryKeySelective(instance);
        }else {
            shoucangMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询收藏表shoucang
    @Override
    public List<Shoucang> findAll() {
        List<Shoucang> list = shoucangMapper.selectByExample(null);
        for (Shoucang info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询收藏表shoucang
    @Override
    public List<Shoucang> find(Shoucang instance) {
        ShoucangExample shoucangExample = getShoucangExampleByLike(instance);
        shoucangExample.setOrderByClause(" id desc");
        List<Shoucang> list = shoucangMapper.selectByExample(shoucangExample);
        for (Shoucang info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询收藏表shoucang
    @Override
    public List<Shoucang> findByEqualTo(Shoucang instance) {
        ShoucangExample shoucangExample = getShoucangExampleByEqualTo(instance);
        shoucangExample.setOrderByClause(" id desc");
        List<Shoucang> list = shoucangMapper.selectByExample(shoucangExample);
        for (Shoucang info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询收藏表shoucang最后一条数据
    @Override
    public Shoucang findOne(Shoucang instance) {
        List<Shoucang> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询收藏表shoucang最后一条数据
    @Override
    public Shoucang findOneByEqualTo(Shoucang instance) {
        List<Shoucang> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询收藏表shoucang数据
    @Override
    public Shoucang findById(Integer id) {
        Shoucang info = shoucangMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除收藏表shoucang数据
    @Override
    public int deleteById(Integer id) {
        return shoucangMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询收藏表shoucang数据
    @Override
    public PageData<Shoucang> findPage(PageWrap<Shoucang> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShoucangExample shoucangExample = getShoucangExampleByLike(pageWrap.getModel());
        shoucangExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shoucang> list = shoucangMapper.selectByExample(shoucangExample);
        for (Shoucang info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询收藏表shoucang数据
    @Override
    public PageData<Shoucang> findPageByEqualTo(PageWrap<Shoucang> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShoucangExample shoucangExample = getShoucangExampleByEqualTo(pageWrap.getModel());
        shoucangExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shoucang> list = shoucangMapper.selectByExample(shoucangExample);
        for (Shoucang info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Shoucang info){
        if (null != info){
            Shangpin shangpin= shangpinMapper.selectByPrimaryKey(info.getShangpinid());
            info.setShangpin(shangpin);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private ShoucangExample getShoucangExampleByLike(Shoucang instance) {
        ShoucangExample shoucangExample = new ShoucangExample();
        ShoucangExample.Criteria criteria = shoucangExample.createCriteria();
        //收藏id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
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

        return shoucangExample;
    }

    //字符类型完全相等查询条件构造器
    private ShoucangExample getShoucangExampleByEqualTo(Shoucang instance) {
        ShoucangExample shoucangExample = new ShoucangExample();
        ShoucangExample.Criteria criteria = shoucangExample.createCriteria();
        //收藏id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
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

        return shoucangExample;
    }
}
