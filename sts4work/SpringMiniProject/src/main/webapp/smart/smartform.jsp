<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
<c:set var="root" value="<%=request.getContextPath() %>"/>


</head>
<body>

<div style="margin: 50px 100px; width: 500px;">
<form action="insert" method="post" enctype="multipart/form-data">
  <table class="table table-bordered">
     <caption align="top"><b>상품등록</b></caption>
     <tr>
       <th class="table-light">상품명</th>
         <td>
           <input type="text" name="sangpum" class="form-control"
           placeholder="상품명" style="width: 150px;" required="required" >
         </td>
     </tr>
     <tr>
       <th class="table-light">색상</th>
         <td>
           <input type="color" name="color" class="form-control"
           value="#ffddcc" style="width: 200px;" required="required">
         </td>
     </tr>
     <tr>
       <th class="table-light">단가</th>
         <td>
           <input type="text" name="price" class="form-control"
           placeholder="단가"  style="width: 200px;" required="required">
         </td>
     </tr>
     
     <tr>
       <th class="table-light">입고일</th>
         <td>
           <input type="date" name="ipgoday" class="form-control"
           value="2024-01-01"  style="width: 200px;" required="required">
         </td>
     </tr>
     
     
     <tr>
   		<th class="table-light">글 내용</th>
         <td>
           <textarea name="content" id="content"
           required="required" style="width: 100%;height: 300px; display: none;"></textarea>
         </td>
     </tr>
     
     <tr>
       <td colspan="2" align="center">
         <button type="submit" class="btn btn-success">DB저장</button>
         <button type="button" class="btn btn-success"
         onclick="location.href='list'">목록</button>
       </td>
     </tr>
  </table>
</form>
</div>

<!-- 스마트게시판에 대한 스크립트 코드 넣기 -->




</body>
</html>