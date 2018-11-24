package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.SysParam;
import com.bjdreamtech.entity.SysParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParamMapper {
    int countByExample(SysParamExample example);

    int deleteByExample(SysParamExample example);

    int deleteByPrimaryKey(String paramId);

    int insert(SysParam record);

    int insertSelective(SysParam record);

    List<SysParam> selectByExample(SysParamExample example);

    SysParam selectByPrimaryKey(String paramId);

    int updateByExampleSelective(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByExample(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByPrimaryKeySelective(SysParam record);

    int updateByPrimaryKey(SysParam record);
}