package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.TableSalary;
import com.bjdreamtech.entity.TableSalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableSalaryMapper {
    int countByExample(TableSalaryExample example);

    int deleteByExample(TableSalaryExample example);

    int deleteByPrimaryKey(String salaryId);

    int insert(TableSalary record);

    int insertSelective(TableSalary record);

    List<TableSalary> selectByExample(TableSalaryExample example);

    TableSalary selectByPrimaryKey(String salaryId);

    int updateByExampleSelective(@Param("record") TableSalary record, @Param("example") TableSalaryExample example);

    int updateByExample(@Param("record") TableSalary record, @Param("example") TableSalaryExample example);

    int updateByPrimaryKeySelective(TableSalary record);

    int updateByPrimaryKey(TableSalary record);
}