<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
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
 
     
     //입력값 읽기
     String writer=request.getParameter("writer");
     String subject=request.getParameter("subject");
     String content=request.getParameter("content");
     String num=request.getParameter("num");
     
     //dto에 담기
     SimpleBoardDto dto=new SimpleBoardDto();
     
     dto.setWriter(writer);
     dto.setSubject(subject);
     dto.setContent(content);
     dto.setNum(num);
     
     //dao생성
     SimpleBoardDao dao=new SimpleBoardDao();
     
     dao.updateSimpleBoard(dto); //수정
     response.sendRedirect("contentview.jsp?num="+num);
  
  %>
</body>
</html>