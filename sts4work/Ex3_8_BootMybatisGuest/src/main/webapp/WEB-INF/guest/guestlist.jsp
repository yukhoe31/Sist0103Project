<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		
		$("i.photo").click(function() {
			
			$("#photos").trigger("click");
			
		})
		
		$("#btnsave").click(function() {
			
			if($("#nick").val()==''){
				alert("닉네임 입력바람");
				return;
			}
			
			if($("#pass").val()==''){
				alert("비밀번호 입력바람");
				return;
			}
			
			if($("#content").val()==''){
				alert("내용을 입력바람");
				return;
			}
			
			//데이터 전송
			var s=$("#frm").serialize();
			
			//insert ajax
			$.ajax({
				
				
			})
			
		});
		
	})

</script>

</head>
<body>

<div>
	<h4>원하는 사진들을 등록하세요
	<input type="file" id="photos" name="photos" multiple="multiple" style="display: none;">
	<i class="bi bi-camera-fill fs-2" style="font-size:30px;"></i></h4>

	<form action="" id="frm">
		<table class="table table-bordered" style="width: 700px;">
			<tr>
				<th width="80">닉네임</th>
				<td>
					<input type="text" class="form-control input-sm"
					style="width: 100px;" id="nick" name="nick">
				</td>	
				<th width="100">비밀번호</th>
				<td>
					<input type="password" class="form-control input-sm"
					style="width: 100px;" id="pass" name="pass">
				</td>			
			</tr> 
			<tr>
				<td colspan="4">
					<textarea style="width:550px; height: 100px;"
					class="form-control" id="content" name="content"></textarea>	
					<button type="button" class="btn btn-danger"
					id="btnsave" style="width: 80px;height: 80px; margin-left:560px;margin-top: 5px;">저장</button>			
				</td>
			</tr>
		</table>
	</form>



</div>

</body>
</html>