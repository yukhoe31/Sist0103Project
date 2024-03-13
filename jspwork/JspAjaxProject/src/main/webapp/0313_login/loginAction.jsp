<%@page import="log.model.LogDao"%>
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
String id= request.getParameter("id");
String pass = request.getParameter("pass");
String save = request.getParameter("savechk");

//아이디와 비번이 맞는지 확인해야
LogDao db = new LogDao();
boolean flag = db.isLogin(id, pass);

//맞으면 세션을 저장후에 로그인 메인으로 이동
if(flag){
	
	//로그인중인지 알수 있는 세션저장
	session.setAttribute("loginok", "yes");
	
	//아이디와 체크값 저장
	session.setAttribute("idok", id); 
	//아이디 체크에 ok되어있으면 id를 남길 것이므로
	
	//체크하면 on,체크안하면 null
	session.setAttribute("saveok", save);
	
	//세션유지 시간(8시간 = 60초 * 60 * 8)
	session.setMaxInactiveInterval(60*60*8);//8시간동안 유지
	
	//로그인 메인으로 간다.
	response.sendRedirect("loginMain.jsp");
	
}else{%>
	
	<script type="text/javascript">
		alert("아이디와 비밀번호가 맞지 않습니다.");
		history.back();
	
	</script>

<%}


%>

</body>
</html>