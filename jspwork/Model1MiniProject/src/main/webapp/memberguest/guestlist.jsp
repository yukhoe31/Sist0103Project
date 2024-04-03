<%@page import="data.dto.AnswerGuestDto"%>
<%@page import="data.dao.AnswerGuestDao"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar"%>
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
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

body *{
    font-family: 'Diphylleia';
    font-size: 11pt;
}
 
   
i.amod {
	margin-left: 20px;
	color: green;
}

i.adel {
	color: red;
}

/* 버튼 사이 간격 조정 */
td .btn {
	margin-bottom: 10px; /* 버튼 아래 여백 조정 */
}

/* 테이블 셀 가운데 정렬 */
th {
	text-align: center;
}
</style>


<script type="text/javascript">

$(function(){
	   
	   $("span.likes").click(function(){
		   
		   var num=$(this).attr("num");
		   //alert(num);
		   var tag=$(this);
		   
		   $.ajax({
			   type:"get",
			   dataType:"json",
			   url:"memberguest/updateincrechu.jsp",
			   data:{"num":num},
			   success:function(data){
				   
				  // alert(data.chu);
				  tag.next().text(data.chu);
				  
				  //하트에 animate
				  tag.next().next().animate({"font-size":"15px"},1000,function(){
					  //애니메이션 끝난후
					  $(this).css("font-size","0px");
				  })
			   }
		   })
	   });
	   
	   

	   
	   
	   //댓글부분은 무조건 처음에는 안보이게 처리
	   $("div.answer").hide();
	   //댓글 클릭시 댓글부분이 보였다 안보였다 하기
	   $("span.answer").click(function(){
		   //$("div.answer").toggle();
		   $(this).parent().find("div.answer").toggle();
	   });
	   
	   
	   //댓글삭제
	   $("i.adel").click(function(){
		   
		  
		   var a=confirm("삭제하려면 [확인]을 눌러주세요");
		   
		   if(a){
			   
			   var idx=$(this).attr("idx");
			   //alert(idx);
			   
			   $.ajax({
				   type:"get",
				   dataType:"html",
				   url:"memberguest/deleteanswer.jsp",
				   data:{"idx":idx},
				   success:function(){
					   location.reload();//새로고침
				   }
			   })
			   
		   }
		   
		   
	   });
	   
	   //수정아이콘 누르면 모달창
	   $("i.aedit").click(function(){
		   
		   var idx=$(this).attr("idx");
		   //alert(idx);
		   
		   $("#idx").val(idx);
		   
		   $.ajax({
			   
			   type:"get",
			   dataType:"json",
			   url:"memberguest/answercontent.jsp",
			   data:{"idx":idx},
			   success:function(res){
				   
				   $("#idx").val(res.idx);
				   $("#ucontent").val(res.story);
			   }
		   })
	   });
	   
	   
	   //댓글수정하기
	   $("#btnupdate").click(function(){
		   
		  var idx= $("#idx").val();
		  var content=$("#ucontent").val();
		  
		  //alert(idx+","+content);
		  
		  $.ajax({
			  type:"post",
			  url:"memberguest/updateanswer.jsp",
			  dataType:"html",
			  data:{"idx":idx,"content":content},
			  success:function(){
				  location.reload();
			  }
		  })
	   });
	   
});


	//리스트의 삭제버튼클릭시 삭제
    function confirmDelete(num,currentPage) {
        var result = confirm("정말 삭제하시겠습니까?");
        if (result) {
            // 사용자가 확인을 선택한 경우
            // 삭제 액션을 수행하는 페이지로 이동하거나 AJAX로 삭제 요청을 보냅니다.
            // 여기에 필요한 코드를 추가하세요.
            // 예를 들어, 삭제 액션을 처리하는 페이지로 이동하는 경우:
            location.href='memberguest/guestdeleteaction.jsp?num=' + num+'&currentPage='+currentPage;
        } else {
            // 사용자가 취소를 선택한 경우
            // 아무런 동작을 하지 않습니다.
            // 혹은 필요한 경우 다른 동작을 수행할 수 있습니다.
        }
    }
	
	

		   

	
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

if (list.size() == 0 && currentPage != 1) {
%>
<script type="text/javascript">
		location.href="index.jsp?memeberguest/guestlist.jsp?currentPage=<%=currentPage - 1%>";

</script>

<%
}

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
				<th width="100"><i class="bi bi-person-circle"></i>&nbsp;작성자</th>
				<th width="200"><i class="bi bi-pencil-fill"></i>&nbsp;내용</th>
				<th width="150"><i class="bi bi-card-image"></i>&nbsp;이미지</th>
				<th width="160"><i class="bi bi-calendar-date-fill"></i>&nbsp;작성일</th>
				<th width="100"><i class="bi bi-tools"></i>&nbsp;비고</th>
			</tr>

			<%
			//★로그인한 사람의 id가 뭔지 가져와서 loginId에 저장하기.
			String loginId = (String) session.getAttribute("myid");

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

				//★게시글을 작성한 사람의 id가 뭔지 가져와서 postId에 저장하기.
				String postId = dto.getMyid();

				//실명 가져오기(반드시 필요한 기능은 아니지만...)
				MemberDao mdao = new MemberDao();
				MemberDto mdto = new MemberDto();
				mdto = mdao.getMemberById(dto.getMyid());
				String name = mdto.getName();
			%>

			<tr>

				<td align="center"><%=dto.getMyid()%><br>(<%=name%>)</td>
				<td align="center"><%=dto.getContent()%></td>
				<td align="center"><img src="save/<%=dto.getPhotoname()%>"
					style="height: 150px;"></td>
				<td align="center"><%=sdf.format(dto.getWriteday())%></td>
				<td>
					<%
					// 로그인한 유저(loginId)와 게시글 작성한 유저(postId)의
					// id가 동일한 경우에만 수정, 삭제 버튼이 보이게 하기
					if (loginId != null && loginId.equals(postId)) {
					%> <input type="hidden" name="currentPage" value="<%=currentPage%>">
					<button type="button" class="btn btn-outline-primary btn-sm"
						onclick="location.href='index.jsp?main=memberguest/guestupdateform.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'">
						<i class="bi bi-pencil-square"></i>수정 <br>
					</button>

					<button type="button" class="btn btn-outline-danger btn-sm"
						onclick="confirmDelete(<%=dto.getNum()%>, <%=currentPage%>)">
						<i class="bi bi-trash"></i>삭제
					</button> <%
 }
 %>
				</td>
			</tr>

			<!--댓글 추천 -->
			<tr>
				<td colspan="6">
					<%
					//각방명록에 달린 댓글 목록가져오기
					AnswerGuestDao adao = new AnswerGuestDao();
					List<AnswerGuestDto> alist = adao.getAllAnswers(dto.getNum());
					%> <span class="answer" style="cursor: pointer;">댓글 <%=alist.size()%></span>
					<span class="likes" style="margin-left: 20px; cursor: pointer;"
					num=<%=dto.getNum()%>>추천</span> <span class="chu"><%=dto.getChu()%></span>
					<i class="bi bi-heart-fill" style="font-size: 0px; color: red;"></i>


					<div class="answer">
						<%
						if (loginok != null) {
						%>

						<div class="answerform">
							<form action="memberguest/answerinsert.jsp" method="post">
								<input type="hidden" name="num" value="<%=dto.getNum()%>">
								<input type="hidden" name="myid" value="<%=loginId%>"> <input
									type="hidden" name="currentPage" value="<%=currentPage%>">
								<table>
									<tr>
										<td width="500"><textarea
												style="width: 480px; height: 70px;" name="content"
												required="required" class="form-control"></textarea></td>
										<td>
											<button type="submit" class="btn btn-info"
												style="width: 70px; height: 70px;">등록</button>
										</td>
									</tr>
								</table>
							</form>
						</div>
						<%
						}
						%>

						<div class="answerlist">
							<table style="width: 500px;">
								<%
								for (AnswerGuestDto adto : alist) {
								%>
								<tr>
									<td><i class="bi bi-person-circle fs-2"
										style="color: gray;"></i></td>
									<td>
										<%
										//작성자명
										  String answerId=adto.getMyid();
										%> <br> <b><%=answerId%></b> &nbsp; <%
 										
										//글작성자와 댓글작성자가 같을경우
 										if (dto.getMyid().equals(adto.getMyid())) {
 										%> <span style="color: red;">작성자</span> <%}
 										%> <span style="font-size: 9pt; color: gray; margin-left: 20px;">
											<%=sdf.format(adto.getWriteday())%>
									</span> 
									
									
									<!-- 댓글 수정삭제는 본인만 보이게 --> <%
 									if (loginok != null && adto.getMyid().equals(loginId)) {
 									%> 
 										<i class="aedit bi bi-pencil-square" idx="<%=adto.getIdx()%>"
										data-bs-toggle="modal" data-bs-target="#myModal"></i> <i
										class="bi bi-trash adel" idx="<%=adto.getIdx()%>"></i> <%
 									} %> 
 									<br> 
 									<span style="font-family: 10pt;"><%=adto.getContent().replace("\n", "<br>")%></span>

									</td>
								</tr>
								<%
								}
								%>
							</table>

						</div>
					</div>
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



	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">댓글수정</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="updateform d-inline-flex">
						<input type="hidden" id="idx">
						<input type="text" class="form-control"	id="ucontent" style="width:350px;" >
						<button type="button" class="btn btn-info" id="btnupdate" style="margin-left: 10px;">댓글수정</button>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>






</body>
</html>