package com.exp.service;

import com.exp.model.pojo.DailyLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DailyLogService {
    int addDailyLog(DailyLog log);

    List<DailyLog> findDailyLogs(@Param("s") String s, @Param("e") String e);

    List<DailyLog> findDailyLogsByUser(@Param("uid") String uid, @Param("kind") String kind);

    List<DailyLog> findDailyLogsWithPage(@Param("start") String start, @Param("number") String number);
}
