package com.heying.web.mvc;

import com.heying.web.ancient.Database;
import com.heying.web.ancient.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PreModUserMVCServlet", value = "/mvc/PreModUserMVCServlet")
public class PreModUserMVCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        final User user = Database.userMap.get(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("moduser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
