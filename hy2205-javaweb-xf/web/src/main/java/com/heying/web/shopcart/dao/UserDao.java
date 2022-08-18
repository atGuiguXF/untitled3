package com.heying.web.shopcart.dao;

import com.heying.web.shopcart.entity.UserInfo;
import com.heying.web.shopcart.util.JDBCUtil;

public class UserDao {

    JDBCUtil jdbcUtil = new JDBCUtil();

    public UserInfo selectByUsernameAndPassword(String username,String password) throws Exception {
        return  jdbcUtil.queryOne("select * from userinfo where username=? and password = ?"
                , UserInfo.class, username,password);
    }

    public UserInfo selectByUsername(String username) throws Exception {
        return  jdbcUtil.queryOne("select * from userinfo where username=?"
                , UserInfo.class, username);
    }
}
