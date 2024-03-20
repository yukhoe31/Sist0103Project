<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
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



</head>
<%
//프로젝트 경로
String root = request.getContextPath();


String id = request.getParameter("id");//id를 받아야 써먹지!


	
%>

<body>
<div class="container mt-5">
    <div >
        <div align="center" >
            <img src="<%=root %>/image/miniproject_img/pkmn_1.png" alt="" width="400px">
            
            <h3 ><%=id %>님,
            <br>회원가입에 
            <br>성공했습니다.</h3>
            <br>
            <a href="login/loginform.jsp" class="btn btn-warning">로그인</a>
            <a href="<%=root %>" class="btn btn-success">확인</a>
        </div>
    </div>
</div>


</body>
</html>