<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  <div style="margin: 50px 100px; width: 800px;">
     <button type="button" class="btn btn-outline-info btn-sm"
     onclick="location.href='writeform'" style="margin-left: 700px;">회원가입</button>
     
     
<table class="table table-bordered" >
	<caption align="top">회원 전체 명단</caption>
	<tr class="table-light">
		<th width="100">번호</th>
		<th width="100">회원명</th>
		<th width="150">아이디</th>
		<th width="150">핸드폰</th>
		<th width="200">가입일</th>		
		<th width="200">수정/삭제</th>				
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<tr align="center">
			<td>${i.count}</td>
			<td>${dto.name}</td>
			<td>${dto.id}</td>
			<td>${dto.hp}</td>
			<td>
				<fmt:formatDate value="${dto.gaipday}"
					pattern="yyyy-MM-dd HH:mm"/>
			</td>
			<td>
				<button type="button" class="btn btn-info btn-sm"
					onclick="location.href='updateform?num=${dto.num}'">수정</button>
				<button type="button" class="btn btn-danger btn-sm"
					onclick="location.href='delete?num=${dto.num}'">삭제</button>
			</td>			
		</tr>
	</c:forEach>
</table>
     
  </div>
</body>
</html>