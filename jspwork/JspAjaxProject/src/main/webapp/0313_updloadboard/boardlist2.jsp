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
<style>
.album {
    display: flex;
    flex-wrap: wrap;
    gap: 20px; /* Adjust the gap between album items */
}

.album-item {
    width: 200px; /* Adjust the width of each album item */
    border: 1px solid #ccc;
    padding: 10px;
    text-align: center;
}
</style>
<title>Album View</title>
</head>
<%
UploadBoardDao dao = new UploadBoardDao();
List<UploadBoardDto> list = dao.getAllDatas();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<body>
	<div style="margin: 50px 100px;">
		<button type="button" class="btn btn-info"
			onclick="location.href='addform.jsp'">게시글 추가</button>
		
		<button type="button" class="btn btn-warning"
			onclick="location.href='boardlist.jsp'">리스트형 목록</button>

		<h6 class="alert alert-info">총 <%=list.size() %>개의 게시글이 있습니다.</h6>

		<div class="album">
			<%
			for(int i=0; i<list.size(); i++) {
				UploadBoardDto dto = list.get(i);
			%>
			<div class="album-item">
				<a href="content.jsp?num=<%=dto.getNum() %>"
					style="text-decoration: none; color: black;">
					<img src="../upload/<%=dto.getImgname() %>"
						style="height: 150px;" alt="<%=dto.getSubject() %>" >
					<p>제목 : <%=dto.getSubject() %></p>
					<p>작성자 : <%=dto.getWriter() %></p>
					<p>작성일 : <%=sdf.format(dto.getWriteday()) %></p>
					<p>조회수 : <%=dto.getReadcount() %></p>
				</a>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
