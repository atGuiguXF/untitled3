package com.heying.web.shopcart.controller;

import com.heying.web.shopcart.entity.Book;
import com.heying.web.shopcart.service.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryBooksServlet", value = "/shopcart/QueryBooksServlet")
public class QueryBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final BookService bookService = new BookService();
        try {
            final List<Book> books = bookService.queryAll();
            request.setAttribute("books", books);
            request.getRequestDispatcher("booklist.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("info", "系统正忙，请稍后再试");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
