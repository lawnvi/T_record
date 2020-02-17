package com.exp.service;

import com.exp.model.pojo.TLog;
import com.exp.model.vo.TLogVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TLogService {
    int addTLog(TLog log);

    int updateTLog(TLog log);

    List<TLog> findAllTLogsByMid(int mid);

    List<TLog> findTLogsByDate(int mid, String date);

    TLog findTLogById(int id);

    List<TLog> findTLogsByT(double t, String date);

    List<TLogVO> findTLogsByFid(int fid, String date);

    List<TLogVO> findTLogsByFidWithPage(int fid, int page, int number);

    boolean reportTs(List<TLog> logs);

    int getTLogsCountByFid(@Param("fid") int fid);
}
