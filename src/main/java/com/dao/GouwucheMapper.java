package com.dao;

import com.entity.Gouwuche;
import com.entity.GouwucheExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GouwucheMapper
 * @Description 购物车模块数据持久层
 */
public interface GouwucheMapper {

    //根据条件获取购物车表gouwuche的数据数量
    int countByExample(GouwucheExample example);

    //根据条件删除购物车表gouwuche的数据
    int deleteByExample(GouwucheExample example);

    //根据主键ID列删除购物车表gouwuche的数据
    int deleteByPrimaryKey(Integer id);

    //插入购物车表gouwuche的实体数据（包含null值）
    int insert(Gouwuche record);

    //插入购物车表gouwuche的实体数据（不包含null值）
    int insertSelective(Gouwuche record);

    //根据条件获取购物车表gouwuche的数据列表
    List<Gouwuche> selectByExample(GouwucheExample example);

    //根据主键ID列获取购物车表gouwuche的数据实体
    Gouwuche selectByPrimaryKey(Integer id);

    //根据条件更新购物车表gouwuche的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Gouwuche record, @Param("example") GouwucheExample example);

    //根据条件更新购物车表gouwuche的实体数据（包含null值）
    int updateByExample(@Param("record") Gouwuche record, @Param("example") GouwucheExample example);

    //根据主键ID列更新购物车表gouwuche的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Gouwuche record);

    //根据主键ID列更新购物车表gouwuche的实体数据（包含null值）
    int updateByPrimaryKey(Gouwuche record);
}
