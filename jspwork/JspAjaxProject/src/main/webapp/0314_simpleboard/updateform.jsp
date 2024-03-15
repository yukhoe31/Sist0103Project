<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
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
  //num을 읽어서 form에 hidden으로 넣는다.
  String num=request.getParameter("num");
  SimpleBoardDao dao = new SimpleBoardDao();
  SimpleBoardDto dto = dao.getContent(num);
%>
<body>

<div style="margin: 50px 100px; width: 500px;">
    <form action="updateaction.jsp" method="post">
    <input type="hidden" name="num" value="<%=num %>">
      <table class="table table-bordered">
         <tr>
           <th width="100" class="table-info">작성자</th>
           <td>
             <input type="text" name="writer" class="form-control"
             style="width: 120px;" required="required" value="<%=dto.getWriter()%>">
           </td>
         </tr>
         
         <tr>
           <th width="100" class="table-info">제목</th>
           <td>
             <input type="text" name="subject" class="form-control"
             style="width: 300px;" required="required"  value="<%=dto.getSubject()%>">
           </td>
         </tr>
     
         <tr>
           <td colspan="2">
             <textarea style="width: 480px; height: 100px;"
             class="form-control" name="content" required="required" > <%=dto.getContent() %> </textarea>
           </td>
         </tr>
         
         <tr>
           <td colspan="2" align="center">
           <!-- type이 image submit일경우 기본기능이  submit-->
             <input type="image" src="../image/logoImg/submit.png" style="width: 80px;">
             <input type="image" src="../image/logoImg/list.png" style="width: 50px;" onclick="location.href='boardlist.jsp'">
           </td>
         </tr>
      </table>
    
    </form>
    
    
</div>

</body>
</html>