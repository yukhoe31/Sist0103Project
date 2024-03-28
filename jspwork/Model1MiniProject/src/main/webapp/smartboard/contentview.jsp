<%@page import="java.io.StringReader"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Diphylleia&family=Dongle&family=Gowun+Dodum&family=Nanum+Pen+Script&family=Orbit&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
function funcdel(num, currentPage) {
    //alert(num + "," + currentPage);
    var ans = confirm("삭제하려면 [확인]을 눌러주세요.");
    
    if (ans) {
        location.href = 'smartboard/smartdelete.jsp?num=' + num + '&currentPage=' + currentPage;
    }
}

</script>

</head>
<%
	String num=request.getParameter("num");
    String currentPage= request.getParameter("currentPage");

	SmartDao dao=new SmartDao();
	//dto
	SmartDto dto=dao.getData(num);
	//조회수1증가
	dao.updateReadcount(num);
	//날짜
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>

<input type="hidden" id="num" value="<%=num%>">


<div style="margin: 50px 100px; width: 500px;">
	<table class="table table-bordered">
		<caption align="top">
			<b style="font-size: 15pt;"><%=dto.getSubject() %></b>
		</caption>
		<tr>
			<td><b>작성자: <%=dto.getWriter()%></b><br> <span><%=sdf.format(dto.getWriteday())%></span>
				&nbsp;&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount()%></td>
		</tr>
		<tr height="250">
			<td><%=dto.getContent().replace("\n", "<br>") %></td>
		</tr>

 
		<!-- 댓글 -->
		<tr>
			<td><b class="acount">댓글<span>0</span></b>
				<div class="alist" id="alist">댓글목록</div>
				<div class="aform input-group">
					<input type="text" id="nickname" class="form-control"
						style="width: 80px;" placeholder="닉네임"> <input type="text"
						id="content" class="form-control"
						style="width: 300px; margin-left: 10px;" placeholder="댓글메세지">

					<button type="button" id="btnasend" class="btn btn-info btn-sm"
						style="margin-left: 10px;">저장</button>
				</div> 
				<!-- 수정창 -->
				<div class="aupdateform input-group">
					<input type="hidden" id="idx"> <input type="text"
						id="unickname" class="form-control" style="width: 80px;"
						placeholder="닉네임"> <input type="text" id="ucontent"
						class="form-control" style="width: 300px; margin-left: 10px;"
						placeholder="댓글메세지">

					<button type="button" id="btnaUsend" class="btn btn-warning btn-sm"
						style="margin-left: 10px;">수정</button>
				</div></td>
		</tr>


		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-success btn-sm"
					onclick="location.href='index.jsp?main=smartboard/boardlist.jsp?num=<%=num%>&currentPage=<%=currentPage%>'">
					<i class="bi bi-list-ul"></i>목록으로
				</button>
				<button type="button" class="btn btn-outline-primary btn-sm"
					onclick="location.href='index.jsp?main=smartboard/updateform.jsp?num=<%=num%>&currentPage=<%=currentPage%>'">
					<i class="bi bi-pencil-square"></i>수정
				</button>
				<button type="button" class="btn btn-outline-danger btn-sm"
					onclick="funcdel(<%=num%>,<%=currentPage%>)">
					<i class="bi bi-trash"></i>삭제
				</button>
			</td>
		</tr>
	</table>
</div>


<body>

</body>
</html>