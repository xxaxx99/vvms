<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
</html>
<body>
<h1 style="text-align: center">登录</h1>

<div style="text-align: center">

	<form method="post" id="form">
		用户名：<input type="text" name="username" id="username"> <br>
		密码：<input type="password" name="password" id="password"> <br>

		<input type="submit" id="btn">
	</form>

</div>
<script type="text/javascript">
    var btn =document.getElementById("btn");
    btn.onclick = function(){
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        var form = document.getElementById("form");


        if(username.value.length==0){
            alert("请输入用户名！");
            return;
        }
        if(password.value.length==0){
            alert("密码不能为空！");
            return;
        }
        if(username.value.length!=0&&password.value.length!=0){
			form.action="${pageContext.request.contextPath}/login"
			form.submit();
		}
    }
</script>
</body>
</html>
