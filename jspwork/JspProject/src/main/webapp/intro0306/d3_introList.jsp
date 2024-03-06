
<%@page import="intro.model.IntroDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="intro.model.IntroDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<%
  //db목록 가져오기
    IntroDao dao=new IntroDao();
	ArrayList<IntroDto>list=dao.getAllTeams();

%>
<body>
<div style="margin: 30px 50px;">
    <button type="button" class="btn btn-success"
    onclick="location.href='d1_addForm.jsp'">팀원추가</button>
    
    <br><br>
    <table class="table table-bordered" style="width: 900px;">
       <tr class="table-primary">
          <th width="60">번호</th>
          <th width="80">이름</th>
          <th width="60">나이</th>
          <th width="100">생년월일</th>
          <th width="100">고향</th>
          <th width="120">취미</th>
          <th width="120">비고</th>
          
       </tr>
       
       <%
         for(int i=0;i<list.size();i++)
         {
        	 IntroDto dto=list.get(i);  //i번지의 dto를 꺼낸다
        	 %>
        	 
        	 <tr>
        	   <td><%=i+1 %></td>
        	   <td><%=dto.getName() %></td>
        	   <td><%=dto.getAge() %></td>
        	   <td><%=dto.getBirthday() %></td>
        	   <td><%=dto.getHometown() %></td>
        	   <td><%=dto.getHobby() %></td>
   			   <td><%=dto.getMemo() %></td>
        	 </tr>
         <%}
       %>
       
       
    </table>
    
</div>
</body>
</html>

