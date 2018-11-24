package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.TableWeekly;
import com.bjdreamtech.entity.TableWeeklyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableWeeklyMapper {
    int countByExample(TableWeeklyExample example);

    int deleteByExample(TableWeeklyExample example);

    int deleteByPrimaryKey(String weeklyId);

    int insert(TableWeekly record);

    int insertSelective(TableWeekly record);

    List<TableWeekly> selectByExample(TableWeeklyExample example);

    TableWeekly selectByPrimaryKey(String weeklyId);

    int updateByExampleSelective(@Param("record") TableWeekly record, @Param("example") TableWeeklyExample example);

    int updateByExample(@Param("record") TableWeekly record, @Param("example") TableWeeklyExample example);

    int updateByPrimaryKeySelective(TableWeekly record);

    int updateByPrimaryKey(TableWeekly record);
}