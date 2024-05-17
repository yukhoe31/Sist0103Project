<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<style>
body {
	font-family: 'Noto Sans KR', sans-serif;
	background-color: #f8f9fa;
	margin: 20px;
}

.container {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.title {
	font-family: 'Noto Serif KR', serif;
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 20px;
}

.info {
	font-size: 14px;
	color: #6c757d;
	margin-bottom: 20px;
}

.content {
	font-family: 'Noto Serif KR', sans-serif;
	font-size: 18px;
	margin-bottom: 20px;
}

.image img {
	max-width: 300px;
	height: auto;
	border-radius: 8px;
}

.actions {
	margin-top: 20px;
}

.actions button {
	margin-right: 10px;
}
</style>

<script type="text/javascript">
function confirmDelete(url) {
    Swal.fire({
        title: '정말로 삭제하시겠습니까?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '예',
        cancelButtonText: '아니오'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = url;
        }
    });
}
</script>


</head>



<body>

	<div class="container">
		<input type="hidden" name="num" value="${dto.num }">

		<div class="title">제목 : ${subject }</div>
		<div class="info">
			<i class="bi bi-person"></i> 작성자 : ${writer }<br> <i
				class="bi bi-calendar"></i> 작성일 : ${writeday }
		</div>
		<div class="content">내용 : ${content}</div>
		<div class="image">
			<img alt="" src="../save/${photo }">
		</div>
		<div class="actions">
			<button type="button" class="btn btn-primary"
				onclick="location.href='updateform?num=${dto.num}'">수정</button>
			<button type="button" class="btn btn-danger"
				onclick="confirmDelete('delete?num=${dto.num}')">삭제</button>
			<button type="button" class="btn btn-info" style="width: 100px;"
				onclick="location.href='list'">목록</button>

		</div>
	</div>


</body>
</html>
