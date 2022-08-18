package com.heying.web.ancient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/ancient/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        final Integer id = Integer.valueOf(request.getParameter("id"));
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String sex = request.getParameter("sex");
        final Integer age = Integer.valueOf(request.getParameter("age"));
        final String[] hobbies = request.getParameterValues("hobby");
        final User user = new User(id, username, password, sex, age, hobbies);
        Database.userMap.put(id, user);
        System.out.println(Database.userMap);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("添加成功");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
