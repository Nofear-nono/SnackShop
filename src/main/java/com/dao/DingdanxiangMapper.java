package com.dao;

import com.entity.Dingdanxiang;
import com.entity.DingdanxiangExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DingdanxiangMapper
 * @Description 订单项模块数据持久层
 */
public interface DingdanxiangMapper {

    //根据条件获取订单项表dingdanxiang的数据数量
    int countByExample(DingdanxiangExample example);

    //根据条件删除订单项表dingdanxiang的数据
    int deleteByExample(DingdanxiangExample example);

    //根据主键ID列删除订单项表dingdanxiang的数据
    int deleteByPrimaryKey(Integer id);

    //插入订单项表dingdanxiang的实体数据（包含null值）
    int insert(Dingdanxiang record);

    //插入订单项表dingdanxiang的实体数据（不包含null值）
    int insertSelective(Dingdanxiang record);

    //根据条件获取订单项表dingdanxiang的数据列表
    List<Dingdanxiang> selectByExample(DingdanxiangExample example);

    //根据主键ID列获取订单项表dingdanxiang的数据实体
    Dingdanxiang selectByPrimaryKey(Integer id);

    //根据条件更新订单项表dingdanxiang的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Dingdanxiang record, @Param("example") DingdanxiangExample example);

    //根据条件更新订单项表dingdanxiang的实体数据（包含null值）
    int updateByExample(@Param("record") Dingdanxiang record, @Param("example") DingdanxiangExample example);

    //根据主键ID列更新订单项表dingdanxiang的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Dingdanxiang record);

    //根据主键ID列更新订单项表dingdanxiang的实体数据（包含null值）
    int updateByPrimaryKey(Dingdanxiang record);
}
