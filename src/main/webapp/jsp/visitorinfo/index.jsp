<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>车主信息</title>
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
</style>
<body>
<h3>当前位置：车主信息</h3>
<a href="${pageContext.request.contextPath}/logout" style="text-align: right">退出</a>
<table class="table table-hover text-center">
	<tbody><tr>
		<th width="5%">编号</th>
		<th width="15%">电话</th>
		<th width="35%">车牌号</th>
		<th width="20%">操作</th>
	</tr>
	<c:forEach items="${visitorInfoList}" var="visitorInfo">
		<tr>
			<td>${visitorInfo.id}</td>
			<td>${visitorInfo.visPhone}</td>
			<td>${visitorInfo.carNo}</td>
			<td>
				<div>
					<a href="${pageContext.request.contextPath}/jsp/visitorinfo/modify.jsp" style="text-align: right">添加</a>
					<a href="${pageContext.request.contextPath}/visitorinfo?message=update&id=${visitorInfo.id}"> 修改</a>
					<a href="${pageContext.request.contextPath}/visitorinfo?message=delete&id=${visitorInfo.id}"> 删除</a>
				</div>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
