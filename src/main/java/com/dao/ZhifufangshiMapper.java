package com.dao;

import com.entity.Zhifufangshi;
import com.entity.ZhifufangshiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ZhifufangshiMapper
 * @Description 支付方式模块数据持久层
 */

public interface ZhifufangshiMapper {
    //根据条件获取支付方式表的数据数量
    int countByExample(ZhifufangshiExample example);

    //根据条件删除支付方式表的数据
    int deleteByExample(ZhifufangshiExample example);

    //根据主键ID列删除支付方式表的数据
    int deleteByPrimaryKey(Integer id);

    //插入支付方式表的实体数据（包含null值）
    int insert(Zhifufangshi record);

    //插入支付方式表的实体数据（不包含null值）
    int insertSelective(Zhifufangshi record);

    //根据条件获取支付方式表的数据列表
    List<Zhifufangshi> selectByExample(ZhifufangshiExample example);

    //根据主键ID列获取支付方式表的数据实体
    Zhifufangshi selectByPrimaryKey(Integer id);

    //根据条件更新支付方式表的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Zhifufangshi record, @Param("example") ZhifufangshiExample example);

    //根据条件更新支付方式表的实体数据（包含null值）
    int updateByExample(@Param("record") Zhifufangshi record, @Param("example") ZhifufangshiExample example);

    //根据主键ID列更新支付方式表的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Zhifufangshi record);

    //根据主键ID列更新支付方式表的实体数据（包含null值）
    int updateByPrimaryKey(Zhifufangshi record);
}
