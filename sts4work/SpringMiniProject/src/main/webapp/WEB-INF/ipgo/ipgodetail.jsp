<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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

<title>상품 상세 정보</title>
</head>
<body>
<input type="hidden" num=${num }>
    <div style="width: 600px; margin: 50px 100px;">
        <h2>상품 상세 정보</h2>
        <table class="table table-bordered">
            <tr>
                <th>상품명</th>
                <td>${dto.sangpum}</td>
            </tr>
            <tr>
                <th>단가</th>
                <td><fmt:formatNumber value="${dto.price}" type="currency" /></td>
            </tr>
            <tr>
                <th>입고일</th>
                <td><fmt:formatDate value="${dto.ipgoday}" pattern="yyyy년 MM월 dd일 HH:mm" /></td>
            </tr>
            <tr>
                <th>상품 이미지</th>
                <td>
                    <c:if test="${dto.photoname!='no'}">
                        <c:forTokens var="pn" items="${dto.photoname}" delims="," begin="0" end="0">
                            <a href="../ipgoimage/${pn}"><img alt="" src="../ipgoimage/${pn}" style="width: 300px;"></a>
                        </c:forTokens>
                    </c:if>
                    <c:if test="${dto.photoname=='no'}">
                        <a href="../image/noimage.png"><img alt="" src="../image/noimage.png" style="width: 150px;"></a>
                    </c:if>
                </td>
            </tr>
        </table>
        <button type="button" class="btn btn-outline-info" onclick="history.back();">목록으로</button>
    </div>
</body>
</html>
