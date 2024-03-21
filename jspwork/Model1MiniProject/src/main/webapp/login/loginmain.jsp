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

<%
	//세션이 저장된 loginok 가져온다.
	String loginok = (String)session.getAttribute("loginok");
	
	//로그아웃상태
	if(loginok==null){%>
		<jsp:include page="loginform.jsp"/>
	<%}else{%>
		<jsp:include page="logoutform.jsp"/>
	<%}
	
%>


</body>
</html>