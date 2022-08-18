<%@ page import="com.heying.web.ancient.User" %>
<%@ page import="com.heying.web.ancient.Database" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 徐峰1999
  Date: 2022/8/10
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table {
        height: 200px;
        width: 400px;
        border: 1px solid;
        border-collapse: collapse;
    }
    td,th{
        border: 1px solid;
    }
</style>
<body>
<% final Collection<User> user = Database.userMap.values();
    for (User users : user) {
   %>
<table>
    <tr>
        <td>用户名：</td>
        <td>密码</td>
        <td>性别</td>
        <td>年龄</td>
        <td>爱好</td>
    </tr>

    <tr><th><%=users.getUsername()%></th>
    <th><%=users.getPassword()%></th>
    <th><%=users.getSex()%></th>
    <th><%=users.getAge()%></th>
        <th><%=Arrays.toString(users.getHobbies())%></th></tr>
    <%}%>
</table>
</body>
</html>
