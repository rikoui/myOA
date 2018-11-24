package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.TableDaily;
import com.bjdreamtech.entity.TableDailyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableDailyMapper {
    int countByExample(TableDailyExample example);

    int deleteByExample(TableDailyExample example);

    int deleteByPrimaryKey(String dailyId);

    int insert(TableDaily record);

    int insertSelective(TableDaily record);

    List<TableDaily> selectByExample(TableDailyExample example);

    TableDaily selectByPrimaryKey(String dailyId);

    int updateByExampleSelective(@Param("record") TableDaily record, @Param("example") TableDailyExample example);

    int updateByExample(@Param("record") TableDaily record, @Param("example") TableDailyExample example);

    int updateByPrimaryKeySelective(TableDaily record);

    int updateByPrimaryKey(TableDaily record);
}