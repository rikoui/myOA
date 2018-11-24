package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.TableNextplan;
import com.bjdreamtech.entity.TableNextplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableNextplanMapper {
    int countByExample(TableNextplanExample example);

    int deleteByExample(TableNextplanExample example);

    int deleteByPrimaryKey(String nextplanId);

    int insert(TableNextplan record);

    int insertSelective(TableNextplan record);

    List<TableNextplan> selectByExample(TableNextplanExample example);

    TableNextplan selectByPrimaryKey(String nextplanId);

    int updateByExampleSelective(@Param("record") TableNextplan record, @Param("example") TableNextplanExample example);

    int updateByExample(@Param("record") TableNextplan record, @Param("example") TableNextplanExample example);

    int updateByPrimaryKeySelective(TableNextplan record);

    int updateByPrimaryKey(TableNextplan record);
}