package com.exp.service;

import com.exp.model.pojo.Member;
import java.util.List;

public interface MemberService {
    List<Member> findMembers(int fid);

    List<Member> findMemberById(int id);

    List<Member> findMemberByName(String name);

    List<Member> findMemberByFrom(String place);

    Member findMemberByEmail(String email);

    Member findMemberByTel(String tel);

    int updateMember(Member member);
}
