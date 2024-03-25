<%@page import="java.io.File"%>
<%@page import="data.dao.GuestDao"%>
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

  //db삭제뿐 아니라 업로드된 파일도 삭제해보기
  String num=request.getParameter("num");
  String currentPage=(request.getParameter("currentPage")) ;
  
  //db로부터 저장된 이미지명 얻기
  GuestDao dao=new GuestDao();
  String photoname = dao.getData(num).getPhotoname();
  
  //삭제
  dao.deleteGuest(num);
  
  //파일삭제
  //프로젝트 삭제경로
  String realPath = getServletContext().getRealPath("/save");
  
  //파일객체생성
  File file = new File(realPath +"/" +photoname);
  
  //파일삭제
  if(file.exists()){
	  file.delete();
	  
  }
  
  
  //보던 페이지
  String go="../index.jsp?main=memberguest/guestlist.jsp?currentPage="+currentPage;

  response.sendRedirect(go);

%>
</body>
</html>