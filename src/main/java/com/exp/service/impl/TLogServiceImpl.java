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
            for (TLog log : logs) {
                TLogVO tLogVO = new TLogVO();
                tLogVO.setmName(member.getName());
                tLogVO.settLog(log);
                logVOS.add(tLogVO);
            }
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
}
