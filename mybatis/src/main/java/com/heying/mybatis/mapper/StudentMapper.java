package com.heying.mybatis.mapper;

import com.heying.mybatis.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * mapper注解或者xml只能二选一
 */
//@CacheNamespace //二级缓存 不能同时存在 要么myBatis @CacheNamespace 要么 xml中用 <cache/>
public interface StudentMapper {

    //增->新建一个学生方法  注解sql语句
    //加一个配置  使用自增长/属性/字段名  级联插入很有用
    //    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
//    @Insert("insert into student values(null,#{stuno},#{name},#{birthday},#{country}," +
//            "#{hobby},#{sex},#{tid})")//注解 + sql语句
    void insertOne(Student student);//插入无返回值 void insertOne()方法 里面封装学生实例

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
//    @Select("select * from student")
//    @Results(id="stuTeacherN1RM", value={
//            //多对一
//            @Result(column="tid", property="teacher", javaType= Teacher.class,
//                    one=@One(fetchType = FetchType.EAGER,
//                            select="com.heying.mybatis.mapper.TeacherMapper.findById"))
//    })
    List<Student> selectAllStudentAndTeacherN1();

    @Select("select * from student where tid=#{tid}")
    List<Student> selectByTid(Integer tid);

    List<Student> selectAllStudentAllTeacher();

    List<Student> selectSomeStudentAndTeacher(Student condition);

    void updateSomeStudentCols(Student student);

    //删除指定多个
    void deleteSome(Integer[] ids);


    //查询学生 老师 成绩 和对应课程
    List<Student> selectSomeStudentAndTeacherAndScoreAndCourse(Student condition);

}