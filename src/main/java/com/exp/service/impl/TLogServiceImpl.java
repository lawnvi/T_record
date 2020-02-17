package com.exp.service.impl;

import com.exp.mapper.FamilyMapper;
import com.exp.mapper.MemberMapper;
import com.exp.mapper.TLogMapper;
import com.exp.model.pojo.Member;
import com.exp.model.pojo.TLog;
import com.exp.model.vo.TLogVO;
import com.exp.service.TLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TLogServiceImpl implements TLogService {
    @Autowired
    private TLogMapper tLogMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int addTLog(TLog log) {
        return tLogMapper.addTLog(log);
    }

    @Override
    public int updateTLog(TLog log) {
        return tLogMapper.updateTLog(log);
    }

    @Override
    public List<TLog> findAllTLogsByMid(int mid) {
        return tLogMapper.findAllTLogsByMid(mid);
    }

    @Override
    public List<TLog> findTLogsByDate(int mid, String date) {
        return tLogMapper.findTLogsByDate(mid, date);
    }

    @Override
    public TLog findTLogById(int id) {
        return tLogMapper.findTLogById(id);
    }

    @Override
    public List<TLog> findTLogsByT(double t, String date){
        return tLogMapper.findTLogsByT(t, date);
    }

    @Override
    public List<TLogVO> findTLogsByFid(int fid, String date) {
        List<TLogVO> logVOS = new ArrayList<>();
        List<Member> members = memberMapper.findMembers(fid);
        for (Member member : members) {
            System.out.println("mid:"+member.getId());
            List<TLog> logs = tLogMapper.findTLogsByDate(member.getId(), date);
            if(logs.size() > 0) {
                TLogVO tLogVO = new TLogVO(logs.get(0));
                tLogVO.setmName(member.getName());
                logVOS.add(tLogVO);
            }
        }
        return logVOS;
    }

    @Override
    public List<TLogVO> findTLogsByFidWithPage(int fid, int page, int number) {
        int start = (page - 1) * number;
        List<Member> members = memberMapper.findMembers(fid);
        List<TLog> logs = tLogMapper.findTLogsByFidWithPage(fid, start, number);
        HashMap<Integer, String > map = new HashMap<>();
        for (Member m : members) {
            map.put(m.getId(), m.getName());
        }
        List<TLogVO> logVOS = new ArrayList<>();
        for (TLog log: logs) {
            TLogVO vo = new TLogVO(log);
            vo.setmName(map.get(log.getMid()));
            logVOS.add(vo);
        }
        return logVOS;
    }

    @Override
    @Transactional
    public boolean reportTs(List<TLog> logs) {
        for (TLog log : logs) {
            tLogMapper.addTLog(log);
        }
        return true;
    }

    @Override
    public int getTLogsCountByFid(int fid) {
        return tLogMapper.getTLogsCountByFid(fid);
    }
}
