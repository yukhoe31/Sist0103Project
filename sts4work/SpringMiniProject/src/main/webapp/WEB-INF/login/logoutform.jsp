<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>

<body>

<div style="margin-left: 50px 100px;">
	<img alt="" src="${root }/image/welcome.jpg" width="200" align="left" hspace="20">
	<br><br>
	<b>${sessionScope.myid }님 로그인중</b><br><br><br>
	<button type="button" class="btn btn-danger"
	style="width: 100px;" onclick="location.href='logoutprocess'">로그아웃</button>

</div>


</body>
</html>