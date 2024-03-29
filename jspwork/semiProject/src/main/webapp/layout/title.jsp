<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	div.btnlog{
		position: absolute;
		top: 50px;
		right: 100px;
	}
</style>
</head>
<%
	//프로젝트 경로
	String root=request.getContextPath();
%>
<body>
	<a href="<%=root%>" style="color: black;"><img src="<%=root%>/image/semi/logo3.png" style="width: 300px;"></a>
<div class="btnlog">
	<button type="button" style="float: right; margin-left: 20px" class="btn btn-success" onclick="location.href='index.jsp?main=member/addform.jsp'">회원가입</button>
	<button type="button" style="float: right;" class="btn btn-info">로그인</button>
</div>
</body>
</html>