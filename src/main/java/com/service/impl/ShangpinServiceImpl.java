package com.service.impl;

import com.dao.PinleiMapper;
import com.dao.ShangpinMapper;
import com.entity.Pinlei;
import com.entity.Shangpin;
import com.entity.ShangpinExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ShangpinService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ShangpinServiceImpl
 * @Description 零食模块业务实现层
 */

@Service
public class ShangpinServiceImpl implements ShangpinService {
    @Autowired
    private ShangpinMapper shangpinMapper;
    @Autowired
    private PinleiMapper pinleiMapper;

    //保存或更新零食表
    @Override
    public Integer saveOrUpdate(Shangpin instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            shangpinMapper.updateByPrimaryKeySelective(instance);
        }else {
            shangpinMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询零食表
    @Override
    public List<Shangpin> findAll() {
        List<Shangpin> list = shangpinMapper.selectByExample(null);
        for (Shangpin info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询零食表
    @Override
    public List<Shangpin> find(Shangpin instance) {
        ShangpinExample shangpinExample = getShangpinExampleByLike(instance);
        shangpinExample.setOrderByClause(" id desc");
        List<Shangpin> list = shangpinMapper.selectByExample(shangpinExample);
        for (Shangpin info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型完全匹配)查询零食表
    @Override
    public List<Shangpin> findByEqualTo(Shangpin instance) {
        ShangpinExample shangpinExample = getShangpinExampleByEqualTo(instance);
        shangpinExample.setOrderByClause(" id desc");
        List<Shangpin> list = shangpinMapper.selectByExample(shangpinExample);
        for (Shangpin info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询零食表最后一条数据
    @Override
    public Shangpin findOne(Shangpin instance) {
        List<Shangpin> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询零食表最后一条数据
    @Override
    public Shangpin findOneByEqualTo(Shangpin instance) {
        List<Shangpin> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询零食表数据
    @Override
    public Shangpin findById(Integer id) {
        Shangpin info = shangpinMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除零食表数据
    @Override
    public int deleteById(Integer id) {
        return shangpinMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询零食表数据
    @Override
    public PageData<Shangpin> findPage(PageWrap<Shangpin> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShangpinExample shangpinExample = getShangpinExampleByLike(pageWrap.getModel());
        shangpinExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shangpin> list = shangpinMapper.selectByExample(shangpinExample);
        for (Shangpin info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询零食表数据
    @Override
    public PageData<Shangpin> findPageByEqualTo(PageWrap<Shangpin> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShangpinExample shangpinExample = getShangpinExampleByEqualTo(pageWrap.getModel());
        shangpinExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shangpin> list = shangpinMapper.selectByExample(shangpinExample);
        for (Shangpin info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Shangpin info){
        if (null != info){
            Pinlei pinlei= pinleiMapper.selectByPrimaryKey(info.getPinleiid());
            info.setPinlei(pinlei);

        }
    }

    //字符类型模糊查询条件构造器
    private ShangpinExample getShangpinExampleByLike(Shangpin instance) {
        ShangpinExample shangpinExample = new ShangpinExample();
        ShangpinExample.Criteria criteria = shangpinExample.createCriteria();

        //零食id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }

        //名称模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        //编号模糊匹配
        if (null != instance.getBianhao() && !instance.getBianhao().equals("")) {
            criteria.andBianhaoLike("%" + instance.getBianhao() + "%");
        }

        //分类完全匹配
        if (null != instance.getPinleiid()) {
            criteria.andPinleiidEqualTo(instance.getPinleiid());
        }

        //内容介绍模糊匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongLike("%" + instance.getNeirong() + "%");
        }

        //图片模糊匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageLike("%" + instance.getImage() + "%");
        }

        //原价完全匹配
        if (null != instance.getYuanshijiage()) {
            criteria.andYuanshijiageEqualTo(instance.getYuanshijiage());
        }

        //现价完全匹配
        if (null != instance.getJiage()) {
            criteria.andJiageEqualTo(instance.getJiage());
        }

        //单位模糊匹配
        if (null != instance.getDanwei() && !instance.getDanwei().equals("")) {
            criteria.andDanweiLike("%" + instance.getDanwei() + "%");
        }

        //是否特价模糊匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheLike("%" + instance.getShenhe() + "%");
        }

        //库存数量完全匹配
        if (null != instance.getKucunshuliang()) {
            criteria.andKucunshuliangEqualTo(instance.getKucunshuliang());
        }

        //销售数量完全匹配
        if (null != instance.getXiaoshoushuliang()) {
            criteria.andXiaoshoushuliangEqualTo(instance.getXiaoshoushuliang());
        }
        return shangpinExample;
    }

    //字符类型完全相等查询条件构造器
    private ShangpinExample getShangpinExampleByEqualTo(Shangpin instance) {
        ShangpinExample shangpinExample = new ShangpinExample();
        ShangpinExample.Criteria criteria = shangpinExample.createCriteria();
        //零食完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }

        //名称完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        //编号完全匹配
        if (null != instance.getBianhao() && !instance.getBianhao().equals("")) {
            criteria.andBianhaoEqualTo(instance.getBianhao());
        }

        //分类完全匹配
        if (null != instance.getPinleiid()) {
            criteria.andPinleiidEqualTo(instance.getPinleiid());
        }

        //内容介绍完全匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongEqualTo(instance.getNeirong());
        }

        //图片完全匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageEqualTo(instance.getImage());
        }

        //原价完全匹配
        if (null != instance.getYuanshijiage()) {
            criteria.andYuanshijiageEqualTo(instance.getYuanshijiage());
        }

        //现价完全匹配
        if (null != instance.getJiage()) {
            criteria.andJiageEqualTo(instance.getJiage());
        }

        //单位完全匹配
        if (null != instance.getDanwei() && !instance.getDanwei().equals("")) {
            criteria.andDanweiEqualTo(instance.getDanwei());
        }

        //是否特价完全匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheEqualTo(instance.getShenhe());
        }

        //库存数量完全匹配
        if (null != instance.getKucunshuliang()) {
            criteria.andKucunshuliangEqualTo(instance.getKucunshuliang());
        }

        //销售数量完全匹配
        if (null != instance.getXiaoshoushuliang()) {
            criteria.andXiaoshoushuliangEqualTo(instance.getXiaoshoushuliang());
        }
        return shangpinExample;
    }
}
