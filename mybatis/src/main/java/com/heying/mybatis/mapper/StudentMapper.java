package com.heying.mybatis.mapper;

import com.heying.mybatis.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {


    //    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
//    @Insert("insert into student values(null,#{stuno},#{name},#{birthday},#{country}," +
//            "#{hobby},#{sex},#{tid})")
    void insertOne(Student student);

    //    @Select("select * from student where id=#{id}")
    Student selectById(Integer id);

    //    @Select("select * from student")
    List<Student> selectAll();

    //    @Update("update student set stuno=#{stuno},name=#{name}," +
//            "birthday=#{birthday},country=#{country},hobby=#{hobby}," +
//            "sex=#{sex},tid=#{tid} where id=#{id}")
    void updateOne(Student student);

    //    @Delete("delete from student where id=#{id}")
    void deleteOne(Integer id);

    Student selectStudentAndTeacherByIdN1(Integer id);

    //N+1条语句
    List<Student> selectAllStudentAndTeacherN1();

    @Select("select * from student where tid=#{tid}")
    List<Student> selectByTid(Integer tid);

    List<Student> selectAllStudentAndTeacher();

}