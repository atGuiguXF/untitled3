<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<% String path = request.getContextPath();
    pageContext.setAttribute("p", path);
%>
<body>
<form action="${p}/user/addone" method="post">
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