package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.LeavePerson;
import com.bjdreamtech.entity.LeavePersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavePersonMapper {
    int countByExample(LeavePersonExample example);

    int deleteByExample(LeavePersonExample example);

    int deleteByPrimaryKey(String levaeId);

    int insert(LeavePerson record);

    int insertSelective(LeavePerson record);

    List<LeavePerson> selectByExample(LeavePersonExample example);

    LeavePerson selectByPrimaryKey(String levaeId);

    int updateByExampleSelective(@Param("record") LeavePerson record, @Param("example") LeavePersonExample example);

    int updateByExample(@Param("record") LeavePerson record, @Param("example") LeavePersonExample example);

    int updateByPrimaryKeySelective(LeavePerson record);

    int updateByPrimaryKey(LeavePerson record);
}