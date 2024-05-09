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
  <div>
     <h2>제목: ${title }</h2>
     <c:if test="${fileName=='no' }">
       <h2>업로드한 파일없음!!!</h2>
     </c:if>
     <c:if test="${fileName!='no' }">
       <img alt="" src="../photo/${fileName }" style="max-width: 200px;">
     </c:if>
     
     <h2>업로드한 이미지명: ${fileName }</h2>
     <h2>업로드할 실제경로:${path }</h2>
  </div>
</body>
</html>