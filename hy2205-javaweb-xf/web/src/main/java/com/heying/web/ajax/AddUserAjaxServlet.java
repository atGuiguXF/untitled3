package com.heying.web.ajax;

import com.heying.web.ancient.Database;
import com.heying.web.ancient.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserAjaxServlet", value = "/AddUserAjaxServlet")
public class AddUserAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.getWriter().print("success");
    }
}
