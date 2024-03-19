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
	request.setCharacterEncoding("utf-8");

    //업로드에 필요한 변수선언
    //업로드할 경로(톰캣에 올라가는 프로젝트경로)
	String realPath = getServletContext().getRealPath("/upload2");
	System.out.println(realPath);

	int uploadSize = 1024 * 1024 * 5; //5mb

	
	//생성자파라메터(request,업로드폴더,업로드사이즈,한글,같은이름일경우 1,2,3붙히기)
	try {
		MultipartRequest multi = null;
		multi = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());

		//입력값읽기

		String m_photo = multi.getFilesystemName("m_photo");

		
		//dao선언
		MemgaipDao dao = new MemgaipDao();

		//dto에 담기
		MemgaipDto dto = new MemgaipDto();

		dto.setM_id(multi.getParameter("m_id"));
		dto.setM_pass(multi.getParameter("m_pass"));
		dto.setM_name(multi.getParameter("m_name"));
		dto.setM_num(multi.getParameter("m_num"));
		dto.setM_hp(multi.getParameter("m_hp"));
		dto.setM_photo(multi.getParameter("m_photo"));

		
		if (m_photo == null) {
			//사진선택안하면 기존의 사진을 그대로 넣어준다.
			String oldPhoto = dao.getOneMember(dto.getM_num()).getM_photo();
			
			dto.setM_photo(oldPhoto);//사진선택안한경우
			
		} else {
			dto.setM_photo("../upload2/" + m_photo);//한경우
		}

		//dto.setM_photo(photo);

		

		dao.updateMember2(dto);
		response.sendRedirect("memList.jsp");

	} catch (Exception e) {

	}
	%>
</body>
</html>