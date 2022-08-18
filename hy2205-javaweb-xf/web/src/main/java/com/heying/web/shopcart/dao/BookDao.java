package com.heying.web.shopcart.dao;

import com.heying.web.shopcart.entity.Book;
import com.heying.web.shopcart.util.JDBCUtil;

import java.util.List;

public class BookDao {
       JDBCUtil jdbcUtil = new JDBCUtil();
    public List<Book> queryAll() throws Exception {
        return jdbcUtil.queryMany("select * from book",Book.class);
    }
}
