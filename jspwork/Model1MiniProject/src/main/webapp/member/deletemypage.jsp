


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
<body>

<%


String num = request.getParameter("num");
String pass= request.getParameter("pass");


//dao
MemberDao dao = new MemberDao();

//비번체크해서 맞으면 삭제
boolean b = dao.isEqualPass(num, pass);

if(b){
	dao.deleteMember(num);
	%>
	
	<script type="text/javascript">
		alert("회원탈퇴성공!!");
		
		location.href="../index.jsp";
	</script>
<%}else{%>
	
	<script type="text/javascript">
		alert("비번이 틀립니다.");
		history.back();
	
	
	</script>
<%}



%>


</body>
</html>