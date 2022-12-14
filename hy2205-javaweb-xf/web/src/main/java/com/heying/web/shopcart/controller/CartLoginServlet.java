package com.heying.web.shopcart.controller;

import com.heying.web.shopcart.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartLoginServlet", value = "/shopcart/CartLoginServlet")
public class CartLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final UserService userService = new UserService();
        try {
            if(userService.checkLogin(request.getParameter("username"),
                    request.getParameter("password"))){
                final HttpSession session = request.getSession();
                session.setAttribute("username", request.getParameter("username"));
                response.sendRedirect("QueryBooksServlet");
            }else{
                request.setAttribute("info", "登录失败,用户名或者密码不正确");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("info", "登录失败,系统正忙，请稍后再试");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
