package com.exp.mapper;

import com.exp.model.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    @Insert("insert into member (name, sex, tel, email, backTime, backFrom, fid, psw) values(#{name}, #{sex}, #{tel}, #{email}, #{backTime}, #{backFrom}, #{fid}, #{psw})")
    int addMember(Member member);
}
