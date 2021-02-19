<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	margin-top:150px;
}
</style>
</head>
<body>
<h1>登录失败，请重新登录</h1>
<br>
<center>
	<form action="Login" method="post">
		用户名：<input name="name" type="text" /><br>
		密&nbsp;&nbsp;&nbsp;码：<input name="password" type="password" /><br>
		<br>
		<input type="submit" value="登录" />
		<a href="register.jsp"><input type="button" value="注册" /></a>
	</form>
</center>
</body>
</html>