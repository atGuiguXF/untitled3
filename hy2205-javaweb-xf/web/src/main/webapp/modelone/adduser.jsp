<%@ page import="com.heying.web.ancient.User" %>
<%@ page import="com.heying.web.ancient.Database" %><%--
  Created by IntelliJ IDEA.
  User: mimi_
  Date: 2022/8/10
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    final String flag = request.getParameter("flag");
    if(!flag.equals("0")) {

        final Integer id = Integer.valueOf(request.getParameter("id"));
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String sex = request.getParameter("sex");
        final Integer age = Integer.valueOf(request.getParameter("age"));
        final String[] hobbies = request.getParameterValues("hobby");
        final User user = new User(id, username, password, sex, age, hobbies);
        Database.userMap.put(id, user);
        response.getWriter().write("添加成功");
    }
%>

<form action="adduser.jsp" method="post">
    <input type="hidden" name="flag" value="1">
    ID:<input type="text" name="id"><br/>
    用户名:<input type="text" name="username"><br/>
    密码:<input type="text" name="password"><br/>
    性别:<input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女<br/>
    年龄:<input type="number" name="age" min="0" max="120"><br/>
    爱好:<input type="checkbox" name="hobby" value="唱歌">唱歌
    <input type="checkbox" name="hobby" value="跳舞">跳舞
    <input type="checkbox" name="hobby" value="徒步">徒步<br/>
    <button>提交</button>
</form>
</body>
</html>
