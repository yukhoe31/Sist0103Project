<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    rel="stylesheet">
<link
    href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
    rel="stylesheet">
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>Insert title here</title>
</head>
<body>
    <div style="width: 600px; margin: 50px 100px;">
        <b>${totalCount }개의 상품이 있습니다</b>

        <table class="table table-bordered">
            <caption align="top">
                <!-- 로그인한 사람중에서 admin만 회원정보 볼수 있음 -->
                <c:if
                    test="${sessionScope.loginok!=null and sessionScope.myid=='admin'}">
                    <b> <span style="float: right;"><button type="button"
                                class="btn btn-outline-success"
                                onclick="location.href='writeform'">상품추가</button></span>
                    </b>
                </c:if>
            </caption>

            <c:forEach var="dto" items="${list }">
                <tr>
                    <td width="250" rowspan="4">
                        <c:if test="${dto.photoname!='no' }">
                            <c:forTokens var="pn" items="${dto.photoname }" delims=","
                                begin="0" end="0">
                                <a href="../ipgoimage/${pn }"> <img alt=""
                                    src="../ipgoimage/${pn }" style="width: 150px;">
                                </a>
                            </c:forTokens>
                        </c:if>
                        <c:if test="${dto.photoname=='no' }">
                            <a href="../image/noimage.png"> <img alt=""
                                src="../image/noimage.png" style="width: 150px;">
                            </a>
                        </c:if>
                    </td>
                    <td><b>상품명: ${dto.sangpum }</b></td>
                </tr>
                <tr>
                    <td><b>단가: <fmt:formatNumber value="${dto.price }"
                                type="currency" /></b></td>
                </tr>
                <tr>
                    <td><b>입고일: <fmt:formatDate value="${dto.ipgoday }"
                                pattern="yyyy년 MM월 dd일 HH:mm" /></b></td>
                </tr>
                <tr>
                    <td>
                        <!-- 관리자 로그인 경우만보이기 -->
                        <c:if test="${sessionScope.loginok!=null and sessionScope.myid=='admin'}">
                            <button type="button" class="btn btn-outline-info"
                                onclick="location.href='updateform?num=${dto.num}'">수정</button>
                            <button type="button" class="btn btn-outline-info"
                                onclick="confirmDelete('${dto.num}')">삭제</button>
                        </c:if>

                        <button type="button" class="btn btn-outline-info"
                            onclick="location.href='detail?num=${dto.num}'">자세히보기</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script>
        function confirmDelete(num) {
            Swal.fire({
                title: '정말로 삭제하시겠습니까?',
                text: "이 작업은 되돌릴 수 없습니다!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '예, 삭제합니다!',
                cancelButtonText: '아니오, 취소합니다'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: 'delete',
                        type: 'POST',
                        data: { num: num },
                        success: function(response) {
                            Swal.fire(
                                '삭제됨!',
                                '상품이 삭제되었습니다.',
                                'success'
                            ).then(() => {
                                location.reload();
                            });
                        },
                        error: function(xhr, status, error) {
                            Swal.fire(
                                '삭제 실패!',
                                '상품 삭제 중 오류가 발생했습니다.',
                                'error'
                            );
                        }
                    });
                }
            })
        }
    </script>
</body>
</html>
