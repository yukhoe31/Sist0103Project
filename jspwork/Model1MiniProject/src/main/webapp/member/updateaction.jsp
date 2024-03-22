<!-- 이것은 updateaction.jsp와 같은 기능을 하는 것으로
선생님 답안. -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String email= request.getParameter("email1")+"@"+request.getParameter("email2");

//아래것은 써뒀는데 딱히 쓸 곳 없다. mypage는 알아서 내 것만 보여지므로
//String num = request.getParameter("num");

%>

<jsp:useBean id="dao" class="data.dao.MemberDao"/>
<jsp:useBean id="dto" class="data.dto.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
 	 dto.setEmail(email);
	 
     dao.updateMember(dto);

     response.sendRedirect("../index.jsp?main=member/mypage.jsp");
  %>
</body>
</html>