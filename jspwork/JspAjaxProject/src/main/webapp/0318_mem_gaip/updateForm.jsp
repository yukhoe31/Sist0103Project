<%@page import="mem_gaip.model.MemgaipDto"%>
<%@page import="mem_gaip.model.MemgaipDao"%>
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
<script type="text/javascript">
	function openId() {
		window.open("idSearch.jsp","idcheck","left='100px',top='100px',width='400px',height='200px'");
		
	}
</script>


<%
  String m_num=request.getParameter("m_num");
  MemgaipDao dao=new MemgaipDao();
  MemgaipDto dto=dao.getOneMember(m_num);
%>

<title>Insert title here</title>


<style type="text/css">
   #preshow{
     position: absolute;
     left: 650px;
     top: 100px;
     height: 200px;
   }
</style>


<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader(); 
        reader.onload = function (e) {
       
            $('#preshow').attr('src', e.target.result);
            
        }                   
        reader.readAsDataURL(input.files[0]);
       
    }
}
</script>



</head>
<body>
<div style="margin: 50px 100px; width: 500px;" >
	<form action="updateMember.jsp" method="post" enctype="multipart/form-data" >
	
		<table class="table table-bordered">
			<caption align="top"><b>회원가입</b></caption>
			<tr>
				<td width="120" class="table-primary">아이디</td>
				<td >
				<%=dto.getM_id() %>
				</td>
			</tr>
			
			<tr>
				<td width="120" class="table-primary">비밀번호</td>
				<td>
					<input type="password" class="form-control"
					style="width: 120px;" name="m_pass" required="required" value="<%=dto.getM_pass()%>">
				</td>
			</tr>
			
			<tr>
				<td width="120" class="table-primary">회원명</td>
				<td>
					<input type="text" class="form-control"
					style="width: 120px;" name="m_name" required="required" value="<%=dto.getM_name()%>">
				</td>
			</tr>
			
			<tr>
				<td width="120" class="table-primary">사진</td>
				<td>
					<input type="file" class="form-control"
					style="width: 200px;" name="m_photo" >
				</td>
			</tr>
			
			<tr>
				<td width="120" class="table-primary">핸드폰</td>
				<td>
					<input type="text" class="form-control"
					style="width: 180px;" name="m_hp" required="required" value="<%=dto.getM_hp()%>">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="hidden" name="m_num" value="<%=m_num%>">
				<button type="submit" class="btn btn-info" id="btnsubmitupdate">회원정보수정</button>
				</td>
			</tr>
			
		</table>
	</form>
	
	 <img alt="" src="../upload/<%=dto.getM_photo()%>" id="preshow">
</div>
</body>
</html>