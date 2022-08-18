package com.heying.service;

import com.heying.dao.BookDao;
import com.heying.entity.Book;
import com.heying.net.NetMsg;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();

    public NetMsg<List<Book>> query(NetMsg<Book> request) throws Exception {
        final List<Book> list = bookDao.query(request.getData());
        return new NetMsg<>(list, "SUCCESS");
    }

    public NetMsg<String> add(NetMsg<Book> request) throws Exception {
        bookDao.insert(request.getData());
        return new NetMsg<>("添加成功", "SUCCESS");
    }

    public NetMsg<String> update(NetMsg<Book> request) throws Exception {
        bookDao.update(request.getData());
        return new NetMsg<>("修改成功", "SUCCESS");
    }
    public NetMsg<String> delete(NetMsg<Book>request) throws Exception {
        bookDao.delete(request.getData());
        return new NetMsg<>("删除成功","SUCCESS");
    }
}
