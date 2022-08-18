<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.heying.web.ancient.User" %>
<%@ page import="com.heying.web.ancient.Database" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: mimi_
  Date: 2022/8/10
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Integer id = Integer.valueOf(request.getParameter("id"));
    final User user = Database.userMap.get(id);
%>

<form action="AddUserServlet" method="post">
    ID:<input type="text" name="id" value="<%=user.getId()%>"><br/>
    用户名:<input type="text" name="username" value="<%=user.getUsername()%>"><br/>
    密码:<input type="text" name="password" value="<%=user.getPassword()%>"><br/>
    性别:<input type="radio" name="sex" value="男"
    <%
    if(user.getSex().equals("男")){%>
              checked <%
    }%>
>男
    <input type="radio" name="sex" value="女"
        <%
    if(user.getSex().equals("女")){%>
           checked <%
    }%>
    >女<br/>
    年龄:<input type="number" name="age" min="0" max="120" value="<%=user.getAge()%>"><br/>
    爱好:<input type="checkbox" name="hobby" value="唱歌"
    <%
    if(Arrays.toString(user.getHobbies()).contains("唱歌")){%>
              checked <%
    }%>
>唱歌
    <input type="checkbox" name="hobby" value="跳舞"
        <%
    if(Arrays.toString(user.getHobbies()).contains("跳舞")){%>
           checked <%
    }%>
    >跳舞
    <input type="checkbox" name="hobby" value="徒步"
        <%
    if(Arrays.toString(user.getHobbies()).contains("徒步")){%>
           checked <%
    }%>
    >徒步<br/>
    <button>提交</button>
</form>
</body>
</html>
