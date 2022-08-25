package com.heying.spring.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/choose?userSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT%2B8";
            conn = DriverManager.getConnection(url, "root", "abcabc");
            conn.setAutoCommit(false);
            String sql = "insert into userinfo values(?,?)";
            final PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "www");
            pstmt.setString(2, "111");
            pstmt.executeUpdate();
            pstmt.setString(1, "www");
            pstmt.setString(2, "222");
            pstmt.executeUpdate();
            conn.commit();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
