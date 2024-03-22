<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="data.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.GuestDao"%>
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
<title>Insert title here</title>

<style type="text/css">
a:link, a:visited {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: underline;
	color: gray;
}

body * {
	font-family: 'Noto Serif KR';
	font-size: 11pt;
}

i.amod {
	margin-left: 20px;
	color: green;
}

i.adel {
	color: red;
}
</style>

<script type="text/javascript">
	//리스트의 삭제버튼클릭시 삭제

	//수정
	$("#btnaUsend").click(function() {

		var num = $("#num").val();
		var photoname = $("#uphotoname").val();
		var content = $("#ucontent").val();

		//alert(idx+","+nick+","+content);

		$.ajax({
			type : "get",
			url : "../memberguest/guestupdateaction.jsp",
			dataType : "html",
			data : {
				"num" : num,
				"photoname" : photoname,
				"content" : content
			},
			success : function() {

			}
		})
	});
</script>


</head>


<body>

	<%
	//로그인 상태 확인
	String loginok = (String) session.getAttribute("loginok");
	%>

	<%
	if (loginok != null) {
	%>
	<jsp:include page="guestform.jsp" />
	<hr width="700" align="left" style="margin-left: 100px;">

	<%
	}
	%>


	<div style="margin: 50px 100px;">
		<b>방명록 리스트가 출력될곳...</b>
	</div>
</head>

<%
GuestDao dao = new GuestDao();

//전체갯수
int totalCount = dao.getTotalCount();
int perPage = 3; //한페이지당 보여질 글의 갯수
int perBlock = 5; //한블럭당 보여질 페이지 갯수
int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이0번,오라클은 1번);
int startPage; //각블럭당 보여질 시작페이지
int endPage; //각블럭당 보여질 끝페이지
int currentPage; //현재페이지
int totalPage; //총페이지수
int no; //각페이지당 출력할 시작번호

//현재페이지 읽는데 단 null일경우는 1페이지로 준다
if (request.getParameter("currentPage") == null)
	currentPage = 1;
else
	currentPage = Integer.parseInt(request.getParameter("currentPage"));

//총페이지수 구한다
//총글갯수/한페이지당보여질갯수로 나눔(7/5=1)
//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

//각블럭당 보여질 시작페이지
//perBlock=5일경우 현재페이지가 1~5일경우 시작페이지가1,끝페이지가 5
//현재가 13일경우 시작:11 끝:15
startPage = (currentPage - 1) / perBlock * perBlock + 1;
endPage = startPage + perBlock - 1;

//총페이지가 23일경우 마지막블럭은 끝페이지가 25가 아니라 23
if (endPage > totalPage)
	endPage = totalPage;

//각페이지에서 보여질 시작번호
//1페이지:0, 2페이지:5 3페이지: 10.....
startNum = (currentPage - 1) * perPage;

//각페이지당 출력할 시작번호 구하기
//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
no = totalCount - (currentPage - 1) * perPage;

//페이지에서 보여질 글만 가져오기
List<GuestDto> list = dao.getList(startNum, perPage);

//List<SimpleBoardDto>list=dao.getAllDatas();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//int count=list.size();
%>

<body>
	<div style="margin: 50px 100px; width: 800px;">

		<br>
		<h6>
			<b>총<%=totalCount%>개의 글이 있습니다
			</b>
		</h6>
		<table class="table table-bordered">
			<caption align="top">
				<b>방명록 리스트</b>
			</caption>
			<tr class="table-light">
				<th width="100">작성자</th>
				<th width="200">내용</th>
				<th width="150">이미지</th>
				<th width="80">추천수</th>
				<th width="160">작성일</th>
				<th width="100">비고</th>
			</tr>

			<%
			
			//로그인한 사람의 id가 뭔지 가져와서 loginId에 저장하기.
			String loginId = (String)session.getAttribute("myid"); 
			
			
			if (totalCount == 0) {
			%>
			<tr>
				<td colspan="5" align="center">
					<h6>
						<b>등록된 게시글이 없습니다</b>
					</h6>
				</td>
			</tr>
			<%
			} else {
			for (int i = 0; i < list.size(); i++) {
				GuestDto dto = list.get(i);
				
				//게시글을 작성한 사람의 id가 뭔지 가져와서 postId에 저장하기.
				String postId = dto.getMyid(); 
			%>

			<tr>

				<td align="center"><%=dto.getMyid()%></td>
				<td align="center"><%=dto.getContent()%></td>
				<td align="center"><img src="save/<%=dto.getPhotoname()%>"
					height="150px"></td>
				<td align="center"><%=dto.getChu()%></td>
				<td align="center"><%=sdf.format(dto.getWriteday())%></td>
				<td>
					<button type="button" class="btn btn-outline-warning btn-sm">👍추천</button>
					
					<% 
       				 // 로그인한 유저(loginId)와 게시글 작성한 유저(postId)의
       				 // id가 동일한 경우에만 수정, 삭제 버튼이 보이게 하기
       				 if(loginId != null && loginId.equals(postId)) {
       				 %>
       				 
					<button type="button" class="btn btn-outline-primary btn-sm"
						onclick="location.href='memberguest/guestupdateform.jsp?num=<%=dto.getNum()%>'">
					<i class="bi bi-pencil-square"></i>수정
					</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						onclick="location.href='memberguest/guestdeleteaction.jsp?num=<%=dto.getNum()%>'">
						<i class="bi bi-trash"></i>삭제
					</button>
					 <% } %>
				</td>

			</tr>
			<%
			}
			}
			%>
		</table>

		<!-- 페이지 번호 출력 -->
		<ul class="pagination justify-content-center">
			<%
			//이전
			if (startPage > 1) {
			%>
			<li class="page-item "><a class="page-link"
				href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=startPage - 1%>"
				style="color: black;">이전</a></li>
			<%
			}
			for (int pp = startPage; pp <= endPage; pp++) {
			if (pp == currentPage) {
			%>
			<li class="page-item active"><a class="page-link"
				href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=pp%>"><%=pp%></a></li>
			<%
			} else {
			%>
			<li class="page-item"><a class="page-link"
				href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=pp%>"><%=pp%></a></li>
			<%
			}
			}

			//다음
			if (endPage < totalPage) {
			%>
			<li class="page-item"><a class="page-link"
				href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=endPage + 1%>"
				style="color: black;">다음</a></li>
			<%
			}
			%>

		</ul>




	</div>

</body>
</html>