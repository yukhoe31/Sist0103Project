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

<%
request.setCharacterEncoding("utf-8");
String email= request.getParameter("email1")+"@"+request.getParameter("email2");


%>

<jsp:useBean id="dao" class="data.dao.MemberDao"/>
<jsp:useBean id="dto" class="data.dto.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
 dto.setEmail(email);

 dao.insertMember(dto);

 //일단은 리스트...가입성공페이지로 바꿀예정 : ?id 해서 gaipSuccess 에 보내줘야한다.
 response.sendRedirect("../index.jsp?main=member/gaipSuccess.jsp?id="+dto.getId());
 
 
 
%>

</body>
</html>