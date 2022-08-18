<%--
  Created by IntelliJ IDEA.
  User: 徐峰1999
  Date: 2022/8/11
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String p = request.getContextPath();
    pageContext.setAttribute("p", p);%>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            float: left;
        }
        input{
            border-style: none;
        }
    </style>
</head>
<body>
你好,${username}
<c:forEach items="${books}" var="b">
    <form action="${p}/shopcart/ShopCartServlet">
        <div>
            <img src="${p}/${b.img}"><br/>
            <input type="hidden" name="id" value="${b.id}">
            <input type="hidden" name="img" value="${b.img}">
            书名:<input type="text" name="title" value="${b.title}" readonly><br/>
            价格:<input type="text" name="price" value="${b.price}" readonly><br/>
            作者:<input type="text" name="author" value="${b.author}" readonly><br/>
            出版社:<input type="text" name="publisher" value="${b.publisher}" readonly><br/>
            <button>加入购物车</button>
    </div>
    </form>
</c:forEach>
</body>
</html>
