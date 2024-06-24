package com.dao;

import com.entity.Shoucang;
import com.entity.ShoucangExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ShoucangMapper
 * @Description 收藏模块数据持久层
 */
public interface ShoucangMapper {

    //根据条件获取收藏表shoucang的数据数量
    int countByExample(ShoucangExample example);

    //根据条件删除收藏表shoucang的数据
    int deleteByExample(ShoucangExample example);

    //根据主键ID列删除收藏表shoucang的数据
    int deleteByPrimaryKey(Integer id);

    //插入收藏表shoucang的实体数据（包含null值）
    int insert(Shoucang record);

    //插入收藏表shoucang的实体数据（不包含null值）
    int insertSelective(Shoucang record);

    //根据条件获取收藏表shoucang的数据列表
    List<Shoucang> selectByExample(ShoucangExample example);

    //根据主键ID列获取收藏表shoucang的数据实体
    Shoucang selectByPrimaryKey(Integer id);

    //根据条件更新收藏表shoucang的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Shoucang record, @Param("example") ShoucangExample example);

    //根据条件更新收藏表shoucang的实体数据（包含null值）
    int updateByExample(@Param("record") Shoucang record, @Param("example") ShoucangExample example);

    //根据主键ID列更新收藏表shoucang的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Shoucang record);

    //根据主键ID列更新收藏表shoucang的实体数据（包含null值）
    int updateByPrimaryKey(Shoucang record);
}
