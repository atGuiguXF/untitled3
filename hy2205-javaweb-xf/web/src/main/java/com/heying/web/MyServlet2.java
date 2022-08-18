package com.heying.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyServlet2", value = "/MyServlet2")
public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //重定向跳转  Redirect
        request.setAttribute("info","success");
//        response.sendRedirect("aaa.jsp");

            //请求转发 Forward跳转
        request.getRequestDispatcher("aaa.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
