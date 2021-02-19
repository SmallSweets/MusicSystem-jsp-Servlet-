<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="jquery-3.5.1.js"></script>
<style type="text/css">
body{
	margin-top:150px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="LoginServlet" method="post">
		用户名：<input name="name" type="text" /><br>
		密&nbsp;&nbsp;&nbsp;码：<input name="password" type="password" /><br>
		<br>
		<input type="submit" value="登录" />
		<a href="register.jsp"><input type="button" value="注册" /></a>
	</form>
</center>
</body>
</html>