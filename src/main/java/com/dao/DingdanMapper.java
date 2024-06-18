package com.dao;

import com.entity.Dingdan;
import com.entity.DingdanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DingdanMapper
 * @Description 订单模块数据持久层
 */
public interface DingdanMapper {

    //根据条件获取订单表dingdan的数据数量
    int countByExample(DingdanExample example);

    //根据条件删除订单表dingdan的数据
    int deleteByExample(DingdanExample example);

    //根据主键ID列删除订单表dingdan的数据
    int deleteByPrimaryKey(Integer id);

    //插入订单表dingdan的实体数据（包含null值）
    int insert(Dingdan record);

    //插入订单表dingdan的实体数据（不包含null值）
    int insertSelective(Dingdan record);

    //根据条件获取订单表dingdan的数据列表
    List<Dingdan> selectByExample(DingdanExample example);

    //根据主键ID列获取订单表dingdan的数据实体
    Dingdan selectByPrimaryKey(Integer id);

    //根据条件更新订单表dingdan的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Dingdan record, @Param("example") DingdanExample example);

    //根据条件更新订单表dingdan的实体数据（包含null值）
    int updateByExample(@Param("record") Dingdan record, @Param("example") DingdanExample example);

    //根据主键ID列更新订单表dingdan的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Dingdan record);

    //根据主键ID列更新订单表dingdan的实体数据（包含null值）
    int updateByPrimaryKey(Dingdan record);
}
