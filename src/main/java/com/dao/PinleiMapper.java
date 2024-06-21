package com.dao;

import com.entity.Pinlei;
import com.entity.PinleiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName PinleiMapper
 * @Description 分类模块数据持久层
 */

public interface PinleiMapper {
    //根据条件获取分类表的数据数量
    int countByExample(PinleiExample example);

    //根据条件删除分类表的数据
    int deleteByExample(PinleiExample example);

    //根据主键ID列删除分类表的数据
    int deleteByPrimaryKey(Integer id);

    //插入分类表的实体数据（包含null值）
    int insert(Pinlei record);

    //插入分类表的实体数据（不包含null值）
    int insertSelective(Pinlei record);

    //根据条件获取分类表的数据列表
    List<Pinlei> selectByExample(PinleiExample example);

    //根据主键ID列获取分类表的数据实体
    Pinlei selectByPrimaryKey(Integer id);

    //根据条件更新分类表的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Pinlei record, @Param("example") PinleiExample example);

    //根据条件更新分类表的实体数据（包含null值）
    int updateByExample(@Param("record") Pinlei record, @Param("example") PinleiExample example);

    //根据主键ID列更新分类表的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Pinlei record);

    //根据主键ID列更新分类表的实体数据（包含null值）
    int updateByPrimaryKey(Pinlei record);
}