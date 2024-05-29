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
<body>


<div class="loginform" style="margin: 50px 100px;">
	<form action="loginprocess" method="post">
		<table class="table table-bordered" style="width:400px;">
			<caption align="top"><b>회원로그인</b></caption>
			
			<tr>
				<th style="width: 120px; background-color: #ddd;">아이디</th>
				<td>
					<input type="text" name="id" class="form-control"
					required="required" autofocus="autofocus"
					style="width: 150px;" placeholder="아이디"
					value="${sessionScope.saveok == null?"":sessionScope.myid }">
				</td>
			</tr>
			<tr>
				<th style="width: 120px; background-color: #ddd;">비밀번호</th>
				<td>
					<input type="password" name="pass" class="form-control"
					required="required" 
					style="width: 150px;" placeholder="비밀번호">
				</td>
			</tr>
		
			<tr>
				<td colspan="2" align="center">
					<input type="checkbox" name="cbsave"
					${sessionScope.saveok == null? "":"checked" }>아이디저장
					&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-info"
					style="width: 130px;">회원로그인</button>
				</td>
			</tr>
		
		</table>

	</form>

</div>


</body>
</html>