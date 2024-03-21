<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Diphylleia&family=Dongle&family=Gowun+Dodum&family=Nanum+Pen+Script&family=Orbit&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>

<div style="margin: 100px 200px;">
	<img src="image/miniproject_img/welcome.jpg" width="300px">
	<%
	String myid = (String)session.getAttribute("myid");
	MemberDao dao = new MemberDao();
	MemberDto dto= dao.getMemberById(myid);
	String name = dto.getName();
	
	
	%>
	
	<br><br>
	
	<b><%=name %>님 로그인중</b>
	<button type="button" class="btn btn-danger"
	onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
	
	
</div>

</body>
</html>