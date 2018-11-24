package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.SysAuthvali;
import com.bjdreamtech.entity.SysAuthvaliExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthvaliMapper {
    int countByExample(SysAuthvaliExample example);

    int deleteByExample(SysAuthvaliExample example);

    int deleteByPrimaryKey(String authvaliId);

    int insert(SysAuthvali record);

    int insertSelective(SysAuthvali record);

    List<SysAuthvali> selectByExample(SysAuthvaliExample example);

    SysAuthvali selectByPrimaryKey(String authvaliId);

    int updateByExampleSelective(@Param("record") SysAuthvali record, @Param("example") SysAuthvaliExample example);

    int updateByExample(@Param("record") SysAuthvali record, @Param("example") SysAuthvaliExample example);

    int updateByPrimaryKeySelective(SysAuthvali record);

    int updateByPrimaryKey(SysAuthvali record);
}