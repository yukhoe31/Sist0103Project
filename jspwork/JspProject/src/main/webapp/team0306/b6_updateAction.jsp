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
	String driver = request.getParameter("driver:");
%>

<jsp:useBean id="dao" class="team.model.TeamDao"/>
<jsp:useBean id="dto" class="team.model.TeamDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
dto.setDriver(driver==null?"없음":"있음");

//update
dao.updateTeam(dto);

//목록으로 이동
response.sendRedirect("teamList.jsp");


%>

</body>
</html>