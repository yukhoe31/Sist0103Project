<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Diphylleia&family=Dongle&family=Gowun+Dodum&family=Nanum+Pen+Script&family=Orbit&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>

<div style="margin: 50px 100px; width: 600px;">
    <form action="shop/addaction.jsp" method="post" enctype="multipart/form-data">
        <table class="table table-bordered">
            <caption align="top"><b>상품등록</b></caption>
            <tr>
                <td style="width: 150px;" class="table-light">
                    <b>카테고리</b>
                </td>
                <td>
                    <select style="width: 200px;" class="form-control" required="required" name="category">
                        <option value="인형" selected="selected">인형</option>
                        <option value="의상">의상</option>
                        <option value="생활용품">생활용품</option>
                        <option value="악세사리">악세사리</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td style="width: 150px;" class="table-light"><b>상품명</b></td>
                <td>
                    <input type="text" name="sangpum" class="form-control" style="width: 300px;" placeholder="상품명 입력">
                </td>
            </tr>

            <tr>
                <td style="width: 150px;" class="table-light"><b>상품이미지</b></td>
                <td>
                    <input type="file" name="photo" class="form-control" style="width: 300px;">
                </td>
            </tr>

            <tr>
                <td style="width: 150px;" class="table-light"><b>상품가격</b></td>
                <td>
                    <input type="text" name="price" class="form-control" style="width: 120px;" placeholder="가격 입력">
                </td>
            </tr>

            <tr>
                <td style="width: 150px;" class="table-light"><b>입고일</b></td>
                <td>
                    <% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String day = sdf.format(new Date());
                    %>

                    <input type="date" name="ipgoday" class="form-control" style="width: 200px;" required="required" value="<%=day %>">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-info" style="width: 100px;">상품저장</button>
                    <button type="button" class="btn btn-info" style="width: 100px;" onclick="location.href='index.jsp?main/shop/shoplist.jsp'">상품목록</button>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>