package com.heying.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class UserService {
    @Autowired //自动装配
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addTwoUsers(UserInfo user1,UserInfo user2) throws SQLException {
        userDao.addTwoUsers(user1, user2);
    }
}