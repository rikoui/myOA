package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.SysControl;
import com.bjdreamtech.entity.SysControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysControlMapper {
    int countByExample(SysControlExample example);

    int deleteByExample(SysControlExample example);

    int deleteByPrimaryKey(String controlId);

    int insert(SysControl record);

    int insertSelective(SysControl record);

    List<SysControl> selectByExample(SysControlExample example);

    SysControl selectByPrimaryKey(String controlId);

    int updateByExampleSelective(@Param("record") SysControl record, @Param("example") SysControlExample example);

    int updateByExample(@Param("record") SysControl record, @Param("example") SysControlExample example);

    int updateByPrimaryKeySelective(SysControl record);

    int updateByPrimaryKey(SysControl record);
}