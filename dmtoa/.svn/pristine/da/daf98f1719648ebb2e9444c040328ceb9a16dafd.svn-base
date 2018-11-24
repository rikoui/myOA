package com.bjdreamtech.mapper.auto;

import com.bjdreamtech.entity.TableTicket;
import com.bjdreamtech.entity.TableTicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableTicketMapper {
    int countByExample(TableTicketExample example);

    int deleteByExample(TableTicketExample example);

    int deleteByPrimaryKey(String ticketId);

    int insert(TableTicket record);

    int insertSelective(TableTicket record);

    List<TableTicket> selectByExample(TableTicketExample example);

    TableTicket selectByPrimaryKey(String ticketId);

    int updateByExampleSelective(@Param("record") TableTicket record, @Param("example") TableTicketExample example);

    int updateByExample(@Param("record") TableTicket record, @Param("example") TableTicketExample example);

    int updateByPrimaryKeySelective(TableTicket record);

    int updateByPrimaryKey(TableTicket record);
}