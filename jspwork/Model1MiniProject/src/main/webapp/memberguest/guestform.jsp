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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Insert title here</title>

<style type="text/css">
.bi-camera{

color: orange;
size: 20pt;
}


</style>


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
<body>

<img id="showimg" style="position: absolute; left: 800px; top: 100px; max-width: 200px;">


<div style="margin: 50px 100px; width: 600px;">
	<form action="memberguest/guestaction.jsp" method="post" enctype="multipart/form-data">
		<table class="table table-bordered">
			<caption align="top">
				<b>방명록 등록</b>
				<i class="bi bi-camera camera" style="font-size: 20pt"></i>
				<input type="file" name="photo" id="photo" style="visibility: hidden;"
				onchange="readURL(this)">
			</caption>
			
			<tr>
				<td>
					<textarea style="width: 500px; height: 100px;"
					name="content" class="form-control"
					required="required"></textarea>
				</td>
				
				<td>
					<button type="submit" class="btn btn-info"
					style="width: 100px; height: 100px; font-style: bold;">등록</button>
				</td>
			</tr>

		</table>	

		
	</form>
	
	
</div>
</body>
</html>