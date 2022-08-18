package com.heying.web.mvc;

import com.heying.web.ancient.Database;
import com.heying.web.ancient.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "QuerySomeUserMVCServlet", value = "/mvc/QuerySomeUserMVCServlet")
public class QuerySomeUserMVCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
        request.setAttribute("users", users);
        request.getRequestDispatcher("userlist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
