package com.heying.mybatis.mapper;

import com.heying.mybatis.entity.Course;

import java.util.List;

public interface CourseMapper {
    //根据课程查询相关联的学生以及分数以及老师
    List<Course> selectCourseAndStudentAndScoreAndTeacher(Course condition);
}
