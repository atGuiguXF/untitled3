<%@ page import="com.heying.springmvc.entity.User" %>
<%@ page import="com.heying.springmvc.Database" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width: 500px;
            height: 250px;
            border-collapse: collapse;
            border:1px solid
        }
        th,td{
            border:1px solid
        }
        .odd{
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
<table>
    <tr><th>ID</th><th>用户名</th><th>密码</th><th>性别</th><th>年龄</th><th>爱好</th></tr>
    <c:forEach items="${users}" var="u" varStatus="s">
        <tr <c:if test="${s.index % 2 == 1}">class="odd"</c:if>>
        <td>${u.id}</td>
        <td>${u.username}</td>
        <td>${u.password}</td>
        <td>${u.sex}</td>
        <td>${u.age}</td>
        <td>${Arrays.toString(u.hobbies)}</td>
    </tr>
    </c:forEach>
</table>
</table>
</body>
</html>
