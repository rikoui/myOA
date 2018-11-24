package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.SysAuth;
import com.bjdreamtech.entity.SysAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthMapper {
    int countByExample(SysAuthExample example);

    int deleteByExample(SysAuthExample example);

    int deleteByPrimaryKey(String authId);

    int insert(SysAuth record);

    int insertSelective(SysAuth record);

    List<SysAuth> selectByExample(SysAuthExample example);

    SysAuth selectByPrimaryKey(String authId);

    int updateByExampleSelective(@Param("record") SysAuth record, @Param("example") SysAuthExample example);

    int updateByExample(@Param("record") SysAuth record, @Param("example") SysAuthExample example);

    int updateByPrimaryKeySelective(SysAuth record);

    int updateByPrimaryKey(SysAuth record);
}