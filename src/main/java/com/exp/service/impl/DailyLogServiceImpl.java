package com.exp.service.impl;

import com.exp.mapper.DailyLogMapper;
import com.exp.model.pojo.DailyLog;
import com.exp.service.DailyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyLogServiceImpl implements DailyLogService {
    @Autowired
    private DailyLogMapper dailyLogMapper;

    @Override
    public int addDailyLog(DailyLog log) {
        return dailyLogMapper.addDailyLog(log);
    }

    @Override
    public List<DailyLog> findDailyLogs(String s, String e) {
        return dailyLogMapper.findDailyLogs(s, e);
    }

    @Override
    public List<DailyLog> findDailyLogsByUser(String uid, String kind) {
        return dailyLogMapper.findDailyLogsByUser(uid, kind);
    }

    @Override
    public List<DailyLog> findDailyLogsWithPage(String start, String number) {
        return dailyLogMapper.findDailyLogsWithPage(start, number);
    }
}
