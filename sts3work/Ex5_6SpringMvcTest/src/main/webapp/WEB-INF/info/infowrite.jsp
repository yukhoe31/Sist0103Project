<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="alert alert-info">
		이름: ${dto.name }<br>
		좋아하는 색: ${dto.color }
		<div style="width: 30px; height: 30px; background: ${dto.color}"></div>

		취미:
		<c:if test="${empty dto.hobby }" >취미없음</c:if>
		
		<c:forEach var="h" items="${dto.hobby }">
			[${h}]
		</c:forEach>
		
		<br>
		가장 재밌는 언어: ${dto.lang }
	</div>

</body>
</html>
