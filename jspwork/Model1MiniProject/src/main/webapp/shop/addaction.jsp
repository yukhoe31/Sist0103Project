<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.ShopDto"%>

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
    request.setCharacterEncoding("utf-8");
  
    //업로드에 필요한 변수선언
    //업로드할 경로(톰캣에 올라가는 프로젝트경로)
    String realFolder=getServletContext().getRealPath("/shopsave");
    System.out.println(realFolder);
  
     //업로드사이즈
     int uploadSize=1024*1024*3;//3mb
     
     //생성자파라메터(request,업로드폴더,업로드사이즈,한글,같은이름일경우 1,2,3붙히기)
     try{
     MultipartRequest multi=new MultipartRequest(request,realFolder,uploadSize,"utf-8",
    		 new DefaultFileRenamePolicy());
	
	String sangpum = multi.getParameter("sangpum");
	String category = multi.getParameter("category");
	String ipgoday = multi.getParameter("ipgoday");
	int price = Integer.parseInt( multi.getParameter("price"));
	//실제 업로드 이미지이름 읽어오기
    String photo=multi.getFilesystemName("photo");
	
	System.out.println(photo);
	
	//dao
	ShopDao dao = new ShopDao();
	
	//dto에 데이터담기
	ShopDto dto = new ShopDto();
	dto.setSangpum(sangpum);
	dto.setCategory(category);
	dto.setIpgoday(ipgoday);
	dto.setPrice(price);
	dto.setPhoto(photo);
	
	
    //insert
    dao.insertShop(dto);
    
    //목록이동
    response.sendRedirect("../index.jsp?main=shop/addform.jsp");
	
}catch(Exception e){
	
	
}



%>

</body>
</html>