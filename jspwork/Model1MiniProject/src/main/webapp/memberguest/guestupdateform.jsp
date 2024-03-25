<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
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

<script type="text/javascript">
$(function() {
	$("i.camera").click(function() {
		$("#photo").trigger("click");
	})
})

function readURL(input, expression) {
	
	if(input.files && input.files[0]){
		var reader = new FileReader();
		
		reader.onload = function (e) {
			$("#showimg").attr('src', e.target.result);
			
		}
		reader.readAsDataURL(input.files[0]);
	}
	
}


</script>



</head>

<%

//num,currentPage
String num = request.getParameter("num");
String currentPage = request.getParameter("currentPage");

GuestDao dao = new GuestDao();
GuestDto dto = dao.getData(num);

%>


<body>

<img id="showimg" style="position: absolute; left: 800px; top: 100px; max-width: 200px;"
src="<%=(dto.getPhotoname()==null?"":"save/"+dto.getPhotoname()) %>" >


<div style="margin: 50px 100px; width: 600px;">
	<form action="memberguest/guestupdateaction.jsp" method="post" enctype="multipart/form-data">
		<!-- num,currentPage도 hiddend처리 -->
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="currentPage" value="<%=currentPage%>">
		<table class="table table-bordered">
			<caption align="top">
				<b>방명록 수정</b>
				<i class="bi bi-camera camera" style="font-size: 20pt"></i>
				<input type="file" name="photo" id="photo" style="visibility: hidden;"
				onchange="readURL(this)">
			</caption>
			
			<tr>
				<td>
					<textarea style="width: 500px; height: 100px;"
					name="content" class="form-control"
					required="required"><%=dto.getContent() %></textarea>
				</td>
				
				<td>
					<button type="submit" class="btn btn-info"
					style="width: 100px; height: 100px; font-style: bold;">수정</button>
				</td>
			</tr>

		</table>	

		
	</form>
	
	
</div>



</body>
</html>