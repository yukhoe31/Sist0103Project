<%@page import="test.Student" %>
<%@page import="java.util.Vector" %>

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
<body>
	<h3>request에 Vector 저장후 불러오는 연습</h3>
	
	<%
		Vector<Student> list = new Vector<>();
		list.add(new Student("이미영","강남구",88));
		list.add(new Student("이영자","서초구",88));
		list.add(new Student("김미영","영등포구",88));
		list.add(new Student("이소라","부산시",88));
		list.add(new Student("배윤영","제주 애월",88));	
	
		//데이터 vector를 리퀘스트에 저장하는 방법
		request.setAttribute("list", list);	
	
	
	%>
	
	<jsp:forward page="stuForward_10.jsp"/>
	
	response
</body>
</html>