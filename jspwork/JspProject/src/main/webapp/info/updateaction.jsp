<%@page import="info.model.InfoDto"%>
<%@page import="info.model.InfoDao"%>
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
//한글엔코딩
request.setCharacterEncoding("utf-8");

//데이터 읽어서 dto담기
String num = request.getParameter("num");
String name = request.getParameter("name");
String addr = request.getParameter("addr");

//입력데이터를 dto로 묶어서
InfoDto dto = new InfoDto();
dto.setNum(num);
dto.setName(name);
dto.setAddr(addr);

//db에 저장
InfoDao dao = new InfoDao();
dao.infoUpdate(dto);

//목록
response.sendRedirect("list.jsp");

%>

</body>
</html>