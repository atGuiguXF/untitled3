package com.heying.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 默认的情况下
 * 第一次访问才会实例化和初始化Servlet
 * 以后每次访问都不会再实例化和初始化，说明Servlet是单例的
 * loadOnStartup>=0的时候，项目启动的时候会进行实例化和初始化
 *
 *
 */
@WebServlet(name = "MyServlet", value = "/MyServlet",loadOnStartup = 0)
public class MyServlet extends HttpServlet {

    private int count = 0;

    public MyServlet(){
        System.out.println("MyServlet实例化");
    }

    public void init(){
        System.out.println("MyServlet初始化");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.getWriter().println(++count);
        final Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            System.out.println(header+"="+request.getHeader(header));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
