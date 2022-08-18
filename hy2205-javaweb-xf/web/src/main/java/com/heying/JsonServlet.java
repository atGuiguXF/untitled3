package com.heying;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@WebServlet(name = "JsonServlet", value = "/JsonServlet")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final ObjectMapper objectMapper = new ObjectMapper();
        final HashMap<String, String> map = new HashMap<>();
        map.put("now", format.format(new Date()));
        response.getWriter().print(objectMapper.writeValueAsString(map));
//        response.getWriter().print("{\"now\":\""+format.format(new Date())+"\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
