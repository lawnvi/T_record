package com.exp.mapper;

import com.exp.model.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Insert("insert into member (name, sex, tel, email, backTime, backFrom, fid, psw) values(#{name}, #{sex}, #{tel}, #{email}, #{backTime}, #{backFrom}, #{fid}, #{psw})")
    int addMember(Member member);

    @Select("select * from member where fid = #{fid}")
    List<Member> findMembers(int fid);

    @Select("select * from member where id = #{id}")
    List<Member> findMemberById(int id);

    @Select("select * from member where name = #{name}")
    List<Member> findMemberByName(String name);

    @Select("select * from member where backFrom like #{place}")
    List<Member> findMemberByFrom(String place);

    @Select("select * from member where email = #{email}")
    Member findMemberByEmail(String email);

    @Select("select * from member where tel = #{tel}")
    Member findMemberByTel(String tel);

    @Update("update member set name=#{name}, sex=#{sex}, tel=#{tel}, email=#{email}, backTime=#{backTime}, backFrom=#{backFrom}")
    int updateMember(Member member);

}
