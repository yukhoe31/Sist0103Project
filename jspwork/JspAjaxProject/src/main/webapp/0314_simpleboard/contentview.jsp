<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
body * {
	font-family: 'Noto Serif KR';
	font-size: 11pt;
}

span.day {
	color: #ccc;
	font-size: 0.8em;
}

span.aday {
	float: right;
	font-size: 0.8em;
	color: #bbb;
}

span.alist {
	margin-left: 20px;
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
	list();

	$(function() {

		//ajax로 insert하기
		var num = $("#num").val();

		$("#btnsend").click(function() {
			var nickname = $("#nickname").val();
			var content = $("#content").val();

			console.log(num, nickname, content);

			if (nickname == '') {
				alert("닉네임을 입력후 저장해주세요.");
				return;
			}
			if (content == '') {
				alert("댓글 내용을 입력후 저장해주세요/");
				return;
			}

			$.ajax({
				type : "get",
				dataType : "html",
				url : "../0315_simpleboardanswer/insertAnswer2.jsp",
				data : {
					"num" : num,
					"nickname" : nickname,
					"content" : content
				},
				success : function() {
					alert("성공");

					//insert성공시..폼초기화
					$("#nickname").val("");
					$("#content").val("");

					list();

				}
			});
		});

		$("#updatebtn").click(function() {
			var nickname = $("#nickname").val();
			var content = $("#content").val();

			console.log(num, nickname, content);

			if (nickname == '') {
				alert("닉네임을 입력후 저장해주세요.");
				return;
			}
			if (content == '') {
				alert("댓글 내용을 입력후 저장해주세요/");
				return;
			}

			$.ajax({
				type : "get",
				dataType : "html",
				url : "../0315_simpleboardanswer/insertAnswer2.jsp",
				data : {
					"num" : num,
					"nickname" : nickname,
					"content" : content
				},
				success : function() {
					alert("성공");

					//insert성공시..폼초기화
					$("#nickname").val("");
					$("#content").val("");

					list();

				}
			});
		});

		//삭제버튼 누르면..삭제후 내용보기 숨기고 목록을 보이게
		$(document).on("click", ".adel", function() {

			var num = $(this).closest('div').attr("num");
			//alert(num);

			$.ajax({
				type : "get",
				dataType : "html",
				url : "../0315_simpleboardanswer/deleteAnswer.jsp",
				data : {
					"num" : num
				},
				success : function() {

					list(); //목록 다시호출

				}
			});
		});

	});

	function list() {

		console.log("list num =" + $("#num").val());

		$
				.ajax({

					type : "get",
					url : "../0315_simpleboardanswer/listAnswer.jsp",
					dataType : "json",
					data : {
						"num" : $("#num").val()
					},
					success : function(res) {

						//댓글 갯수 출력
						$("b.acounct>span").text(res.length);

						var s = "";
						$
								.each(
										res,
										function(idx, item) {

											s += "<div>" + item.nickname + ":"
													+ item.content;
											s += "<span class='aday'>"
													+ item.writeday + "</span>";
											s += "<i class='bi bi-pencil-square amod' id='updatebtn'></i>";
											s += "<i class='bi bi-trash adel' id='deletebtn'></i>";

										});

						$("div.alist").html(s);

					}

				});
	}
</script>

</head>
<%
String num = request.getParameter("num");
SimpleBoardDao dao = new SimpleBoardDao();
//dto
SimpleBoardDto dto = dao.getContent(num);
//조회수1증가
dao.updateReadCount(num);
//날짜
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<input type="hidden" id="num" value="<%=num%>">



<div style="margin: 50px 100px; width: 500px;">
	<table class="table table-bordered">
		<caption align="top">
			<b style="font-size: 15pt;"><%=dto.getSubject()%></b>
		</caption>
		<tr>
			<td><b>작성자: <%=dto.getWriter()%></b><br> <span class="day"><%=sdf.format(dto.getWriteday())%></span>
				&nbsp;&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount()%></td>
		</tr>
		<tr height="250">
			<td><%=dto.getContent().replace("\n", "<br>")%></td>
		</tr>

		<!-- 댓글 부분 -->
		<tr>
			<td><b class="acount">댓글<span>0</span></b> <!-- 댓글 목록 부분 -->
				<div class="alist">댓글목록</div> <!-- 댓글 작성부분 -->
				<div class="aform input-group">
					<input type="text" id="nickname" class="form-control"
						style="width: 80px;" placeholder="닉네임"> <input type="text"
						id="content" class="form-control" style="width: 300px;"
						placeholder="댓글메세지">

					<button type="button" id="btnsend" class="btn btn-info btn-sm"
						style="margin-left:">저장</button>
				</div></td>
		</tr>

		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-info btn-sm"
					onclick="location.href='addform.jsp'">
					<i class="bi bi-pencil"></i>글쓰기
				</button>
				<button type="button" class="btn btn-outline-success btn-sm"
					onclick="location.href='boardlist.jsp'">
					<i class="bi bi-list-check"></i>목록
				</button>
				<button type="button" class="btn btn-outline-primary btn-sm"
					onclick="location.href='updatepassform.jsp?num=<%=dto.getNum()%>'">
					<i class="bi bi-pencil-square"></i>수정
				</button>
				<button type="button" class="btn btn-outline-danger btn-sm"
					onclick="location.href='deletepassform.jsp?num=<%=dto.getNum()%>'">
					<i class="bi bi-trash"></i>삭제
				</button>
			</td>
		</tr>
	</table>
</div>
<body>
	<script>
		$(document).ready(function() {
			// 페이지 로드시 댓글 목록 가져오기
			list();
		});
	</script>

</body>
</html>