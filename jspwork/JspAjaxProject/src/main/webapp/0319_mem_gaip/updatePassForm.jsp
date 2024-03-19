<%@page import="mem_gaip.model.MemgaipDto"%>
<%@page import="mem_gaip.model.MemgaipDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
String m_num = request.getParameter("m_num");

%>

<body>
	<div style="margin: 20px 20px;">
		<form action="updatePassAction.jsp" method="post">
			<input type="hidden" name="m_num" value="<%=m_num%>">
			<div class="input-group">
				<b>비밀번호</b>
				<input type="password" class="form-control-sm"
				required="required" name="m_pass" style="width: 140px;">
			</div>
			<br>
			<button type="submit" class="btn btn-danger">수정시 필요한 비번 확인</button>
		</form>
	</div>
</body>
</html>