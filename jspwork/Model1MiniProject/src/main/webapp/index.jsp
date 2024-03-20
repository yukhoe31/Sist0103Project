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

<style type="text/css">
	div.layout{
		border:0px solid gray;
		position: absolute;
	}
	
	div.title{
		width: 100%;
		height: 80px;
		line-height: 80px;
		font-size: 20pt;
		font-family: 'Diphylleia';
		text-align: center;
	}
	
	div.menu{
		width: 100%;
		height: 80px;
		line-height: 80px;
		font-size: 15pt;
		font-family: 'Diphylleia';
		text-align: center;
		top:90px;
	}
	
	div.info{
		width: 370px;
		height: 250px;
		line-height: 10px;
		font-size: 13pt;
		font-family: 'Diphylleia';
		left:50px;
		top:250px;
		border: 5px groove gray;
		border-radius: 30px;
		padding: 20px 20px;
	
	}
	
	div.main{
		width: 560px;
		height: 500px;
		font-size: 13pt;
		font-family: 'Diphylleia';
		border: 0px groove purple;
		left:500px;
		top: 250px;
		
	}
</style>


</head>

<%
	//프로젝트 경로
	String mainPage = "layout/main.jsp"; //기본페이지
	
	//url을 통해서 main값을 읽어서 메인페이지에 출력한다.
	if(request.getParameter("main")!=null){
		mainPage = request.getParameter("main");
		
		
	}
%>

<body>
<div class="layout title">
	<jsp:include page="layout/title.jsp"/>
</div>
<div class="layout menu">
	<jsp:include page="layout/menu.jsp"/>
</div>
<div class="layout info">
	<jsp:include page="layout/info.jsp"/>
</div>
<div class="layout main">
	<jsp:include page="<%=mainPage %>"/>
</div>

</body>
</html>