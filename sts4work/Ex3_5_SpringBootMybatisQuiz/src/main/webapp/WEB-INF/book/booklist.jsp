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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> <!-- Include SweetAlert2 -->

<title>Insert title here</title>
</head>
<body style="margin: 50px 50px;">

    <div style="margin: 100px 100px;">
        <button type="button" class="btn btn-outline-info"
            onclick="location.href='addform'">도서등록</button>
    </div>

    <c:if test="${totalCount == 0}">
        <div class="alert alert-info">
            <b>저장된 정보가 없습니다.</b>
        </div>
    </c:if>

    <c:if test="${totalCount > 0}">
        <div class="alert alert-danger">
            <b>총 ${totalCount }개의 도서가 판매중입니다</b>
        </div>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>이미지</th>
                    <th>책 제목</th>
                    <th>저자</th>
                    <th>출판사</th>
                    <th>가격</th>
                    <th>입고일</th>
                    <th>편집</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${list }" varStatus="i">
                    <tr>
                        <td align="center">
                            <c:if test="${book.bookimage == 'no'}">
                                <img src="/photo/noimage.jpg" alt="이미지" width="100">
                            </c:if>
                            <c:if test="${book.bookimage != 'no'}">
                                <img src="/photo/${book.bookimage}" alt="이미지" width="100">
                            </c:if>
                        </td>
                        <td>${book.bookname}</td>
                        <td>${book.writer}</td>
                        <td>${book.bookcompany}</td>
                        <td>${book.bookprice}</td>
                        <td>${book.ipgday}</td>
                        <td>
                            <button type="button" class="btn btn-outline-primary"
                                onclick="location.href='updateform?num=${book.num}'">수정</button>
                            <button type="button" class="btn btn-outline-danger"
                                onclick="confirmDelete(${book.num})">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody> 
        </table>
    </c:if>

<script>
function confirmDelete(num) {
    Swal.fire({
        title: '정말로 삭제하시겠습니까?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: 'red',
        cancelButtonColor: 'green',
        confirmButtonText: '예, 삭제합니다!',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            location.href = 'delete?num=' + num;
        }
    })
}
</script>

</body>
</html>
