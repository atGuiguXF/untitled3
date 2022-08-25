package com.heying.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class UserDao {

    //    @Value("#{transaction.threadLocal}")
    @Autowired
    private ThreadLocal<Connection> threadLocal;

    public void addTwoUsers(UserInfo user1,UserInfo user2) throws SQLException {

        String sql = "insert into userinfo values(?,?)";
        System.out.println(Thread.currentThread()+"-UserDao:"+threadLocal.get());
        final PreparedStatement pstmt = threadLocal.get().prepareStatement(sql);
        pstmt.setString(1, user1.getUsername());
        pstmt.setString(2, user1.getPassword());
        pstmt.executeUpdate();
        pstmt.setString(1, user2.getUsername());
        pstmt.setString(2, user2.getPassword());
        pstmt.executeUpdate();

    }
}

