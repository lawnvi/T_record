package com.exp.mapper;

import com.exp.model.pojo.DailyLog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DailyLogMapper {

    @Insert("insert into dailyLog (uid, userKind, time, operation) values(#{uid}, #{userKind}, #{time}, #{operation})")
    int addDailyLog(DailyLog log);

    @Select("select * from dailyLog where time > #{s} and time < #{e}")
    List<DailyLog> findDailyLogs(@Param("s") String s, @Param("e") String e);

    @Select("select * from dailyLog where uid = #{uid} and kind = #{kind}")
    List<DailyLog> findDailyLogsByUser(@Param("uid") String uid, @Param("kind") String kind);

    @Select("select * from dailyLog limit start, number")
    List<DailyLog> findDailyLogsWithPage(@Param("start") String start, @Param("number") String number);

}
