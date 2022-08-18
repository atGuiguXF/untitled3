package com.heying.web.shopcart.service;

import com.heying.web.shopcart.dao.UserDao;

public class UserService {
    private UserDao userDao = new UserDao();

    public boolean checkLogin(String username,String password) throws Exception {
        return userDao.selectByUsernameAndPassword(username,password) != null;
    }

    public boolean checkUsername(String username) throws Exception {
        return userDao.selectByUsername(username) != null;
    }
}
