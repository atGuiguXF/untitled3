package com.heying.mybatis.mapper;

import com.heying.mybatis.entity.Student;
import org.apache.ibatis.annotations.Insert;

public interface StudentMapper {
    @Insert("insert into student values(#{id},#{stuno},#{name},#{birthday},#{country}," +
            "#{hobby},#{sex},#{tid})")
    void insertOne(Student student);
}
