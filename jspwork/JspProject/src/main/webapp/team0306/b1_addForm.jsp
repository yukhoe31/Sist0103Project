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
<div style="margin: 30px 50px;">
	<form action="b2_addAction.jsp" method="post">
		<table class="table table-bordered" style="width: 300px">
		<caption align="top"><b>팀회원 정보 추가</b></caption>
		<tr>
			<th class="table-primary">이름</th>
				<td>
					<input type="text" name ="name" class="form-control" required="required" style="width: 120px;">
				</td>
		</tr>
		<tr>
			<th class="table-primary">운전면허</th>
				<td>
					<input type="checkbox" name ="driver" >운전면허
				</td>
		</tr>
		<tr>
			<th class="table-primary">주소</th>
				<td>
					<input type="text" name ="addr" class="form-control" required="required" style="width: 200px;">
				</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" class="btn btn-primary" value="팀회원 정보 저장">
			</td>
		</tr>
		
		
		</table>
	</form>
</div>
</body>
</html>


