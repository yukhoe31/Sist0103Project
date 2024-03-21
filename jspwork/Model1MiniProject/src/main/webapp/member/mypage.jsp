<%@page import="java.util.Random"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MemberDao"%>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Insert title here</title>

<style type="text/css">
	#mainimg{
		width: 150px;
		height: 150px;
		border-radius: 100px;
		margin-top: 30px;
		margin-left: 20px;
		border: 1px solid lightgray;

	}

</style>

<script type="text/javascript">
function delfunc(num) {
	
	$("#delnum").val(num);
	$("#myModal").modal('show');
	
	//삭제버튼이벤트
	$("button.btndel").click(function() {
		
		//num,pass읽기
		var num=$("#delnum").val();
		var pass= $("#delpass").val();
		
		//alert(num + "," +pass);
		
		//삭제파일 호출
		location.href = "member/deletemypage.jsp?num="+num +"&pass=" +pass;
	}) 
	
}

</script>


</head>

<%
MemberDao dao = new MemberDao();

List<MemberDto> list = dao.getAllMembers();


SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String[] imageUrls = {
    "image/miniproject_img/monsterball.png",
    "image/miniproject_img/pkmn_2.png",
    "image/miniproject_img/pkmn_3.png",
    "image/miniproject_img/pkmn_4.png",
    "image/miniproject_img/pkmn_5.png",
    "image/miniproject_img/pkmn_6.png",
    "image/miniproject_img/pkmn_7.png",
    "image/miniproject_img/pkmn_8.png",
    "image/miniproject_img/pkmn_9.png",
    "image/miniproject_img/pkmn_10.png",
    // 다른 이미지들 추가
};
Random random = new Random();
%>


<body>
	<div style="margin: 100px 200px; width: 800px;">
		<table class="table table-bordered">
			<%
            for (MemberDto dto : list) {
            %>
			<tr>
				<td rowspan="6" align="center" valign="middle" style="width: 200px;">
					<img src="<%= imageUrls[random.nextInt(imageUrls.length)] %>"
					height="150px;" id="mainimg2">
					
				</td>

				<td style="width: 300px;">회원명: <%=dto.getName() %></td>

				<td rowspan="6" style="width: 150px;" align="center" valign="middle">
					<button type="button" class="btn btn-outline-info">수정</button>
					<input type="hidden" pass="<%=dto.getPass() %>">
					<button type="button" class="btn btn-outline-danger"
					onclick="delfunc('<%=dto.getNum()%>')">탈퇴</button>
					
				</td>
			</tr>
			<tr>
				<td>아이디: <%=dto.getId() %></td>
			</tr>
			<tr>
				<td>이메일: <%=dto.getEmail() %></td>
			</tr>
			<tr>
				<td>핸드폰: <%=dto.getHp() %></td>
			</tr>
			<tr>
				<td>주소: <%=dto.getAddr() %></td>
			</tr>
			<tr>
				<td>가입일: <%=sdf.format(dto.getGaipday())%></td>
			</tr>
			<%}
            %>
			</tr>
		</table>
	</div>


	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">삭제 확인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body d-inline-flex">		
				    <input type="hidden" id="delnum">	
					<b>삭제비밀번호: </b>
					<input type="password" id="delpass" class="form-control" style="width: 120px;">
					
				</div>
			
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger btndel"
					data-bs-dismiss="modal">삭제</button>
				</div>

			</div>
		</div>
	</div>
	
	
</body>
</html>
