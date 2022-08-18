package com.heying.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heying.web.shopcart.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "AjaxCheckServlet", value = "/AjaxCheckServlet")
public class AjaxCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        response.setContentType("text/json;charset=utf-8");
        final HashMap<Object, Object> map = new HashMap<>();
        try {
            final boolean b = new UserService().checkUsername(username);
            if(b){
                map.put("info", "error");
            }
            else{
                map.put("info", "ok");

            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("info", "system_error");
        }
        response.getWriter().print(new ObjectMapper().writeValueAsString(map));

    }
}
