<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 导入jQuery -->
<script type="text/javascript" src="jquery-3.5.1.js"></script>
<!-- 创建工具类对象 等同于使用 new -->
<jsp:useBean class="util.DatabaseConnect" id="dbconnect"></jsp:useBean>
</head>
<body>
<table border="1">
<tr><td>序号</td><td>歌曲名称</td><td>歌手</td><td>添加时间</td><td></td><td>操作</td></tr>
<%
Connection conn = dbconnect.dbconnect();
PreparedStatement pst = conn.prepareStatement("select * from musicsystem_info");
ResultSet rst = pst.executeQuery();
while(rst.next()){
%>
<tr>
<td><%=rst.getString("Id") %></td><td><%=rst.getString("Name") %></td><td><%=rst.getString("Singer") %></td>
<td><%=rst.getString("Time") %></td><td><button class=<%=rst.getString("Id") %>>播放/暂停</button><audio id=<%=rst.getString("Id")
%> src=<%=rst.getString("Url") %>></audio></td><td><a>更新</a></td>
</tr>
<%
}
%>
</table>

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