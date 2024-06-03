<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
div.login {
	position: absolute;
	left: 800px;
	top: 40px;
	width: 350px;
}

#btnlogin {
	margin-left: 800px;
}
</style>
</head>
<body>
	<c:set var="root" value="<%=request.getContextPath() %>" />
	<a href="/"> 
		<img alt="" src="${root }/image/title.png"
		style="height: 100px;"> <b>SpringBoot+Mybatis+Tiles3</b>
	</a>

	<div class="login">

		<c:if test="${sessionScope.loginok==null }">
			<button type="button" class="btn btn-success" style="width: 100px;"
				onclick="location.href='${root}/login/main'">Login</button>
		</c:if>

		<c:if test="${sessionScope.loginok!=null }">
			<b>${sessionScope.myid }님이 로그인중</b>
			<button type="button" class="btn btn-danger" style="width: 100px;"
				onclick="location.href='${root}/login/logoutprocess'" id="btnlogout">Logout</button>
		</c:if>
	</div>



	
<c:if test="${sessionScope.loginok==null }">
	<div class="container mt-3">


		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#myModal" id="btnlogin">Ajax Login</button>
	
	
	</div>
</c:if>
		
<!-- ajax로그인 모달폼 -->
	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">회원 로그인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div>
						<i class="bi bi-person-circle"></i> <input type="text"
							class="form-control" id="loginid" placeholder="아이디">
					</div>

					<div>
						<i class="bi bi-check-all"></i> <input type="password"
							class="form-control" id="loginpass" placeholder="비밀번호">
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal" id="btnloginok">Login</button>
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<!-- ajax로그인 이벤트 -->
	<script type="text/javascript">
      //팝업창에 있는 로그인버튼
      $("#btnloginok").click(function(){
    	  
    	  //아이디와 비번읽기
    	  var id=$("#loginid").val();
    	  var pass=$("#loginpass").val();
    	  var root="${root}";
    	  
    	  //alert(id+","+pass);
    	  
    	  console.log("root"+root);
    	  
    	  $.ajax({
    		  type:"get",
    		  url:root+"/member/login",
    		  dataType:"json",
    		  data:{"id":id,"pass":pass},
    		  success:function(res){
    			  
    			  if(res.result=='fail')
    				  alert("아이디나 비번이 맞지않습니다");
    			  else
    				  location.reload();
    		  }
    	  })
      });
      
      
      //로그아웃
      $("#btnlogout").click(function(){
    	  
    	  var root="${root}";
    	  
    	  $.ajax({
    		  type:"get",
    		  url:root+"/member/logout",
    		  dataType:"html",
    		  success:function(res){
    			  location.reload();
    		  }
    		  
    	  })
      })
  
  </script>


</body>
</html>