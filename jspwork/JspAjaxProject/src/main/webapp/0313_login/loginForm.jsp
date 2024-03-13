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
<style type="text/css">



</style>

</head>
<body>

<div style="margin: 100px 100px;">
	<h2 class="alert alert-warning">회원 로그인</h2>
	<form action="loginAction.jsp" method="post">
		<input type="text" name="id" class="form-control"
		style="width:200px;" placeholder="로그인할 아이디" required="required">
		<br>
		<input type="text" name="pass" class="form-control"
		style="width: 200px;" placeholder="로그인할 패스워드"  required="required">
		<br>
		<button type="submit" class="btn btn-success btn-lg"
		style="width: 200px; height: 50px;">로그인</button>
		<br>
		<input type="checkbox" name="savechk"> 아이디 저장
	</form>

</div>

</body>
</html>