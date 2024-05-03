<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
  <div style="margin: 50px 50px;">
     <form action="info" method="post">
      <table class="table table-bordered" style="width: 400px;">
         <tr>
           <th>사원명</th>
           <td>
             <input type="text" name="s_name" class="form-control"
             style="width: 130px;">
           </td>
         </tr>
         
         <tr>
           <th>급여</th>
           <td>
             <input type="text" name="pay" class="form-control"
             style="width: 160px;">
           </td>
         </tr>
         <tr>
           <th>나이</th>
           <td>
             <input type="text" name="s_age" class="form-control"
             style="width: 130px;">
           </td>
         </tr>
         
         <tr>
           <th>부서</th>
           <td>
             <input type="text" name="s_buseo" class="form-control"
             style="width: 160px;">
           </td>
         </tr>
         
         <tr>
           <td colspan="2" align="center">
             <button type="submit" class="btn btn-info">데이타전송</button>
           </td>
         </tr>
      </table>
   </form>
  </div>
</body>
</html>