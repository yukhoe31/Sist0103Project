<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 50px 100px; width: 800px;">
		<div>
		<button type="button" class="btn btn-info"
			onclick="location.href='writeform'">회원가입</button>

	
			<button type="button" class="btn btn-info"
				onclick="location.href='../'">처음화면으로</button>

		</div>
		<br> <br>
		<c:if test="${totalCount==0 }">
			<h5 class="alert alert-info">저장된 회원정보가 없습니다</h5>
		</c:if>
		<c:if test="${totalCount>0 }">
			<h5 class="alert alert-info">총 ${totalCount }개의 회원정보가 있습니다</h5>

			<hr>
			<table class="table table-bordered">
				<tr class="table-success">
					<th width="80">번호</th>
					<th width="180">이름</th>
					<th width="120">아이디</th>
					<th width="120">전화번호</th>
					<th width="180">가입일</th>
					<th width="180">편집</th>
				</tr>

				<c:forEach var="dto" items="${list }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td>${dto.name }</td>
						<td>${dto.id }</td>
						<td>${dto.hp }</td>
						<td>${dto.gaipday }</td>
						<td>
							<button type="button" class="btn btn-outline-info btn-sm"
								onclick="location.href='updatememberform?num=${dto.num}'">수정</button>
							<!-- Add SweetAlert confirmation before deletion -->
							<button type="button" class="btn btn-outline-info btn-sm"
								onclick="confirmDelete(${dto.num})">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>

	<script>
    // Function to display confirmation dialog before deletion
    function confirmDelete(num) {
        Swal.fire({
            title: '정말로 삭제하시겠습니까?',
            text: "삭제된 데이터는 복구할 수 없습니다!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '예',
            cancelButtonText: '아니요'
        }).then((result) => {
            if (result.isConfirmed) {
                // If user confirms, redirect to delete servlet with the car number
                window.location.href = 'delete?num=' + num;
            }
        });
    }
</script>


</body>
</html>