package com.joylink.userms.dao;

import com.joylink.userms.entity.SysDictionaryDetail;
import com.joylink.userms.entity.SysDictionaryDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictionaryDetailMapper {
    long countByExample(SysDictionaryDetailExample example);

    int deleteByExample(SysDictionaryDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDictionaryDetail record);

    int insertSelective(SysDictionaryDetail record);

    List<SysDictionaryDetail> selectByExample(SysDictionaryDetailExample example);

    SysDictionaryDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDictionaryDetail record, @Param("example") SysDictionaryDetailExample example);

    int updateByExample(@Param("record") SysDictionaryDetail record, @Param("example") SysDictionaryDetailExample example);

    int updateByPrimaryKeySelective(SysDictionaryDetail record);

    int updateByPrimaryKey(SysDictionaryDetail record);
}