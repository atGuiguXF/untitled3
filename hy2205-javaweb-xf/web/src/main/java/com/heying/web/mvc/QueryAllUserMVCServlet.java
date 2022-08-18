package com.heying.web.mvc;

import com.heying.web.ancient.Database;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QueryAllUserMVCServlet", value = "/mvc/QueryAllUserMVCServlet")
public class QueryAllUserMVCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("users", Database.userMap.values());
            request.getRequestDispatcher("userlist.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
