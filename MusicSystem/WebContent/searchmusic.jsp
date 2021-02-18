<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 导入jQuery -->
<script type="text/javascript" src="jquery-3.5.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="SearchMusicServlet" method="get">
	<input name="key" />
	<input type="submit" value="搜索" />
</form>
<br>
<br>

<%
ResultSet rst = (ResultSet)request.getAttribute("result");
if(rst != null){
	rst.absolute(0);	
	if(rst.next()){
%>
		<table border="1">
		<tr><td>序号</td><td>歌曲名称</td><td>歌手</td><td>添加时间</td><td></td></tr>
		<%
		/* 移动指针到第一行 */
		rst.absolute(0);
		while(rst.next()){
		%>
			<tr>
			<td><%=rst.getString("Id") %></td><td><%=rst.getString("Name") %></td><td><%=rst.getString("Singer") %></td>
			<td><%=rst.getString("Time") %></td><td><button class=<%=rst.getString("Id") %>>播放/暂停</button>
			<audio id=<%=rst.getString("Id") %> src=<%=rst.getString("Url") %>></audio></td>
			</tr>
		<%
		}
		%>
		</table>
<% 
	}else{
%>
		<h1>没有找到相关音乐，搜索一下其他的吧</h1>
<%
	}
}
%>

<script type="text/javascript">
$(function(){
	/* 播放按钮点击时 播放歌曲 */
	$("button").click(function(){
		var id = $(this).attr("class");
		var audio = document.getElementById(id);
		if(audio.paused){
			/* 播放 */
			audio.play();
		}else{
			/* 暂停 */
			audio.pause();
		}
	})
})
</script>
</body>
</html>