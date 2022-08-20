package com.heying.mybatis.mapper;

import com.heying.mybatis.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * mapper注解或者xml只能二选一
 * */
public interface StudentMapper {

//增->新建一个学生方法  注解sql语句
    //加一个配置  使用自增长  级联插入很有用
    //    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
//    @Insert("insert into student values(null,#{stuno},#{name},#{birthday},#{country}," +
//            "#{hobby},#{sex},#{tid})")
    void insertOne(Student student);

//查->查询单个
    //    @Select("select * from student where id=#{id}")
    Student selectById(Integer id);
//查->查询所有
    //    @Select("select * from student")
    List<Student> selectAll();
//改-> 更新信息
    //    @Update("update student set stuno=#{stuno},name=#{name}," +
//            "birthday=#{birthday},country=#{country},hobby=#{hobby}," +
//            "sex=#{sex},tid=#{tid} where id=#{id}")
    void updateOne(Student student);
//删->删除一行
    //    @Delete("delete from student where id=#{id}")
    void deleteOne(Integer id);

    //查学生对应的老师信息  这时用注解不太合适,可读性差  故选xml
    Student selectStudentAndTeacherByIdN1(Integer id);

    //N+1条语句
    List<Student> selectAllStudentAndTeacherN1();

    @Select("select * from student where tid=#{tid}")
    List<Student> selectByTid(Integer tid);

    List<Student> selectAllStudentAndTeacher();

}