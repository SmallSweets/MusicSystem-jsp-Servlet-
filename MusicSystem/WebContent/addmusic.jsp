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
<center>
	<form action="AddMusicServlet" method="get">
		歌曲名称：<input name="Name" /><br>
		歌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手：<input name="Singer" /><br>
		添加时间：<input name="Time" /><br>
		播放地址：<input name="Url" /><br>
		<br>
		<input type="submit" value="添加" />
		<input type="reset" />
	</form>
</center>
</body>
</html>