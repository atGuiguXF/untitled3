package com.heying.dao;

import com.heying.entity.Book;
import com.heying.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class BookDao {

    JDBCUtil jdbcUtil = new JDBCUtil();

    public List<Book> query(Book condition) throws Exception {
        String select = "select * from tbl_books where 1=1";
        List<Object> list = new ArrayList<>();
        if (condition.getIsbn() != null) {
            select += " and isbn = ?";
            list.add(condition.getIsbn());
        }
        if (condition.getTitle() != null) {
            select += " and title like ?";
            list.add("%" + condition.getTitle() + "%");
        }
        if (condition.getCategory() != null) {
            select += " and category like ?";
            list.add("%" + condition.getCategory() + "%");
        }
        System.out.println(select);
        System.out.println(list);
        return jdbcUtil.queryMany(select, Book.class, list.toArray());
    }

    public void insert(Book book) throws Exception {
        jdbcUtil.update("insert into tbl_books values(?,?,?,?,?,?,?)",
                book.getIsbn(), book.getTitle(), book.getPubdate(), book.getPubid(),
                book.getCost(), book.getRetail(), book.getCategory());
    }
    //调用jdabc修改功能
    public void update(Book book) throws Exception {
        if (book.getCost() != null && book.getRetail() != null) {
            jdbcUtil.update("update tbl_books set cost=?," +
                            " retail=?" +
                            " where isbn = ?",
                    book.getCost(), book.getRetail(), book.getIsbn());
        }
        if (book.getTitle() != null) {
            jdbcUtil.update("update tbl_books set title=? where isbn = ? ",
                    book.getTitle(), book.getIsbn());
        }
        if (book.getPubid() != null) {
            jdbcUtil.update("update tbl_books set pubid = ? where isbn = ?",
                    book.getPubid(), book.getIsbn());
        }
        if (book.getPubdate() != null) {
            jdbcUtil.update("update tbl_books set pubdate = ? where isbn = ?",
                    book.getPubdate(), book.getIsbn());
        }
        if (book.getCategory() != null) {
            jdbcUtil.update("update tbl_books set category = ? where isbn = ?",
                    book.getCategory(), book.getIsbn());
        }
    }

    //调用删除
    public void delete(Book book) throws Exception {
        jdbcUtil.update("delete from tbl_books  where isbn = ?", book.getIsbn());
    }
}
