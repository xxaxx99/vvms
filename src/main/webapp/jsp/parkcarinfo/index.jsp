<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Socrates
  Date: 2023/4/1
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>停车场车位信息</title>
</head>
<style>
    table, th, td {
        border: solid 1px #efefef;
    }
    table {
        width: 100%;
        margin: auto;
        border-collapse: collapse;
        text-align: center;
        border-radius: 6px;
    }
    td,th{
        padding: 10px;
    }
    a {
        text-decoration-line: none;
        color: green;
    }
    a:hover {
        color: brown;
        text-decoration-line: underline;
    }
    tr:first-child {
        background-color: #efefef;
        border-radius: 4px 4px 0 0;
        border-bottom: solid 1px #ddd;
    }
    table caption {
        font-size: 1.5rem;
        font-weight: bolder;
        margin-bottom: 20px;
    }
    p {
        text-align: center;
    }
    /*首页样式*/
    p a:first-child {
        width: 56px;
    }
    p a:last-child {
        width: 56px;
    }
    p a {
        display: inline-block;
        width: 28px;
        height: 24px;
        border: 1px solid green;
        margin-left:2px;
        line-height: 24px;
    }
    /*当前页样式*/
    .active {
        background-color: green;
        color: white;
    }
    .more {
        border: none;
    }
</style>
<body>
<h3>当前位置：停车场车位信息</h3>

<a href="${pageContext.request.contextPath}/logout" style="text-align: right">退出</a>
<div>
    搜索：<input type="text" name="keyword" value="${keyword}" id="keyword"> <button onclick="search()">查询</button>
</div>
<table class="table table-hover text-center">
    <tbody>
        <tr>
            <th>停车场号码</th>
            <th>所有车位数量</th>
            <th>被占用车位数量</th>
        </tr>
    <c:forEach items="${parkcarinfoList}" var="parkcarinfo">
        <tr>
            <td>${parkcarinfo.parkNo}</td>
            <td>${parkcarinfo.allspace}个</td>
            <td>${parkcarinfo.occupied}个</td>
            <td>
                <div>
                    <a href="${pageContext.request.contextPath}/jsp/parkcarinfo/modify.jsp" style="text-align: right">添加</a>
                    <a href="${pageContext.request.contextPath}/parkcarinfo?method=get&parkNo=${parkcarinfo.parkNo}" >修改</a>
                    <a href="${pageContext.request.contextPath}/parkcarinfo?method=delete&parkNo=${parkcarinfo.parkNo}" >删除</a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    function search(){
        var v = window.document.getElementById("keyword").value;
        window.location.href='${pageContext.request.contextPath}/parkcarinfo?method=query&keyword='+v ;
    }
</script>
</body>
</html>
