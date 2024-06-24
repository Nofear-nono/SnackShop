package com.dao;

import com.entity.Xinwen;
import com.entity.XinwenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName XinwenMapper
 * @Description 新闻模块数据持久层
 */
public interface XinwenMapper {

    //根据条件获取新闻表xinwen的数据数量
    int countByExample(XinwenExample example);

    //根据条件删除新闻表xinwen的数据
    int deleteByExample(XinwenExample example);

    //根据主键ID列删除新闻表xinwen的数据
    int deleteByPrimaryKey(Integer id);

    //插入新闻表xinwen的实体数据（包含null值）
    int insert(Xinwen record);

    //插入新闻表xinwen的实体数据（不包含null值）
    int insertSelective(Xinwen record);

    //根据条件获取新闻表xinwen的数据列表
    List<Xinwen> selectByExample(XinwenExample example);

    //根据主键ID列获取新闻表xinwen的数据实体
    Xinwen selectByPrimaryKey(Integer id);

    //根据条件更新新闻表xinwen的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Xinwen record, @Param("example") XinwenExample example);

    //根据条件更新新闻表xinwen的实体数据（包含null值）
    int updateByExample(@Param("record") Xinwen record, @Param("example") XinwenExample example);

    //根据主键ID列更新新闻表xinwen的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Xinwen record);

    //根据主键ID列更新新闻表xinwen的实体数据（包含null值）
    int updateByPrimaryKey(Xinwen record);
}
