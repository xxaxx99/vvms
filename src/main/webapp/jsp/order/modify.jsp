<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
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
    tr td:last-child {
        text-align: left;
        margin-left: 20px;
    }
</style>
<body>
<h3>当前位置：订单管理</h3>
<a href="${pageContext.request.contextPath}/order/query" style="text-align: right">返回</a>
<a href="${pageContext.request.contextPath}/logout" style="text-align: right">退出</a>
<form action="${pageContext.request.contextPath}/order/${param.id == null ? 'create' : 'update'}" method="post">
    <input type="hidden" name="id" value="${order.id}">
    <table class="table table-hover text-center">
        <tbody>
        <tr>
            <td>电话</td>
            <td>
                <input type="text" name="phone" value="${order.phone}">
            </td>
        </tr>
        <tr>
            <td>费用</td>
            <td>
                <input type="text" name="money" value="${order.money}">元
            </td>
        </tr>
        <tr>
            <td>车牌号</td>
            <td>
                <input type="text" name="carNumber" value="${order.carNumber}">
            </td>
        </tr>
        <tr>
            <td>停车时长</td>
            <td>
                <input type="text" name="time" value="${order.time}">分钟
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="保存">
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
