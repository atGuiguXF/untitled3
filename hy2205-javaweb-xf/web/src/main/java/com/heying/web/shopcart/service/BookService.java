package com.heying.web.shopcart.service;

import com.heying.web.shopcart.dao.BookDao;
import com.heying.web.shopcart.entity.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();

   public List<Book> queryAll() throws Exception {
       return  bookDao.queryAll();
   }
}
