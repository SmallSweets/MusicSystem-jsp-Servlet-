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
<style type="text/css">
body{
	margin-top:150px;
}
</style>
</head>
<body>
<center>
<form action="SearchMusicServlet" method="get">
	<input name="key" />
	<input type="submit" value="搜索" />
</form>
</center>
<br>
<br>

<%
ResultSet rst = (ResultSet)request.getAttribute("result");
if(rst != null){
	rst.absolute(0);	
	if(rst.next()){
%>
		<center>
			<table border="1">
			<tr><td>序号</td><td>歌曲名称</td><td>歌手</td><td>添加时间</td><td></td><td>操作</td></tr>
			<%
			/* 移动指针到第一行 */
			rst.absolute(0);
			while(rst.next()){
			%>
				<tr>
				<td><%=rst.getString("Id") %></td><td><%=rst.getString("Name") %></td><td><%=rst.getString("Singer") %></td>
				<td><%=rst.getString("Time") %></td><td><button class="listen" name=<%=rst.getString("Id") %>>播放/暂停</button>
				<audio id=<%=rst.getString("Id") %> src=<%=rst.getString("Url") %>></audio></td><td><button name=<%=rst.getString("Id")
				%> class="update">更新</button><button name=<%=rst.getString("Id") %> class="delete">删除</button></td>
				</tr>
			<%
			}
			%>
			</table>
		</center>
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
	$(".listen").click(function(){
		var id = $(this).attr("name");
		var audio = document.getElementById(id);
		if(audio.paused){
			/* 播放 */
			audio.play();
		}else{
			/* 暂停 */
			audio.pause();
		}
	})
	
		/* 更新按钮点击时进入更新歌曲页面 */
	$(".update").click(function(){
		var Id = $(this).attr("name");
		$(location).attr("href","MusicInfoServlet?Id="+Id)
	})
	
		/* 删除按钮点击时删除音乐信息 */
	$(".delete").click(function(){
		var Id = $(this).attr("name")
		$(location).attr("href","DeleteMusicServlet?Id="+Id)
	})
})
</script>
</body>
</html>