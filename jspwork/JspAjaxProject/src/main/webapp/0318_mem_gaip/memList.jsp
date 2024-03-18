<%@page import="java.text.SimpleDateFormat"%>
<%@page import="mem_gaip.model.MemgaipDto"%>
<%@page import="java.util.List"%>
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
<title>Insert title here</title>
<script type="text/javascript">
   function funcdel(m_num){
	   var yes=confirm("정말 삭제하시겠습니가?");
	   if(yes){
		   location.href="deleteMember.jsp?m_num="+m_num;
	   }
   }
</script>
<script type="text/css"></script>
</head>
<%

MemgaipDao dao = new MemgaipDao();
List<MemgaipDto> list = dao.getMemList();

SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<body>
	<div style="margin: 50px 100px; width: 1000px;">
		<b>총 <%=list.size() %>명의 회원이 가입되었습니다.</b>
		<button type="button" class="btn btn-warning"
		onclick="location.href='addForm.jsp'" style="float: rignt; margin-right:50px;">회원가입</button>
		<br>
		<table class="table table-bordered">
			<caption align="top"><b>전체 회원 명단</b></caption>
			<tr class="table-success">
				<th width="50">번호</th>
				<th width="100">아이디</th>
				<th width="120">사진</th>
				<th width="100">회원명</th>
				<th width="150">핸드폰</th>
				<th width="120">가입일</th>
				<th width="100">편집</th>
			</tr>
			
			<%
			int i=1;
			
			for(MemgaipDto dto:list){
				%>
					<tr>
						<td align="center" valign="middle"><%=i++ %></td>
						<td align="center" valign="middle"><%=dto.getM_id() %></td>
						<td>
						<%
							if(dto.getM_photo()==null){
								%>
								<img alt="" src="../image/연예인사진/no_image.png"  class="rounded-circle" height="150px">
								<%
							}else{
								%>
								<img alt="" src="<%=dto.getM_photo() %>" class="rounded-circle" height="150px">
							<%}
						%>
						</td>
						<td align="center" valign="middle"><%=dto.getM_name() %></td>
						<td align="center" valign="middle"><%=dto.getM_hp() %></td>
						<td align="center" valign="middle"><%=sdf.format(dto.getGaipday()) %></td>
						<td align="center" valign="middle">
							<button type="button" class="btn btn-success btn-sm"
							onclick="location.href='updateForm.jsp?m_num=<%=dto.getM_num()%>'" >수정</button>
							<button type="button" class="btn btn-success btn-sm"
							onclick="funcdel('<%=dto.getM_num()%>')">삭제</button>
						</td>
					</tr>
				<%}
			%>
			

		</table>
	</div>
</body>
</html>