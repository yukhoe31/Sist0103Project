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
<%
  //num을 읽어서 form에 hidden으로 넣는다.
  String num=request.getParameter("num");
%>
<body>
	<div style="margin: 200px 200px; width: 300px; ">
		<form action="deletepassaction.jsp" method="post">
		<input type="hidden" name="num" value="<%=num%>">
			<div class="d-inline-flex">
				<h4 style="width: 100px;">비밀번호</h4>
				<input type="password" class="form-control" required="required"
				name="password" style="width: 150px;">
			</div>			
			<br><br>
			<button type="submit" class="btn btn-danger"
			style="margin-left: 100px;">삭제</button>
		</form>
	</div>
</body>
</html>