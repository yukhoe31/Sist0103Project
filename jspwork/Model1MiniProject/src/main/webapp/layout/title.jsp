<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
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
<%
	//프로젝트 경로
	String root = request.getContextPath();

%>
<body>
	<a href="<%=root %>" style="color: black; text-decoration: none">
	<img alt="" src="<%=root%>/image/miniproject_img/title.png"  width="300px">
	</a>
	
	<div style="float: right; padding-right: 100px;">
		<%
			//로그인 세션얻기
			String loginok = (String)session.getAttribute("loginok");
		
			//아이디 얻기
			String myid = (String)session.getAttribute("myid");
			
			MemberDao dao = new MemberDao();
			MemberDto dto= dao.getMemberById(myid);
			String name= dto.getName();
			
			if(loginok == null){%>
				
				<button type="button" class="btn btn-success"
				style="width: 100px;"
				onclick="location.href='index.jsp?main=login/loginform.jsp'">
				Login</button>
				
			<%}else{%>
				
				<b style="font-size: 12pt"><%=name%>님 로그인 중 &#128275;</b>
				<button type="button" class="btn btn-danger"
				style="width: 100px;"
				onclick="location.href='login/logoutaction.jsp'">
				Logout</button>
				
			<%}
			
		%>
	</div>
	
	
</body>
</html>