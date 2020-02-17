package com.exp.mapper;

import com.exp.model.pojo.TLog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    private Integer id;
    private Integer mid;
    private String date;
    private String time;
    private Double t;
    private String notes;
 */
@Mapper
public interface TLogMapper {
    @Insert("insert into t_log (mid, time, date, t, notes) values(#{mid}, #{time}, #{date}, #{t}, #{notes})")
    int addTLog(TLog log);

    @Update("update t_log set t = #{t}, notes=#{notes} where id = #{id}")
    int updateTLog(TLog log);

    @Select("select * from t_log where mid = #{mid} order by date desc")
    List<TLog> findAllTLogsByMid(int mid);

    @Select("select * from t_log where mid in (select mid from family where id = #{fid}) order by date desc, time desc, mid asc limit #{start}, #{number}")
    List<TLog> findTLogsByFidWithPage(@Param("fid") int fid, @Param("start") int start, @Param("number") int number);

    @Select("select * from t_log where mid = #{mid} and date = #{date} order by time desc")
    List<TLog> findTLogsByDate(@Param("mid") int mid, @Param("date") String date);

    @Select("select * from t_log where t >= #{t} and date = #{date} order by date desc")
    List<TLog> findTLogsByT(@Param("t")double t, @Param("date")String date);

    @Select("select * from t_log where id = #{id}")
    TLog findTLogById(int id);

    @Select("select count(*) from t_log where mid in (select mid from family where id = #{fid})")
    int getTLogsCountByFid(@Param("fid") int fid);

}
