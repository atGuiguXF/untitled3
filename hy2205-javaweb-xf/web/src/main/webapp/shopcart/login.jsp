<%--
  Created by IntelliJ IDEA.
  User: 徐峰1999
  Date: 2022/8/11
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<% String p = request.getContextPath();
    pageContext.setAttribute("p", p);
%>
<body>
<form action="${p}/shopcart/CartLoginServlet" method="post">
    用户名:<input type="text" name="username"><br/>
    密码:<input type="password" name="password"><br>
    <button>登录</button>
</form>
<p>${info}</p>
</body>
</html>
