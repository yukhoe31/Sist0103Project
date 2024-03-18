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
	String key = request.getParameter("key");
   //처음호출시 무조건 null값 뜬다. 왜냐하면 없으니까!
   
   if(key == null){
	   //null값일때는 폼을 나타내고
	   %>
	   <div style="margin: 10px 30px;">
	   		<form action="idSearch.jsp" method="post">
	   			<b>아이디를 입력해주세요</b><br>
	   			<div class="d-inline-flex">
	   			<input type="text" name="m_id" class="form-control" style="width: 130px;"
	   			required="required" placeholder="아이디 입력">
	   			<input type="hidden" name="key" value="yes">
	   			<button type="submit" class="btn btn-success" style="margin-left: 10px;">
	   			중복체크</button>
	   			</div>
	   		</form>
	   </div>
   <%}else{
	   //action처리:id의 존재여부 확인
	   
   }
%>
</body>
</html>