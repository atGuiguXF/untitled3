<%--
  Created by IntelliJ IDEA.
  User: 徐峰1999
  Date: 2022/8/25
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function premod(){
            var id = document.getElementById("id").value;
            location.href = "PreModUserMVCServlet?id="+id;
        }
    </script>
    <% String path = request.getContextPath();
        pageContext.setAttribute("p", path);
    %>
</head>
<body>
<a href="${p}/user/toadd">添加一个用户</a><br>
请输入用户ID:<input type="text" id="id"> <a href="#" onclick="premod()">修改一个用户</a><br>
<a href="QueryAllUserMVCServlet">查询所有用户</a><br>
请输入查询条件:
<form action="QuerySomeUserMVCServlet" method="post">
    用户名:<input type="text" name="username"><br/>
    性别:<select name="sex">
    <option value="">请选择</option>
    <option value="男">男</option>
    <option value="女">女</option>
</select><br>
    <button>查询</button>
</form>
</body>
</html>
