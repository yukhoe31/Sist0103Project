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



</head>

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

<body>
<div style="margin: 50px 100px; width: 500px;" >
	<form action="updateMember.jsp" method="post" enctype="multipart/form-data" >
	<!-- 항상 hidden타입의 num을 잊지마!! -->
	<input type="hidden" name="m_num" value="<%=m_num%>">
	
		<table class="table table-bordered">
			<caption align="top"><b>마이정보수정</b></caption>
			<tr>
				<td width="120" class="table-primary">아이디</td>
				<td >
				<b><%=dto.getM_id() %></b>
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
				
				<button type="submit" class="btn btn-info" id="btnsubmitupdate">회원정보수정</button>
				</td>
			</tr>
			
		</table>
	</form>
	
	 <img alt="" src="../upload/<%=dto.getM_photo()%>" id="preshow">
</div>
</body>
</html>