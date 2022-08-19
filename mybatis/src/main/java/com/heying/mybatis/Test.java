package com.heying.mybatis;

import com.heying.mybatis.entity.Student;
import com.heying.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(inputStream);
        //一级缓存
        SqlSession session = sqlSessionFactory.openSession();

        final Student student = new Student(null, "666", "666",
                new Date(), 1, "music", 1, null);
        final StudentMapper studentMapper = session.getMapper(StudentMapper.class);
//        studentMapper.insertOne(student);
//        System.out.println(student.getId());
//        final Student student1 = studentMapper.selectById(1);
//        System.out.println(student1);
//        final List<Student> students = studentMapper.selectAll();
//        System.out.println(students);
//        studentMapper.updateOne(student);
//        studentMapper.deleteOne(666);
//        final Student student1 = studentMapper.selectStudentAndTeacherById(1);
//        System.out.println(student1);
//        System.out.println(student1.getTeacher());
//        final List<Student> students = studentMapper.selectAllStudentAndTeacherN1();
//        System.out.println(students);
//        students.forEach(student1 -> System.out.println(student1.getTeacher()));

//        final TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
//        final Teacher teacher = teacherMapper.selectTeacherAndStuById(1);
//        System.out.println(teacher);
//        System.out.println(teacher.getStudents());
        final List<Student> students = studentMapper.selectAllStudentAndTeacher();
        System.out.println(students);
        students.forEach(student1 -> System.out.println(student1.getTeacher()));
        session.commit();
        session.close();

    }
}
