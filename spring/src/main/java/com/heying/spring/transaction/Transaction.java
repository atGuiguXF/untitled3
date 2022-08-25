package com.heying.spring.transaction;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
@Aspect
public class Transaction {

    private ThreadLocal<Connection> threadLocal;

//    private ThreadLocal<Connection> threadLocal = ThreadLocal.withInitial(()->{
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/choose?userSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT%2B8";
//            return DriverManager.getConnection(url, "root", "123456");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    });

    public ThreadLocal<Connection> getThreadLocal() {
        return threadLocal;
    }

    @Autowired
    public void setThreadLocal(ThreadLocal<Connection> threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Pointcut("execution(* com.heying.spring.transaction.UserService.addTwoUsers(..))")
    public void trans() {
    }

    //开启事务
    @Before("trans()")
    public void startTransaction() {
        System.out.println(Thread.currentThread() + "-Transaction:" + threadLocal.get());
        try {
            threadLocal.get().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    @AfterReturning("trans()")
    public void commit() {
        try {
            threadLocal.get().commit();
            threadLocal.get().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            threadLocal.remove();//防止内存泄露
        }
    }

    @AfterThrowing("trans()")
    public void rollback() {
        System.out.println("rollback");
        try {
            threadLocal.get().rollback();
            threadLocal.get().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            threadLocal.remove();//防止内存泄露
        }

    }
}
