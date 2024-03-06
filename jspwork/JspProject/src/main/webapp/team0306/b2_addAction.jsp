<%@page import="team.model.TeamDto"%>
<%@page import="team.model.TeamDao"%>
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

<%--
<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String driver = request.getParameter("driver");
	String addr = request.getParameter("addr");
	
	//driver체크박스 활용 확인용
	//System.out.println(driver); //체크안하면 null, 체크하면 on
	
	//dto선언
	TeamDto dto = new TeamDto();
	dto.setName(name);
	dto.setDriver(driver==null?"없음":"있음");
	dto.setAddr(addr);
	
	//dao선언
	TeamDao dao = new TeamDao();
	//insert메서드 호출
	dao.insertTeam(dto);
	
	//목록파일로 이동
	response.sendRedirect("b3_teamList.jsp");	
	
%> 
--%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!-- jsp:useBean은 new로 객체 생성하는것과 같다 -->
<jsp:useBean id="dao" class="team.model.TeamDao"/>
<jsp:useBean id="dto" class="team.model.TeamDto"/>
<!-- dto의 멤버와 같은 이름의 태그는 자동으로 읽어서 dto에 넣어준다. -->
<jsp:setProperty property="*" name="dto"/>

<%

String driver = request.getParameter("driver");
dto.setDriver(driver==null?"없음":"있음");

dao.insertTeam(dto);

response.sendRedirect("b3_teamList.jsp");


%>

</body>
</html>