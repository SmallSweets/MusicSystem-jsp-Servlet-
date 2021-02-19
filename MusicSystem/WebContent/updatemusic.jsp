<%@page import="java.sql.ResultSet"%>
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
<%
ResultSet rst = (ResultSet)session.getAttribute("result");
if(rst.next()){
%>
	<center>
		<form action="UpdateMusicServlet" method="get">
			歌&nbsp;&nbsp;曲&nbsp;&nbsp;ID：<input name="Id" value=<%=rst.getString("Id") %> readonly="readonly" /><br>
			歌曲名称：<input name="Name" value=<%=rst.getString("Name") %> /><br>
			歌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手：<input name="Singer" value=<%=rst.getString("Singer") %> /><br>
			添加时间：<input name="Time" value=<%=rst.getString("Time") %> /><br>
			播放地址：<input name="Url" value=<%=rst.getString("Url") %> /><br>
			<br>
			<input type="submit" value="更新" />
			<input type="reset" />
		</form>
	</center>
<%
}
%>
</body>
</html>