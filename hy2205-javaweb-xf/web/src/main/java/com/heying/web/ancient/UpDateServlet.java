package com.heying.web.ancient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpDateServlet", value = "/UpDateServlet")
public class UpDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        final Integer id = Integer.valueOf(request.getParameter("id"));
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String sex = request.getParameter("sex");
        final Integer age = Integer.valueOf(request.getParameter("age"));
        final String[] hobby = request.getParameterValues("hobby");
        final User user = Database.userMap.get(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setAge(age);
        user.setHobbies(hobby);
        System.out.println();
        System.out.println(Database.userMap);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("修改成功");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
