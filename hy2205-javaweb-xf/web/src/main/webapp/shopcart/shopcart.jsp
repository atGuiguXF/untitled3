<%--
  Created by IntelliJ IDEA.
  User: mimi_
  Date: 2022/8/12
  Time: 9:08
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
        th,td{
            border: 1px solid;
        }
        table{
            border-collapse: collapse;
        }
    </style>
    <script src="../jquery-3.5.1.min.js"></script>
    <script>
        $(function () {
            var sumPrice = 0
            $("table tr").each(function(i,tr){
                if(i === 0)
                    return;
                $(this).find("td").eq(6).html(parseFloat( $(this).find("td").eq(4).html()) *
                    parseFloat( $(this).find("td").eq(5).find(":text").val()))
                sumPrice += parseFloat($(this).find("td").eq(6).html())
            })

            $("#sumPrice").html(sumPrice)

            $("button:contains('+')").click(function (){
                $(this).next(":text").val(parseInt($(this).next(":text").val())+1);
                $(this).parent().next("td").html(
                    parseInt($(this).next(":text").val()) *parseFloat($(this).parent().prev("td").html()))

                $("#sumPrice").html(sumPrice +=  parseFloat($(this).parent().prev("td").html()))

            })
            $("button:contains('-')").click(function (){
                if($(this).prev(":text").val() === "1"){
                    alert("数量不可以为0")
                    return
                }
                $(this).prev(":text").val(parseInt($(this).prev(":text").val())-1);
                $(this).parent().next("td").html(
                    parseInt($(this).prev(":text").val()) *parseFloat($(this).parent().prev("td").html()))

                $("#sumPrice").html(sumPrice -=  parseFloat($(this).parent().prev("td").html()))

            })

            $("button:contains('移除')").click(function (){
$(this).parent().parent().hide('slow')
                $("#sumPrice").html(sumPrice -= parseInt($(this).parent().prev().prev().find(":text").val())
                * parseFloat($(this).parent().prev().prev().prev().html()).toFixed(2))
            })
        })
    </script>
</head>
<body>
<table>
    <tr><th>封面</th><th>书名</th><th>作者</th><th>出版社</th><th>单价</th>
        <th>数量</th><th>总价</th><th>移除购物车</th></tr>
    <c:forEach items="${shopcart}" var="entry">
        <tr>
            <td><img src="${p}/${entry.key.img}"></td>
            <td>${entry.key.title}</td>
            <td>${entry.key.author}</td>
            <td>${entry.key.publisher}</td>
            <td>${entry.key.price}</td>
            <td><button>+</button>
                <input type="text" value="${entry.value}" size="2">
                <button>-</button></td>
            <td>0</td>
            <td ><button style="width: 100px">移除</button></td>
        </tr>
    </c:forEach>
</table>
总价:<span id="sumPrice" style="  color: red;font-size: 20px"></span>
</body>
</html>
