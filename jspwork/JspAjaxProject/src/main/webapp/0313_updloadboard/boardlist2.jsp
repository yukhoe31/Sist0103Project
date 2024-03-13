<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="uploadboard.data.UploadBoardDao"%>
<%@page import="uploadboard.data.UploadBoardDto"%>
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
UploadBoardDao dao = new UploadBoardDao();
List<UploadBoardDto> list = dao.getAllDatas();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

%>

<body>

	<div style="margin: 50px 100px; width: 1000px">
		<button type="button" class="btn btn-info"
		onclick="location.href='addform.jsp'">게시글추가</button>
		
		<button type="button" class="btn btn-warning" onclick="locaton.href='boardlist2.jsp'">앨범형 목록으로 보기</button>
		
		<h6 class="alert alert-info">총 <%=list.size() %>개의 게시글이 있습니다.</h6>
		
		<table class="table table-hover">
			<tr>
				<th width="80">번호</th>
				<th width="180">제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
				<th width="50">조회</th>
			</tr>
			
		<%
         for(int i=0;i<list.size();i++)
         {
        	 //1번 열에 출력할번호
        	 int no = list.size() -i;
        	 //i번째 dto얻기       	 
        	 UploadBoardDto dto=list.get(i);  //i번지의 dto를 꺼낸다
        	 %>
        	
        	 <tr>
        	   <td align="left"><%=no %></td>
        	   <td>
        	   <a href="content.jsp?num=<%=dto.getNum() %>" style="text-decoration: none; color: black;">
        	   <img src="../save/<%=dto.getImgname() %>" style="width:30px;">
        	   <%=dto.getSubject() %></a></td>
        	   <td><%=dto.getWriter() %></td>
        	   <td><%=sdf.format(dto.getWriteday()) %></td>
        	   <td><%=dto.getReadcount() %></td>
        	 </tr>
         <%}
		 
		 %>
		</table>	
	
	</div>
</body>
</html>