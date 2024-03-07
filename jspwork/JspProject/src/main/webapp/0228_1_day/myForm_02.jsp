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
	<form action="formWrite_02.jsp" method="post">
		<table class="table table-bordered" style="width:400px;">
			<tr>
				<th width="170">1순위</th>
				<td>
					<select name="city" size="form-control" style="width:100px;">
						<option value="서울">서울</option>
						<option value="경기">경기</option>
						<option value="인천">인천</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="부산">부산</option>
						<option value="제주">제주</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<th width="170">2순위</th>
				<td>
					<select name="city2" size="form-control" style="width:100px;"
					multiple="multiple">
						<option value="서울">서울</option>
						<option value="경기">경기</option>
						<option value="인천">인천</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="부산">부산</option>
						<option value="제주">제주</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-success" value="전송" style="width: 100px">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>