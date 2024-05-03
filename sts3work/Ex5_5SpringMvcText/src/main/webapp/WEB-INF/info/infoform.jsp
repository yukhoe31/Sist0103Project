<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <form action="result" method="post">
        <table class="table table-bordered" style="width: 400px;">
            <caption align="top"><b>**폼에서 입력받을 정보**</b></caption>
            
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" class="form-control" style="width: 130px;">
                </td>
            </tr>

            <tr>
                <th>색상</th>
                <td>
                    <input type="color" name="color" class="form-control" style="width: 160px;">
                </td>
            </tr>
            
            <tr>
                <th>취미</th>
                <td>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="hobby" id="hobby1" value="게임">
                        <label class="form-check-label" for="hobby1">게임</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="hobby" id="hobby2" value="여행">
                        <label class="form-check-label" for="hobby2">여행</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="hobby" id="hobby3" value="영화감상">
                        <label class="form-check-label" for="hobby3">영화감상</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="hobby" id="hobby4" value="독서">
                        <label class="form-check-label" for="hobby4">독서</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="hobby" id="hobby5" value="산책">
                        <label class="form-check-label" for="hobby5">산책</label>
                    </div>
                </td>
            </tr>
            
            <tr>
                <th>가장 재미있는 언어선택</th>
                <td>
                    <select class="form-select" name="lang" style="width: 160px;">
                        <option value="java">Java</option>
                        <option value="html">HTML</option>
                        <option value="ajax">Ajax</option>
                        <option value="spring">Spring</option>
                    </select>
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
