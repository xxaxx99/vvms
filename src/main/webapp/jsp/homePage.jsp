<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>文档管理</title>
</head>
<body>
<h3>当前位置：功能列表</h3>
<a href="${pageContext.request.contextPath}/order?action=query" style="text-align: right" >订单管理</a>
<a href="${pageContext.request.contextPath}/visitorinfo?message=query" style="text-align: right">车主信息</a>
<a href="${pageContext.request.contextPath}/parkcarinfo?method=query" style="text-align: right">停车场车位信息</a>
<a href="${pageContext.request.contextPath}/parkingCar?message=query" style="text-align: right">在停车辆信息</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/logout" style="text-align: right">退出</a>
</body>
</html>
