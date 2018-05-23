package com.joylink.userms.dao;

import com.joylink.userms.entity.SysDictionary;
import com.joylink.userms.entity.SysDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictionaryMapper {
    long countByExample(SysDictionaryExample example);

    int deleteByExample(SysDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDictionary record);

    int insertSelective(SysDictionary record);

    List<SysDictionary> selectByExample(SysDictionaryExample example);

    SysDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDictionary record, @Param("example") SysDictionaryExample example);

    int updateByExample(@Param("record") SysDictionary record, @Param("example") SysDictionaryExample example);

    int updateByPrimaryKeySelective(SysDictionary record);

    int updateByPrimaryKey(SysDictionary record);
}