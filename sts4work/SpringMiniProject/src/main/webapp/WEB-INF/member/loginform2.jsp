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

<title>CODE CONNECT - 회원가입</title>
<style>
    body {
        font-family: 'Noto Sans KR', sans-serif;
        background-color: #ffffff;
    }
    .signup-form {
        margin: 50px auto;
        width: 400px;
        padding: 20px;
        border-radius: 10px;
        background-color: #f5f5f5;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .signup-form h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #007bff;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .btn-primary {
        width: 100%;
    }
</style>
</head>
<body>

<div class="signup-form">
    <h2>기업 회원가입</h2>
    <form action="signupprocess" method="post">
        <div class="form-group">
            <label for="c_id">아이디 (기업 대표 이메일주소)</label>
            <input type="email" class="form-control" id="c_id" name="c_id" required placeholder="아이디">
        </div>
        <div class="form-group">
            <label for="c_pass">패스워드</label>
            <input type="password" class="form-control" id="c_pass" name="c_pass" required placeholder="패스워드">
        </div>
        <div class="form-group">
            <label for="c_name">기업명</label>
            <input type="text" class="form-control" id="c_name" name="c_name" required placeholder="기업명">
        </div>
        <div class="form-group">
            <label for="c_reginum">사업자 등록 번호</label>
            <input type="text" class="form-control" id="c_reginum" name="c_reginum" required placeholder="사업자 등록 번호">
        </div>
        <div class="form-group">
            <label for="c_local">대표 지역</label>
            <input type="text" class="form-control" id="c_local" name="c_local" required placeholder="대표 지역">
        </div>
        <div class="form-group">
            <label for="c_category">산업군</label>
            <select class="form-control" id="c_category" name="c_category" required>
                <option value="">산업군 선택</option>
                <option value="IT">IT</option>
                <option value="제조">제조</option>
                <option value="건설">건설</option>
                <option value="서비스">서비스</option>
                <option value="금융">금융</option>
                <option value="교육">교육</option>
                <option value="의료">의료</option>
                <option value="기타">기타</option>
            </select>
        </div>
        <div class="form-group">
            <label for="c_people">직원 수</label>
            <input type="text" class="form-control" id="c_people" name="c_people" required placeholder="직원 수">
        </div>
        <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
</div>

</body>
</html>
