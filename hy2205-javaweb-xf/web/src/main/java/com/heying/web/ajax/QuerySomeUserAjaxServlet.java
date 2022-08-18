package com.heying.web.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heying.web.ancient.Database;
import com.heying.web.ancient.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "QuerySomeUserAjaxServlet", value = "/QuerySomeUserAjaxServlet")
public class QuerySomeUserAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String sex = request.getParameter("sex");
        final List<User> users = Database.userMap.values().stream().filter(user -> {
            boolean flag = true;
            if(username.length() > 0) {
                flag = user.getUsername().matches(".*" + username + ".*");
            }
            if(sex.length() > 0) {
                flag = flag && user.getSex().equals(sex);
            }
            return flag;
        }).collect(Collectors.toList());
        System.out.println("users="+users);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().print(new ObjectMapper().writeValueAsString(users));
    }
}
