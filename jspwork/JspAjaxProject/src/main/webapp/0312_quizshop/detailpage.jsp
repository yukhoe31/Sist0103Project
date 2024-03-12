<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="quizshop.model.QuizShopDto"%>
<%@page import="quizshop.model.QuizShopDao"%>
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
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
   function funcdel(num){
	   var yes=confirm("정말 삭제하시겠습니가?");
	   if(yes){
		   location.href="deleteaction.jsp?num="+num;
	   }
   }
</script>
</head>
<body>

	<%
	//num읽기
	String num=request.getParameter("num");
    //dao
    QuizShopDao dao=new QuizShopDao();
    //num에 해당 dto얻기
    QuizShopDto dto=dao.getOneQuiz(num);
    
  
%>


	<div style="margin: 50px 100px;">
		<table class="table table-bordered" style="width: 600px;">
			<caption align="top">
				<b><%=dto.getSang_name()%> 상품 디테일</b>
			</caption>
			<tr>
				<th>상품명</th>
				<td><%=dto.getSang_name() %></td>
			</tr>
			<tr>
				<th>상품이미지</th>
				<td><img src="../image/쇼핑몰사진/<%=dto.getPhoto()%>.jpg"></td>
				
			</tr>
			<tr>
				<th>가격</th>
				<td><%=dto.getPrice()%>원</td>
			</tr>
			<tr>
				<th>입고일</th>
				<td><%=dto.getIpgoday()%></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><%=dto.getWriteday()%></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<button type="button" class="btn btn-info"
						onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
					<button type="button" class="btn btn-danger"
						onclick="funcdel('<%=dto.getNum()%>')">삭제</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='shoplist.jsp'">목록</button>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>