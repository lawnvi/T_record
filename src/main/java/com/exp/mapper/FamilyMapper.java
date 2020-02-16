package com.exp.mapper;

import com.exp.model.pojo.Family;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FamilyMapper {
    @Insert("insert into family (account, cid, name, address, number, reporter, psw) values(#{account}, #{cid}, #{name}, #{address}, #{number}, #{reporter}, #{psw})")
    int addFamily(Family family);

    @Select("select * from family where id = #{id}")
    Family findFamilyById(int id);

    @Select("select * from family where account = #{account} && psw = #{psw}")
    Family loginFamily(Family family);

    @Select("select * from family where account = #{account}")
    Family findFamilyByAccount(String account);

    @Update("update family set name = #{name}, address = #{address}, reporter = #{reporter} where id = #{id}")
    int updateFamily(Family family);
}
