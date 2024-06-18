package com.service.impl;

import com.dao.DingdanMapper;
import com.dao.UsersMapper;
import com.dao.ZhifufangshiMapper;
import com.entity.Dingdan;
import com.entity.DingdanExample;
import com.entity.Users;
import com.entity.Zhifufangshi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.DingdanService;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DingdanServiceImpl
 * @Description 订单模块业务实现层
 */
@Service
public class DingdanServiceImpl implements DingdanService {

    @Autowired
    private DingdanMapper dingdanMapper;

    @Autowired
    private ZhifufangshiMapper zhifufangshiMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新订单表dingdan
    @Override
    public Integer saveOrUpdate(Dingdan instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            dingdanMapper.updateByPrimaryKeySelective(instance);
        }else {
            dingdanMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询订单表dingdan
    @Override
    public List<Dingdan> findAll() {
        List<Dingdan> list = dingdanMapper.selectByExample(null);
        for (Dingdan info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询订单表dingdan
    @Override
    public List<Dingdan> find(Dingdan instance) {
        DingdanExample dingdanExample = getDingdanExampleByLike(instance);
        dingdanExample.setOrderByClause(" id desc");
        List<Dingdan> list = dingdanMapper.selectByExample(dingdanExample);
        for (Dingdan info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询订单表dingdan
    @Override
    public List<Dingdan> findByEqualTo(Dingdan instance) {
        DingdanExample dingdanExample = getDingdanExampleByEqualTo(instance);
        dingdanExample.setOrderByClause(" id desc");
        List<Dingdan> list = dingdanMapper.selectByExample(dingdanExample);
        for (Dingdan info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询订单表dingdan最后一条数据
    @Override
    public Dingdan findOne(Dingdan instance) {
        List<Dingdan> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询订单表dingdan最后一条数据
    @Override
    public Dingdan findOneByEqualTo(Dingdan instance) {
        List<Dingdan> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询订单表dingdan数据
    @Override
    public Dingdan findById(Integer id) {
        Dingdan info = dingdanMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除订单表dingdan数据
    @Override
    public int deleteById(Integer id) {
        return dingdanMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询订单表dingdan数据
    @Override
    public PageData<Dingdan> findPage(PageWrap<Dingdan> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        DingdanExample dingdanExample = getDingdanExampleByLike(pageWrap.getModel());
        dingdanExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Dingdan> list = dingdanMapper.selectByExample(dingdanExample);
        for (Dingdan info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询订单表dingdan数据
    @Override
    public PageData<Dingdan> findPageByEqualTo(PageWrap<Dingdan> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        DingdanExample dingdanExample = getDingdanExampleByEqualTo(pageWrap.getModel());
        dingdanExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Dingdan> list = dingdanMapper.selectByExample(dingdanExample);
        for (Dingdan info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Dingdan info){
        if (null != info){
            Zhifufangshi zhifufangshi= zhifufangshiMapper.selectByPrimaryKey(info.getZhifufangshiid());
            info.setZhifufangshi(zhifufangshi);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private DingdanExample getDingdanExampleByLike(Dingdan instance) {
        DingdanExample dingdanExample = new DingdanExample();
        DingdanExample.Criteria criteria = dingdanExample.createCriteria();
        //订单id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //编号bianhao模糊匹配
        if (null != instance.getBianhao() && !instance.getBianhao().equals("")) {
            criteria.andBianhaoLike("%" + instance.getBianhao() + "%");
        }
        //订单金额jine完全匹配
        if (null != instance.getJine()) {
            criteria.andJineEqualTo(instance.getJine());
        }
        //是否支付zhifushenhe模糊匹配
        if (null != instance.getZhifushenhe() && !instance.getZhifushenhe().equals("")) {
            criteria.andZhifushenheLike("%" + instance.getZhifushenhe() + "%");
        }
        //是否发货fahuoshenhe模糊匹配
        if (null != instance.getFahuoshenhe() && !instance.getFahuoshenhe().equals("")) {
            criteria.andFahuoshenheLike("%" + instance.getFahuoshenhe() + "%");
        }
        //是否收货shouhuoshenhe模糊匹配
        if (null != instance.getShouhuoshenhe() && !instance.getShouhuoshenhe().equals("")) {
            criteria.andShouhuoshenheLike("%" + instance.getShouhuoshenhe() + "%");
        }
        //支付方式zhifufangshiid完全匹配
        if (null != instance.getZhifufangshiid()) {
            criteria.andZhifufangshiidEqualTo(instance.getZhifufangshiid());
        }
        //姓名xingming模糊匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingLike("%" + instance.getXingming() + "%");
        }
        //电话dianhua模糊匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaLike("%" + instance.getDianhua() + "%");
        }
        //送货地址dizhi模糊匹配
        if (null != instance.getDizhi() && !instance.getDizhi().equals("")) {
            criteria.andDizhiLike("%" + instance.getDizhi() + "%");
        }
        //时间shijian模糊匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianLike("%" + instance.getShijian() + "%");
        }
        //物流信息wuliu模糊匹配
        if (null != instance.getWuliu() && !instance.getWuliu().equals("")) {
            criteria.andWuliuLike("%" + instance.getWuliu() + "%");
        }
        //备注beizhu模糊匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuLike("%" + instance.getBeizhu() + "%");
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return dingdanExample;
    }

    //字符类型完全相等查询条件构造器
    private DingdanExample getDingdanExampleByEqualTo(Dingdan instance) {
        DingdanExample dingdanExample = new DingdanExample();
        DingdanExample.Criteria criteria = dingdanExample.createCriteria();
        //订单id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //编号bianhao完全匹配
        if (null != instance.getBianhao() && !instance.getBianhao().equals("")) {
            criteria.andBianhaoEqualTo(instance.getBianhao());
        }
        //订单金额jine完全匹配
        if (null != instance.getJine()) {
            criteria.andJineEqualTo(instance.getJine());
        }
        //是否支付zhifushenhe完全匹配
        if (null != instance.getZhifushenhe() && !instance.getZhifushenhe().equals("")) {
            criteria.andZhifushenheEqualTo(instance.getZhifushenhe());
        }
        //是否发货fahuoshenhe完全匹配
        if (null != instance.getFahuoshenhe() && !instance.getFahuoshenhe().equals("")) {
            criteria.andFahuoshenheEqualTo(instance.getFahuoshenhe());
        }
        //是否收货shouhuoshenhe完全匹配
        if (null != instance.getShouhuoshenhe() && !instance.getShouhuoshenhe().equals("")) {
            criteria.andShouhuoshenheEqualTo(instance.getShouhuoshenhe());
        }
        //支付方式zhifufangshiid完全匹配
        if (null != instance.getZhifufangshiid()) {
            criteria.andZhifufangshiidEqualTo(instance.getZhifufangshiid());
        }
        //姓名xingming完全匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingEqualTo(instance.getXingming());
        }
        //电话dianhua完全匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaEqualTo(instance.getDianhua());
        }
        //送货地址dizhi完全匹配
        if (null != instance.getDizhi() && !instance.getDizhi().equals("")) {
            criteria.andDizhiEqualTo(instance.getDizhi());
        }
        //时间shijian完全匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianEqualTo(instance.getShijian());
        }
        //物流信息wuliu完全匹配
        if (null != instance.getWuliu() && !instance.getWuliu().equals("")) {
            criteria.andWuliuEqualTo(instance.getWuliu());
        }
        //备注beizhu完全匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuEqualTo(instance.getBeizhu());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return dingdanExample;
    }
}
