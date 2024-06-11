package com.dao;

import com.entity.Payment;
/**
 * @ClassName PaymentMapper
 * @Description 支付方式模块数据持久层
 */
public interface PaymentMapper {
    //插入支付方式表的实体数据
    int insert(Payment record);

    //根据ID删除支付方式表的数据
    int deleteByPrimaryKey(Integer id);

    //根据ID更新支付方式表的实体数据
    int updateByPrimaryKey(Payment record);

    //根据ID获取支付方式表的数据
    Payment selectByPrimaryKey(Integer id);
}
