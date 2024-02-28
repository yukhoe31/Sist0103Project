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
	<h2>데이터 여러개 전송하기</h2>
	<form action="formWrite_01.jsp" method="post">
		<table class="table table-bordered" style="width: 400px">
			<tr>
				<th width="100" class="table-info">이름</th>
				<td><input type="text" name="name" placeholder="이름"
					required="required" class="form-control" style="width: 150px">
				</td>		
			</tr>
			
			<tr>
				<th width="100" class="table-info">비밀번호</th>
				<td><input type="text" name="pass" placeholder="비밀번호"
					required="required" class="form-control" style="width: 150px">
				</td>		
			</tr>
			
			<tr>
				<th width="100" class="table-info">운전면허</th>
				<td><input type="checkbox" name="cblic" text="운전면허"
					required="required" style="width: 150px">
				</td>		
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-success" value="전송" style="width: 100px">
					<input type="reset" class="btn btn-warning" value="초기화">
					
				</td>	
		</table>
	</form>
</body>
</html>