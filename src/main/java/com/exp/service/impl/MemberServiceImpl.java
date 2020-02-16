package com.exp.service.impl;

import com.exp.mapper.MemberMapper;
import com.exp.model.pojo.Member;
import com.exp.service.MemberService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> findMembers(int fid) {
        return memberMapper.findMembers(fid);
    }

    @Override
    public List<Member> findMemberById(int id) {
        return memberMapper.findMemberById(id);
    }

    @Override
    public List<Member> findMemberByName(String name) {
        return memberMapper.findMemberByName(name);
    }

    @Override
    public List<Member> findMemberByFrom(String place) {
        return memberMapper.findMemberByFrom(place);
    }

    @Override
    public Member findMemberByEmail(String email) {
        return memberMapper.findMemberByEmail(email);
    }

    @Override
    public Member findMemberByTel(String tel) {
        return memberMapper.findMemberByTel(tel);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateMember(member);
    }
}
