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

public class Test {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(inputStream);
        //一级缓存
        SqlSession session = sqlSessionFactory.openSession();

        final Student student = new Student(666, "666", "666", new Date(), 1, "sport",1,null);
        final StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.insertOne(student);

        session.commit();
        session.close();

    }
}
