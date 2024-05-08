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
<div style="margin: 50px 100px; width: 800px;" >
<button type="button" class="btn btn-info"
onclick="location.href='writeform'" style="margin-left: 600px;">자동차정보입력</button><br><br>

  <c:if test="${totalCount==0 }">
    <h5 class="alert alert-info">저장된 차의 정보가 없습니다</h5>
  </c:if>
  <c:if test="${totalCount>0 }">
     <h5 class="alert alert-info">총 ${totalCount }개의 자동차정보가 있습니다</h5>
     
     <hr>
     <table class="table table-bordered">
        <tr class="table-success">
          <th width="80">번호</th>
          <th width="280">자동차명</th>
          <th width="120">차량색상</th>
          <th width="120">차량가격</th>
          <th width="180">구입일</th>
          <th width="180">편집</th>
        </tr>
     </table>
  </c:if>
</div>
</body>
</html>