<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
  <div style="margin: 50px 100px;">
     <form action="insert" method="post" enctype="multipart/form-data">
        <table class="table table-bordered" style="width: 500px;">
           <caption align="top"><b>회원게시판</b></caption>
           <tr>
             <th class="table-light">제목</th>
             <td>
               <input type="text" name="subject" class="form-control"
               required="required" style="width: 300px;">
             </td>
           </tr>
           
           <tr>
             <th class="table-light">업로드</th>
             <td>
               <input type="file" name="upload" class="form-control" style="width: 200px;">
               
             </td>
           </tr>
           <tr>
             <td colspan="2">
               <textarea style="width: 490px; height: 150px;"
               class="form-control" name="content" required="required"></textarea>
             </td>
           </tr>
           
           <tr>
             <td colspan="2" align="center">
                <button type="submit" class="btn btn-outline-info"
                style="width: 100px;">등록</button>
                <button type="button" class="btn btn-outline-info"
                style="width: 100px;" onclick="location.href='list'">목록</button>
             </td>
           </tr>
        </table>
     </form>
  </div>
</body>
</html>