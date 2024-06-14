package com.dao;

import com.entity.Shenqing;
import com.entity.ShenqingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ShenqingMapper
 * @Description 售后申请模块数据持久层
 */
public interface ShenqingMapper {

    //根据条件获取售后申请表shenqing的数据数量
    int countByExample(ShenqingExample example);

    //根据条件删除售后申请表shenqing的数据
    int deleteByExample(ShenqingExample example);

    //根据主键ID列删除售后申请表shenqing的数据
    int deleteByPrimaryKey(Integer id);

    //插入售后申请表shenqing的实体数据（包含null值）
    int insert(Shenqing record);

    //插入售后申请表shenqing的实体数据（不包含null值）
    int insertSelective(Shenqing record);

    //根据条件获取售后申请表shenqing的数据列表
    List<Shenqing> selectByExample(ShenqingExample example);

    //根据主键ID列获取售后申请表shenqing的数据实体
    Shenqing selectByPrimaryKey(Integer id);

    //根据条件更新售后申请表shenqing的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Shenqing record, @Param("example") ShenqingExample example);

    //根据条件更新售后申请表shenqing的实体数据（包含null值）
    int updateByExample(@Param("record") Shenqing record, @Param("example") ShenqingExample example);

    //根据主键ID列更新售后申请表shenqing的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Shenqing record);

    //根据主键ID列更新售后申请表shenqing的实体数据（包含null值）
    int updateByPrimaryKey(Shenqing record);
}
