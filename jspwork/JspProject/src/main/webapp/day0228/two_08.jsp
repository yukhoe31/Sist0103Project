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
	<h3>twoInclude_08.jsp include하기</h3>
	<%
		request.setCharacterEncoding("utf-8"); //한글 인코딩
	%>
	
	<jsp:include page="twoInclude_08.jsp">
		<jsp:param value="신민아" name="name"/>
		<jsp:param value="서울 강남구" name="addr"/>
	    <jsp:param value="../image/연예인사진/연예인사진/17.jpg" name="celeb"/>
	</jsp:include>

</body>
</html>