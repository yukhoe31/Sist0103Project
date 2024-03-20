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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Insert title here</title>
</head>
<%
	//프로젝트 경로
	String root = request.getContextPath();

%>
<body>
	<div style="font-size: 13pt; line-height: 25px;">
		<i class="bi bi-person-circle"></i> 주식회사 게임프리크<br>
		<i class="bi bi-telephone-inbound"></i> 01-234-5678<br>
		<i class="bi bi-house-add"></i> 일본 도쿄도 치요다구 칸다 니시키 쵸 2-2-1 KANDA SQUARE<br>
		<i class="bi bi-envelope-arrow-down"></i> gamefreak@gamefreak.com<br>
	    <a href="https://pokemonkorea.co.kr/"  target="_blank">
	    <i class="bi bi-upc-scan"> <img alt="" src="<%=root %>/image/miniproject_img/pokemon_logo.png"  width="150px"><br> </i> 
		</a>
	</div>
</body>
</html>