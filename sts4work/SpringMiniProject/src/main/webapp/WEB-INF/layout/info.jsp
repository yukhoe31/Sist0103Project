<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
   <i class="bi bi-envelope-arrow-down-fill"></i> &nbsp;pokemon@gmfreak.com<br>
   <i class="bi bi-headset"></i>&nbsp;02-123-4567<br>
   <i class="bi bi-house-add-fill"></i>&nbsp;서울시 강남구 역삼동 한독빌딩<br>

	<!-- 로그아웃 상태는 기본이미지 로그인상태는 로그인한이미지 나오게 -->
	
	<c:if test="${sessionScope.loginok == null }">
		<img alt="" src="${root }/image/monsterball.png" width="130" height="130"
		style="border-radius: 100px;">
		
	</c:if>
	
	<c:if test="${sessionScope.loginok != null }">
		<img alt="" src="${root }/memberphoto/${sessionScope.loginphoto}" width="130" height="130"
		style="border-radius: 100px;">
		
	</c:if>
</body>
</html>