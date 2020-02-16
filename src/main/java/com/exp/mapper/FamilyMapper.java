package com.exp.mapper;

import com.exp.model.pojo.Family;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FamilyMapper {
    @Insert("insert into family (name, address, number, reporter) values(#{name}, #{address}, #{number}, #{reporter})")
    int addFamily(Family family);

    @Select("select * from faminly where id = #{id}")
    Family findFamilyById(int id);
}
