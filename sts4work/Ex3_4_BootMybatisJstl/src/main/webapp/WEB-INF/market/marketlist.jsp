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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
</head>
<body style="margin: 50px 50px;">

	<div style="margin: 100px 100px;">
		<button type="button" class="btn btn-outline-info"
			onclick="location.href='addform'">상품등록</button>
	</div>


	<c:if test="${totalCount == 0}">
		<div class="alert alert-info">
			<b>저장된 정보가 없습니다.</b>
		</div>
	</c:if>

	<c:if test="${totalCount > 0}">
		<div class="alert alert-danger">
			<b>총 ${totalCount }개의 상품정보가 있습니다.</b>
		</div>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>이미지</th>
					<th>상품명</th>
					<th>가격</th>
					<th>입고일</th>
					<th>편집</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${list }" varStatus="i">
					<tr>
						<td align="center">
						
						<c:if test="${a.photoname == no}">
							<img src="/photo/noimage.jpg" alt="이미지" width="100">
						</c:if>
						<c:if test="${a.photoname != no}">
							<img src="/photo/${a.photoname}" alt="이미지" width="100">
						</c:if>
						</td>
						<td>${a.sang}</td>
						<td><fmt:formatNumber value="${a.dan}"/> </td>
						<td><fmt:formatDate value="${a.ipgoday}" pattern="yyyy-MM-dd HH:mm"/>  </td>
						<td><button type="button" class="btn btn-outline-primary"
								onclick="location.href='updateform?num=${a.num}'">수정</button>
							<button type="button" class="btn btn-outline-danger"
								onclick="location.href='delete?num=${a.num}'">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</c:if>




</body>
</html>