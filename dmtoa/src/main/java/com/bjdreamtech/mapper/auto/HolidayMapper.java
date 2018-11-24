package com.bjdreamtech.mapper.auto;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bjdreamtech.entity.Holiday;
import com.bjdreamtech.entity.HolidayExample;

public interface HolidayMapper {
    int countByExample(HolidayExample example);

    int deleteByExample(HolidayExample example);

    int deleteByPrimaryKey(String holidayId);

    int insert(Holiday record);

    int insertSelective(Holiday record);

    List<Holiday> selectByExample(HolidayExample example);

    int updateByExampleSelective(@Param("record") Holiday record, @Param("example") HolidayExample example);

    int updateByExample(@Param("record") Holiday record, @Param("example") HolidayExample example);
}