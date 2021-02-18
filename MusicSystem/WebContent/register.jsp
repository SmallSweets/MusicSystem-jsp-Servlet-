<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">
	用户名：<input name="Name" /><br>
	密&nbsp;&nbsp;&nbsp;码：<input name="Password" type="password" /><br>
	性&nbsp;&nbsp;&nbsp;别：<input name="Sex" /><br>
	年&nbsp;&nbsp;&nbsp;龄：<input name="Age" /><br>
	住&nbsp;&nbsp;&nbsp;址：<input name="Address" /><br>
	电&nbsp;&nbsp;&nbsp;话：<input name="Phone" /><br>
	<input value="注册" type="submit" />
	<input type="reset" />
</form>
</body>
</html>