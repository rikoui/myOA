package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.SysLogin;
import com.bjdreamtech.entity.SysLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginMapper {
    int countByExample(SysLoginExample example);

    int deleteByExample(SysLoginExample example);

    int deleteByPrimaryKey(String loginId);

    int insert(SysLogin record);

    int insertSelective(SysLogin record);

    List<SysLogin> selectByExample(SysLoginExample example);

    SysLogin selectByPrimaryKey(String loginId);

    int updateByExampleSelective(@Param("record") SysLogin record, @Param("example") SysLoginExample example);

    int updateByExample(@Param("record") SysLogin record, @Param("example") SysLoginExample example);

    int updateByPrimaryKeySelective(SysLogin record);

    int updateByPrimaryKey(SysLogin record);
}