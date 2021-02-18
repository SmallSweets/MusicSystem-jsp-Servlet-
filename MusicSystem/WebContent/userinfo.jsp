<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ResultSet rst = (ResultSet)session.getAttribute("info");
if(rst.next()){
%>
<form action="UpdateUserinfoServlet" method="post">
	用户ID：<input name="Id" value=<%=rst.getString("Id") %> readonly="readonly" /><br>
	用户名：<input name="Name" value=<%=rst.getString("Name") %> /><br>
	密&nbsp;&nbsp;&nbsp;码：<input name="Password" type="password" value=<%=rst.getString("Password") %> /><br>
	性&nbsp;&nbsp;&nbsp;别：<input name="Sex" value=<%=rst.getString("Sex") %> /><br>
	年&nbsp;&nbsp;&nbsp;龄：<input name="Age" value=<%=rst.getString("Age") %> /><br>
	住&nbsp;&nbsp;&nbsp;址：<input name="Address" value=<%=rst.getString("Address") %> /><br>
	电&nbsp;&nbsp;&nbsp;话：<input name="Phone" value=<%=rst.getString("Phone") %> /><br>
	<input value="更新" type="submit" />
	<input type="reset" />
</form>
<%
}
%>
</body>
</html>