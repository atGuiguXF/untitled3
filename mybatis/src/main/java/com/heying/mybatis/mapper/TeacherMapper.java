package com.heying.mybatis.mapper;

import com.heying.mybatis.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Select("select * from teacher where id=#{id}")
    Teacher selectById(Integer id);

    @ResultMap("teacherAndStuMap")
    @Select("select * from teacher where id=#{id}")
    Teacher selectTeacherAndStuById(Integer id);

    List<Teacher> selectAllTeacherAndStudent();

    List<Teacher> selectSomeTeacherAndStudent(@Param("name") String name, @Param("age") Integer age);
}
