package com.heying.mybatis;

import com.heying.mybatis.entity.Course;
import com.heying.mybatis.entity.Student;
import com.heying.mybatis.mapper.CourseMapper;
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
    public static void main(String[] args) throws IOException, InterruptedException {
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
//        final List<Student> students = studentMapper.selectAllStudentAndTeacher();
//        System.out.println(students);
//        students.forEach(student1 -> System.out.println(student1.getTeacher()));
//        final List<Teacher> teacherList =  teacherMapper.selectAllTeacherAndStudent();
//        System.out.println(teacherList);
//        teacherList.forEach(teacher -> System.out.println(teacher.getStudents()));
//        Student condition = new Student();
//        condition.setName("s");
//        condition.setCountry(1);
//        final Teacher teacher = new Teacher();
//        teacher.setName("t1");
//        condition.setTeacher(teacher);
//        final Page<Student> page = PageHelper.startPage(1, 3, "sid desc");
//        studentMapper.selectSomeStudentAndTeacher(condition);
//        final long total = page.getTotal();
//        System.out.println(page.getResult());
//        System.out.println(total);

//        final Page<Teacher> page = PageHelper.startPage(1, 10, "tid desc");
//        teacherMapper.selectSomeTeacherAndStudent("t", null);
//        System.out.println(page.getResult());
//        final Student student1 = new Student();
//        student1.setId(781);
//        student1.setName("999");
//        student1.setBirthday(new Date());
//        studentMapper.updateSomeStudentCols(student1);

        //删除多个
//        Integer[] ids = {779,780,781};
//        studentMapper.deleteSome(ids);

//        studentMapper.selectById(1);
//        Thread.sleep(2000);

//        final List<Student> students = studentMapper.selectSomeStudentAndTeacherAndScoreAndCourse(condition);
////        System.out.println(students);
//        System.out.println("=========================================");
//        students.forEach(student1 -> {
//            System.out.println(student1);
//            System.out.println(student1.getTeacher());
//            student1.getScores().forEach(score -> System.out.println(score+"["+score.getCourse()+"]"));
//            System.out.println("----------------------------------------------------------------------");
//        });

        final CourseMapper courseMapper = session.getMapper(CourseMapper.class);
        final Course condition = new Course();
//        condition.setCno("111");
        condition.setCname("学");
        final List<Course> courses = courseMapper.selectCourseAndStudentAndScoreAndTeacher(condition);
        System.out.println("=======================================");
        courses.forEach(course -> {
                    System.out.println(course);
                    course.getStudents().forEach(student1 -> {
                        System.out.println(student1);
                        System.out.println(student1.getTeacher());
                        System.out.println(course.getCname() + "=" + student1.getScore().getScore());
                    } );
            System.out.println("-------------------------");
                });
        session.commit();
//        studentMapper.selectById(1);
        session.close();

    }
}