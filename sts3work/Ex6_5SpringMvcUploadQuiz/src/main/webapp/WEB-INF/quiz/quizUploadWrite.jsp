<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="bg-success p-2 text-dark bg-opacity-50">
	<h5>상품명: ${name }</h5>
	<h5>상품 이미지들</h5>
	<c:forEach var="im" items="${files }">
		<img alt="" src="../image/${im }"
			style="max-width: 200px; border: 2px solid gray;">
	</c:forEach>
	<h5>가격: ${price }원</h5>
	<h5>입고일: ${ipgoday }</h5>

	<h5>업로드할 실제경로:</h5>
	<h5>${path }</h5>
</div>
</body>
</html>