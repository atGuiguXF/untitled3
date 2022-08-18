package com.heying.web.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heying.web.ancient.Database;
import com.heying.web.ancient.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PreModUserAjaxServlet", value = "/PreModUserAjaxServlet")
public class PreModUserAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        final User user = Database.userMap.get(id);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().print(new ObjectMapper().writeValueAsString(user));
    }
}
