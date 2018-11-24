package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.SysAdmin;
import com.bjdreamtech.entity.SysAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdminMapper {
    int countByExample(SysAdminExample example);

    int deleteByExample(SysAdminExample example);

    int deleteByPrimaryKey(String adminId);

    int insert(SysAdmin record);

    int insertSelective(SysAdmin record);

    List<SysAdmin> selectByExample(SysAdminExample example);

    SysAdmin selectByPrimaryKey(String adminId);

    int updateByExampleSelective(@Param("record") SysAdmin record, @Param("example") SysAdminExample example);

    int updateByExample(@Param("record") SysAdmin record, @Param("example") SysAdminExample example);

    int updateByPrimaryKeySelective(SysAdmin record);

    int updateByPrimaryKey(SysAdmin record);
}