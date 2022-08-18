package com.heying.web.shopcart.controller;

import com.heying.web.shopcart.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ShopCartServlet", value = "/shopcart/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Integer id = Integer.valueOf(request.getParameter("id"));
        final Double price = Double.valueOf(request.getParameter("price"));
        final String title = request.getParameter("title");
        final String author = request.getParameter("author");
        final String publisher = request.getParameter("publisher");
        final String img = request.getParameter("img");
        final Book book = new Book(id, title, price, publisher, img, author);
        System.out.println(book);
        final HttpSession session = request.getSession();
        Map<Book, Integer> shopcart = (Map<Book, Integer>) session.getAttribute("shopcart");
        if (null == shopcart) {
            shopcart = new HashMap<>();
            session.setAttribute("shopcart", shopcart);
        }
        shopcart.put(book, shopcart.get(book) == null ? 1 : shopcart.get(book) + 1);
        request.getRequestDispatcher("shopcart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
