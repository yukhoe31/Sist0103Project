<%@page import="mem_gaip.model.MemgaipDto"%>
<%@page import="mem_gaip.model.MemgaipDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
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
<body>
<%
	String realPath= getServletContext().getRealPath("/upload2");
	int uploadSize=1024*1024*5; //5mb
	
	MultipartRequest multi = null;
	
	multi = new MultipartRequest(request,realPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
	
	//dao선언
	MemgaipDao dao = new MemgaipDao();
	
	MemgaipDto dto = new MemgaipDto();
	
	dto.setM_id(multi.getParameter("m_id"));
	dto.setM_pass(multi.getParameter("m_pass"));
	dto.setM_name(multi.getParameter("m_name"));
	dto.setM_num(multi.getParameter("m_num"));
	dto.setM_hp(multi.getParameter("m_hp"));
	
	String photo = multi.getFilesystemName("m_photo");
	
	if(photo==null){
		dto.setM_photo("../image/연예인사진/no_image.png");//사진선택안한경우
	}else{
		dto.setM_photo("../upload2/"+photo);//한경우
	}
	
	
	//dto.setM_photo(photo);
	
	dao.insertMemgaip(dto);
	
	//성공후 목록이동
	response.sendRedirect("memList.jsp");
	
	
	
	
%>

</body>
</html>