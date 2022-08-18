package com.heying.web.ancient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;

@WebServlet(name = "QueryAllUserServlet", value = "/ancient/QueryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Collection<User> values = Database.userMap.values();
        response.setContentType("text/html;charset=utf-8");
        final PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        table{\n" +
                "            width: 500px;\n" +
                "\t\t\theight: 250px;\n" +
                "\t\t\tborder-collapse: collapse;\n" +
                "\t\t\tborder:1px solid\n" +
                "        }\n" +
                "\t\tth,td{\n" +
                "\t\t\tborder:1px solid\n" +
                "\t\t}\n" +
                "       \n" +
                "    </style>\n" +
                "</head>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>用户名</th><th>密码</th><th>性别</th><th>年龄</th><th>爱好</th></tr>");
        values.forEach(user -> {
            out.println("<tr><td>");
            out.println(user.getId());
            out.println("</td>");
            out.println("<td>");
            out.println(user.getUsername());
            out.println("</td>");
            out.println("<td>");
            out.println(user.getPassword());
            out.println("</td>");
            out.println("<td>");
            out.println(user.getSex());
            out.println("</td>");
            out.println("<td>");
            out.println(user.getAge());
            out.println("</td>");
            out.println("<td>");
            out.println(Arrays.toString(user.getHobbies()));
            out.println("</td>");
            out.println("</tr>");
        });
        out.println("</table>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
