package com.heying.util;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {

    private String driver;

    private String url;

    private String username;

    private String password;

    public JDBCUtil() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("db.properties"));
            this.driver = properties.getProperty("driver");
            this.url = properties.getProperty("url");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection conn() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    private JDBCType javaToSQL(Object arg) throws SQLException {
        if (null == arg) {
            return JDBCType.NULL;
        }
        final Class<?> type = arg.getClass();
        if (int.class.equals(type) || Integer.class.equals(type))
            return JDBCType.INTEGER;
        if (long.class.equals(type) || Long.class.equals(type))
            return JDBCType.BIGINT;
        if (double.class.equals(type) || Double.class.equals(type))
            return JDBCType.DOUBLE;
        if (float.class.equals(type) || Float.class.equals(type))
            return JDBCType.FLOAT;
        if (String.class.equals(type))
            return JDBCType.VARCHAR;
        if (Date.class.equals(type) || java.util.Date.class.equals(type))
            return JDBCType.DATE;
        throw new SQLException("暂不支持该类型");
    }

    public void update(String sql, Object... args) throws Exception {
        try (Connection conn = conn()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i], javaToSQL(args[i]));
            }
            pstmt.executeUpdate();
        }
    }

    public <T> T queryOne(String sql,Class<T> clazz,Object...args) throws Exception {
        try(Connection conn = conn()){
            final PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i+1, args[i],javaToSQL(args[i]));
            }
            final Field[] fields = clazz.getDeclaredFields();
            final Constructor<T> constructor = clazz.getConstructor();
            final ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                final T o = constructor.newInstance();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Class fieldType = field.getType();
                    final Object value;
                    if(java.util.Date.class.equals(fieldType)){
                       value = rs.getObject(fieldName, Date.class);
                    }
                    else{
                        value = rs.getObject(fieldName, fieldType);
                    }
                    String setterMethodName = "set"+fieldName.substring(0, 1).toUpperCase()+
                            fieldName.substring(1 );
                    Method setterMethod = clazz.getMethod(setterMethodName, fieldType);
                    setterMethod.invoke(o, value);
                }
                return o;
            }
            return null;
        }
    }

    public <T> List<T>  queryMany(String sql,Class<T> clazz,Object...args) throws Exception {
        try(Connection conn = conn()){
            final PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i+1, args[i],javaToSQL(args[i]));
            }
            final Field[] fields = clazz.getDeclaredFields();
            final Constructor<T> constructor = clazz.getConstructor();
            final ResultSet rs = pstmt.executeQuery();
            List<T> list = new ArrayList<>();
            while(rs.next()){
                final T o = constructor.newInstance();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Class fieldType = field.getType();
                    final Object value;
                    if(java.util.Date.class.equals(fieldType)){
                        value = rs.getObject(fieldName, Date.class);
                    }
                    else{
                        value = rs.getObject(fieldName, fieldType);
                    }
                    String setterMethodName = "set"+fieldName.substring(0, 1).toUpperCase()+
                            fieldName.substring(1 );
                    Method setterMethod = clazz.getMethod(setterMethodName, fieldType);
                    setterMethod.invoke(o, value);
                }
                list.add(o);
            }
            return list;
        }
    }

    public static void method(String... args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) throws Exception {

    }

}
