<%@page import="data.dao.SmartAnswerDao"%>
<%@page import="data.dto.SmartAnswerDto"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="data.dao.SmartDao"%>
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
	href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Diphylleia&family=Dongle&family=Gowun+Dodum&family=Nanum+Pen+Script&family=Orbit&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>

<style type="text/css">
span.aday, alist {
	float: right;
	font-size: 0.8em;
	color: gray;
}

div.alist {
	margin-left: 20px;
}
</style>

<script type="text/javascript">

$(function() {
	
	//처음 시작시 댓글 호출해야한다.
	list();
	
	var num=$("#num").val();
	//alert(num);
	
	$("#btnsend").click(function() {
		
		var nick = $("#nickname").val().trim();
		var content = $("#content").val().trim();
		
		if(nickname.length==0){
			alert("닉네임 입력후 저장해주세요.");
			return;
		}
		
		if(content==''){
			alert("댓글내용 입력후 저장해주세요.");
			return;
		}
		
		
		$.ajax({
			
			type:"get",
			url:"smartanswer/insertanswer.jsp",
			dataType:"html",
			data:{"num":num,
				"nickname":nick,
				"content":content},
			success:function(){
				
				//alert("success!!");
				//초기화
				$("#nickname").val('');
				$("#content").val('');
				
				list();
			}
		});

	});
	
});

function funcdel(num, currentPage) {
    //alert(num + "," + currentPage);
    var ans = confirm("삭제하려면 [확인]을 눌러주세요.");
    
    if (ans) {
        location.href = 'smartboard/smartdelete.jsp?num=' + num + '&currentPage=' + currentPage;
    }
}

function list() {
	
    console.log("list num ="+$("num").val());


    $.ajax({
    
    	type:"get",
    	url:"smartanswer/listanswer.jsp",
    	dataType:"json",
    	data:{"num":$("#num").val()},
    	success:function(res){
    		
    		//댓글개수출력
    		$("b.acount>span").text(res.length);
    		
    		var s="";
    		$.each(res,function(idx),item){
    			s+="<div>"+item.nick+":"+item.content;
    			s+="<span class='aday'>" +item.writeday+"</span>";
    			
    			
    			s+="</div>";

    		});
    
    		
    $("div.alist").html(s);
    	}
    })
    
}





</script>

</head>
<%
String num = request.getParameter("num");
String currentPage = request.getParameter("currentPage");

SmartDao dao = new SmartDao();
//dto
SmartDto dto = dao.getData(num);
//조회수1증가
dao.updateReadcount(num);
//날짜
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>




<div style="margin: 50px 100px; width: 500px;">
	<input type="hidden" id="num" value="<%=dto.getNum()%>">

	<table class="table table-bordered">
		<caption align="top">
			<b style="font-size: 15pt;"><%=dto.getSubject()%></b>
		</caption>
		<tr>
			<td><b>작성자: <%=dto.getWriter()%></b><br> <span><%=sdf.format(dto.getWriteday())%></span>
				&nbsp;&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount()%></td>
		</tr>
		<tr height="250">
			<td><%=dto.getContent().replace("\n", "<br>")%></td>
		</tr>

		<!-- 댓글 -->
		<tr>
			<td><b class="acount">댓글<span>0</span></b>

				<div id="alist">댓글목록</div>

				<div class="aform d-inline-flex">
					<input type="text" id="nickname" name="nickname"
						class="form-control" style="width: 100px;" placeholder="닉네임">
					<input type="text" id="content" name="content" class="form-control"
						style="width: 300px;" placeholder="댓글 메세지">
					<button type="button" id="btnsend" class="btn btn-info">저장</button>
				</div></td>
		</tr>



		<tr>
			<td align="center">

				<button type="button" class="btn btn-outline-info btn-sm"
					onclick="location.href='index.jsp?main=smartboard/smartform.jsp'">
					<i class="bi bi-pencil-fill"></i>&nbsp;글쓰기
				</button>

				<button type="button" class="btn btn-outline-success btn-sm"
					onclick="location.href='index.jsp?main=smartboard/boardlist.jsp?num=<%=num%>&currentPage=<%=currentPage%>'">
					<i class="bi bi-list-ul"></i>목록으로
				</button>
				<button type="button" class="btn btn-outline-warning btn-sm"
					onclick="location.href='index.jsp?main=smartboard/updateform.jsp?num=<%=num%>&currentPage=<%=currentPage%>'">
					<i class="bi bi-pencil-square"></i>수정
				</button>
				<button type="button" class="btn btn-outline-danger btn-sm"
					onclick="funcdel(<%=num%>,<%=currentPage%>)">
					<i class="bi bi-trash"></i>삭제
				</button>
			</td>
		</tr>
	</table>
</div>


<body>

</body>
</html>