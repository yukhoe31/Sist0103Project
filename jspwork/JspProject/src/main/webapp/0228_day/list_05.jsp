<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
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
<style type="text/css">
	.mainimg{
		width:120px;
		height:160px;
		border: lpx solid gray;
	}
	
	.mainimg:hover{
		cursor: pointer;
		width:200px;
		height:260px;
		border: 5px inset magenta;
	}
</style>
</head>
<body>
	<%
    List<String> list = new ArrayList<>();
    list.add("yellow");
    list.add("gray");
    list.add("magenta");
    list.add("orange");
    list.add("blue");

    for(String color : list) {%>

	<div style="width:100px; height:50px; background-color:<%=color%>"><%=color%></div>
	<%}
%>

	<h3>이미지 배열로 출력</h3>

	<%
    String[] imgArr = {"1.jpg", "10.jpg", "11.jpg", "12.jpg", "5.jpg", "6.jpg", "8.jpg", "9.jpg", "2.jpg"};

    int n = 0;
%>

	<table>
		<%
    for (int i = 0; i < 3; i++) {%> // 행

		<tr height="100">
		<%
        for (int j = 0; j < 3; j++) {%> // 열
   
			<td><img alt="" src="../image/Food/<%=imgArr[n]%>" width="80" height="80"></td>
			<%
            n++;
		}
    %>
		</tr>
		<%
    }
%>
	</table>

	<h2>문제: 연예인사진 20개가 있다. 4행 5열로 출력해라</h2>
 	
 	<table>
 	<%
 		int a=0;
 		
 		for(int row=1;row<=4;row++){ //행
 			%>
 			<tr>
 				<%
 				for(int col=1;col<=5;col++){
 					a++;
 					%>
 					<td>
 						<img alt="" src="../image/연예인사진/연예인사진/<%=a %>.jpg" class="mainimg">
 					</td>
 				<%}
 				%>
 			</tr>
 		<%}
 	
 	
 	%>

	</table>
 	


</body>
</html>
