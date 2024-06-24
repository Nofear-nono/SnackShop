package com.service.impl;

import com.dao.XinwenMapper;
import com.entity.Xinwen;
import com.entity.XinwenExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.XinwenService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName XinwenServiceImpl
 * @Description 新闻模块业务实现层
 */
@Service
public class XinwenServiceImpl implements XinwenService {

    @Autowired
    private XinwenMapper xinwenMapper;



    //保存或更新新闻表xinwen
    @Override
    public Integer saveOrUpdate(Xinwen instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            xinwenMapper.updateByPrimaryKeySelective(instance);
        }else {
            xinwenMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询新闻表xinwen
    @Override
    public List<Xinwen> findAll() {
        List<Xinwen> list = xinwenMapper.selectByExample(null);
        for (Xinwen info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询新闻表xinwen
    @Override
    public List<Xinwen> find(Xinwen instance) {
        XinwenExample xinwenExample = getXinwenExampleByLike(instance);
        xinwenExample.setOrderByClause(" id desc");
        List<Xinwen> list = xinwenMapper.selectByExample(xinwenExample);
        for (Xinwen info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询新闻表xinwen
    @Override
    public List<Xinwen> findByEqualTo(Xinwen instance) {
        XinwenExample xinwenExample = getXinwenExampleByEqualTo(instance);
        xinwenExample.setOrderByClause(" id desc");
        List<Xinwen> list = xinwenMapper.selectByExample(xinwenExample);
        for (Xinwen info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询新闻表xinwen最后一条数据
    @Override
    public Xinwen findOne(Xinwen instance) {
        List<Xinwen> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询新闻表xinwen最后一条数据
    @Override
    public Xinwen findOneByEqualTo(Xinwen instance) {
        List<Xinwen> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询新闻表xinwen数据
    @Override
    public Xinwen findById(Integer id) {
        Xinwen info = xinwenMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除新闻表xinwen数据
    @Override
    public int deleteById(Integer id) {
        return xinwenMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询新闻表xinwen数据
    @Override
    public PageData<Xinwen> findPage(PageWrap<Xinwen> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        XinwenExample xinwenExample = getXinwenExampleByLike(pageWrap.getModel());
        xinwenExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Xinwen> list = xinwenMapper.selectByExample(xinwenExample);
        for (Xinwen info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询新闻表xinwen数据
    @Override
    public PageData<Xinwen> findPageByEqualTo(PageWrap<Xinwen> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        XinwenExample xinwenExample = getXinwenExampleByEqualTo(pageWrap.getModel());
        xinwenExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Xinwen> list = xinwenMapper.selectByExample(xinwenExample);
        for (Xinwen info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Xinwen info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private XinwenExample getXinwenExampleByLike(Xinwen instance) {
        XinwenExample xinwenExample = new XinwenExample();
        XinwenExample.Criteria criteria = xinwenExample.createCriteria();
        //新闻id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //标题biaoti模糊匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiLike("%" + instance.getBiaoti() + "%");
        }
        //内容neirong模糊匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongLike("%" + instance.getNeirong() + "%");
        }
        //图片tupian模糊匹配
        if (null != instance.getTupian() && !instance.getTupian().equals("")) {
            criteria.andTupianLike("%" + instance.getTupian() + "%");
        }
        //时间shijian模糊匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianLike("%" + instance.getShijian() + "%");
        }

        return xinwenExample;
    }

    //字符类型完全相等查询条件构造器
    private XinwenExample getXinwenExampleByEqualTo(Xinwen instance) {
        XinwenExample xinwenExample = new XinwenExample();
        XinwenExample.Criteria criteria = xinwenExample.createCriteria();
        //新闻id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //标题biaoti完全匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiEqualTo(instance.getBiaoti());
        }
        //内容neirong完全匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongEqualTo(instance.getNeirong());
        }
        //图片tupian完全匹配
        if (null != instance.getTupian() && !instance.getTupian().equals("")) {
            criteria.andTupianEqualTo(instance.getTupian());
        }
        //时间shijian完全匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianEqualTo(instance.getShijian());
        }

        return xinwenExample;
    }
}
