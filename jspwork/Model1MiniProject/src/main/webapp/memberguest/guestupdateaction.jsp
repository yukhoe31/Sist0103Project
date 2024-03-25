<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%

//String myid = (String) session.getAttribute("myid");

String realPath = getServletContext().getRealPath("/save");
System.out.println(realPath);

int uploadSize = 1024 * 1024 * 3;//3mb

MultipartRequest multi = null;

try {
	multi = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());

	String num = multi.getParameter("num");
	String currentPage = multi.getParameter("currentPage");
	
	String content = multi.getParameter("content");
	String photoname = multi.getFilesystemName("photo");

	
	//기존 포토명 가져오기
	GuestDao dao = new GuestDao();
	String old_photoname = dao.getData(num).getPhotoname();
	
	
	
	//dto에 저장s
	GuestDto dto = dao.getData(num);
	
 	dto.setNum(num);
	//dto.setMyid(myid);
	dto.setContent(content);
	//사진선택을 안하면 예전 사진 그대로 사용하겠다는 의미
	dto.setPhotoname(photoname == null?old_photoname:photoname);

	//update
	dao.updateGuest(dto);
	

	//방명록 목록으로 이동(수정했던 페이지로 이동해야한다.)
	response.sendRedirect("../index.jsp?main=memberguest/guestlist.jsp?currentPage="+currentPage);

} catch (Exception e) {

}
%>



<body>

</body>
</html>