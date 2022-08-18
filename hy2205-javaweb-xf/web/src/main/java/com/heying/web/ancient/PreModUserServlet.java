package com.heying.web.ancient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PreModUserServlet", value = "/ancient/PreModUserServlet")
public class PreModUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer id = Integer.valueOf(request.getParameter("id"));
        final User user = Database.userMap.get(id);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String maleChecked = user.getSex().equals("男")?"checked":"";
        String femaleChecked = user.getSex().equals("女")?"checked":"";
        String[] hobbies = user.getHobbies();
        String singChecked = "";
        String danceChecked = "";
        String runChecked = "";

        for (String hobby : hobbies) {
            if (hobby.equals("唱歌")){
                singChecked = "checked";
            }
            if (hobby.equals("跳舞")){
                danceChecked = "checked";
            }
            if (hobby.equals("徒步")){
                runChecked = "checked";
            }
        }
        out.println("<form action=\"AddUserServlet\" method=\"post\">\n" +
                "    ID:<input type=\"text\" name=\"id\" value=\""+user.getId()+"\"><br/>\n" +
                "    用户名：<input type=\"text\" name=\"username\" value=\""+user.getUsername()+"\"><br/>\n" +
                "    密码：<input type=\"text\" name=\"password\" value=\""+user.getPassword()+"\"><br/>\n" +
                "    性别：<input type=\"radio\" name=\"sex\" value=\"男\" "+maleChecked+">男\n" +
                "    <input type=\"radio\" name=\"sex\" value=\"女\" "+femaleChecked+">女<br/>\n" +
                "    年龄:<input type=\"number\" name=\"age\" min=\"0\" max=\"100\" value=\""+user.getAge()+"\"><br/>\n" +
                "    爱好:<input type=\"checkbox\" name=\"hobby\" value=\"唱歌\" "+singChecked+">唱歌\n" +
                "    <input type=\"checkbox\" name=\"hobby\" value=\"跳舞\" "+danceChecked+">跳舞\n" +
                "    <input type=\"checkbox\" name=\"hobby\" value=\"徒步\" "+runChecked+">徒步<br/>\n" +
                "    <button>提交</button>\n" +
                "</form>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
