<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: mimi_
  Date: 2022/8/10
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    ID:<input type="text" name="id" value="${user.id}"><br/>
    用户名:<input type="text" name="username" value="${user.username}"><br/>
    密码:<input type="text" name="password" value="${user.password}"><br/>
    性别:<input type="radio" name="sex" value="男"
      <c:if test="${user.sex=='男'}">checked</c:if>
>男
    <input type="radio" name="sex" value="女"
           <c:if test="${user.sex=='女'}">checked</c:if>
    >女<br/>
    年龄:<input type="number" name="age" min="0" max="120" value="${user.age}"><br/>
    爱好:<input type="checkbox" name="hobby" value="唱歌"
              <c:if test="${Arrays.toString(user.hobbies).indexOf('唱歌')!=-1}">checked</c:if>
>唱歌
    <input type="checkbox" name="hobby" value="跳舞"
           <c:if test="${Arrays.toString(user.hobbies).indexOf('跳舞')!=-1}">checked</c:if>

    >跳舞
    <input type="checkbox" name="hobby" value="徒步"
           <c:if test="${Arrays.toString(user.hobbies).indexOf('徒步')!=-1}">checked</c:if>
    >徒步<br/>
    <button>提交</button>
</form>
</body>
</html>
