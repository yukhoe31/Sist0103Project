<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>

<style type="text/css">
.day{
color: gray;
margin-left: 10px;
font-size: 0.9em;
}

</style>



<script type="text/javascript">

	$(function() {
		
		num = $("#num").val(); //전역변수
		loginok = "${sessionScope.loginok}";
		myid = "${sessionScope.myid}";
		
		//alert(loginok + "," + myid);
		
		$("#btnansweradd").click(function(){
			
			var content = $("#content").val();
			
			if(content.length == 0 ){
				alert("댓글내용을 입력해주세요.");
				return;
			}
			
			//입력하면 ajax로 insert처리
			$.ajax({
				type: "post",
				dataType: "html",
				url: "ainsert",
				data: {"num": num, "content": content},
				success: function(res){
					alert("성공");
					
					//입력값 초기화
					$("#content").val("");
					list(); // 댓글 목록 갱신
				}
			});
			
		});
		
		list(); // 페이지 로드 시 댓글 목록 가져오기
		
	});
	
	//댓글리스트
	function list() {
    num = $("#num").val(); //전역변수
    loginok = "${sessionScope.loginok}";
    myid = "${sessionScope.myid}";
    
    $.ajax({
        type: "get",
        dataType: "json",
        url: "alist",
        data: {"num": num},
        success: function(data){
            $("span.acount").text(data.length);//댓글수
            
            var s="";
            $.each(data,function(i,dto){
                
                s += "<b>" +dto.name+ "</b>: " +dto.content;
                s += "<span class='day'>" + dto.writeday +"</span>";
                
                if(loginok == 'yes' && myid == dto.myid){
                    s += "<i class='bi bi-pencil-square' data-idx='" + dto.idx + "'></i>";
                    s += "&nbsp;"
                    s += "<i class='bi bi-trash-fill' data-idx='" + dto.idx + "'></i>";
                }
                
                s += "<br>";
            });
            
            $("div.alist").html(s);

            // Add event listeners for the edit and delete buttons
            $(".bi-pencil-square").click(function() {
                var idx = $(this).data("idx");
                editAnswer(idx);
            });
            
            $(".bi-trash-fill").click(function() {
                var idx = $(this).data("idx");
                deleteAnswer(idx);
            });
        }
    });
}

	function editAnswer(idx) {
	    // Fetch the current content of the comment
	    $.ajax({
	        type: "get",
	        dataType: "json",
	        url: "getComment",
	        data: {"idx": idx},
	        success: function(data) {
	            var currentContent = data.content;
	            var newContent = prompt("Enter new content for the comment:", currentContent);

	            if (newContent && newContent !== currentContent) {
	                $.ajax({
	                    type: "post",
	                    dataType: "html",
	                    url: "aupdate",
	                    data: {"idx": idx, "content": newContent},
	                    success: function(res) {
	                        alert("수정되었습니다.");
	                        list(); // Refresh the comment list
	                    }
	                });
	            }
	        }
	    });
	}


function deleteAnswer(idx) {
    if (confirm("정말로 삭제하시겠습니까?")) {
        $.ajax({
            type: "post",
            dataType: "html",
            url: "adelete",
            data: {"idx": idx},
            success: function(res) {
                alert("삭제되었습니다.");
                list(); // Refresh the comment list
            }
        });
    }
}


</script>

</head>
<body>
<div style="margin: 50px 100px;">
   <table class="table table-bordered" style="width: 600px;">
      <tr>
         <td>
            <h3><b>${dto.subject }</b>
            <span style="color: gray; float: right; font-size: 12pt;">
               <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
            </span>
            </h3>
            <span>작성자:  ${dto.name }(${dto.myid })</span>
            
            <c:if test="${dto.uploadfile!='no' }">
              <span style="float: right;">
               <a href="download?clip=${dto.uploadfile }">
               <i class="bi bi-box-arrow-down " style="font-size: 18pt; color: gray;"></i>
                <b>${dto.uploadfile }</b>
               </a>
              </span>
            </c:if>
            
         </td>
      </tr>
      
      <tr>
        <td>
          <c:if test="${bupload==true }">
             <h5>업로드된 파일이 이미지입니다</h5>
             <img alt="" src="../boardphoto/${dto.uploadfile }" style="max-width: 400px;">
          </c:if>
          
          <br><br>
          <pre>${dto.content }</pre>
          <br>
          <b>조회: ${dto.readcount }</b>&nbsp;&nbsp;
          <b>댓글: <span class="acount"></span></b>
        </td>
      </tr>
      
      <tr>
      <td>
        <div class="alist"></div>
        <input type="hidden" id="num" value="${dto.num }">
        <c:if test="${sessionScope.loginok!=null }">
           <div class="aform">
             <div class="d-inline-flex">
                <input type="text" class="form-control" style="width: 500px;"
                placeholder="댓글을 입력하세요" id="content">&nbsp;
                <button type="button" class="btn btn-info" style="width: 60px;"
                id="btnansweradd">등록</button>
             </div>
           </div>
        </c:if>
        </td>
      </tr>
      
      <!-- 버튼들 -->
      <tr>
        <td align="right">
         <c:if test="${sessionScope.loginok!=null }">
           <button type="button" class="btn btn-outline-success" style="width: 80px;"
           onclick="location.href='form'">글쓰기</button>
         </c:if> 
         
         <button type="button" class="btn btn-outline-success" style="width: 80px;"
         onclick="location.href='list'">목록</button>
         
         <c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid}">
           <button type="button" class="btn btn-outline-success" style="width: 80px;"
           onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
         </c:if>  
         
         <c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid}">
           <button type="button" class="btn btn-outline-success" style="width: 80px;"
           onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
         </c:if>
        </td>
      </tr>
   </table>
</div>

</body>
</html>
