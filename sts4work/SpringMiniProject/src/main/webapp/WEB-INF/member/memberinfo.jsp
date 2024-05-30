<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
  $(function(){
	  $(".btnnewphoto").click(function(){
		  $("#newphoto").trigger("click");
	  });
	  
	  $("#newphoto").change(function(){
		  
		  var num=$(this).attr("num");
		  //alert(num);
		  
		  var form=new FormData();
		  
		  form.append("photo",$("#newphoto")[0].files[0]);
		 	form.append("num",num); 
		  
		  console.dir(form); 
		  
		  
		  $.ajax({
			  type:"post",
			  dataType:"html",
			  url:"updatephoto",
			  processData:false,
			  contentType:false,
			  data:form,
			  success:function(){
				  location.reload();
			  }
			  
		  })
		  
	  });
	  
	  
	  //수정버튼클릭시 모달 다이얼로그에 데이타 넣기
	  $(".btnupdate").click(function(){
		   updatenum=$(this).attr("num");
		  alert(updatenum);
		   
		   $.ajax({
			   type:"get",
			   dataType:"json",
			   url:"updateform",
			   data:{"num":updatenum},
			   success:function(res){
				   
				   console.dir(res);
				   $("#updatename").val(res.name);
				   $("#updatehp").val(res.hp);
				   $("#updateemail").val(res.email);
				   $("#updateaddr").val(res.addr);
			   }
		   })
	  });
	  
	  //수정
	  $("#btnupdateok").click(function(){
		  
		  var updatename=$("#updatename").val();
		  var updatehp=$("#updatehp").val();
		  var updateemail=$("#updateemail").val();
		  var updateaddr=$("#updateaddr").val();
		  
		  var data="num="+updatenum+"&name="+updatename+"&hp="+updatehp+"&email="+updateemail+"&addr="+updateaddr;
		  
		  console.log(data);
		  
		  
		  $.ajax({
			  type:"post",
			  dataType:"html",
			  url:"update",
			  data:data,
			  success:function(){
				  location.reload();
			  }
		  })
		  
	  });
	  
	  //탈퇴
	  $(".btndelete").click(function(){
		
		  var num=$(this).attr("num");
		  //alert(num);
		  
		  var a = confirm("정말 탈퇴하시겠습니까?");	
		  
		  if(a){
			  $.ajax({
				
				  type:"get",
				  dataType:"html",
				  url:"deleteme",
				  data:{"num":num},
				  success:function(){
					  
					  alert("탈퇴하셨습니다.");
					  location.reload();
					  
				  }
			  })
		  }
		  
		  
	  })

	  
  })

</script>

</head>
<body>
<div style="margin: 50px 100px; width: 700px;">
<table class="table table-bordered">
   <c:forEach var="dto" items="${list }">
   
   <c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.id }">
     <tr>
       <td style="width: 250px;" align="center" rowspan="5">
         <img alt="" src="../memberphoto/${dto.photo }" width="200" height="220" border="1">
         <br><br>
         <input type="file" id="newphoto" num="${dto.num }" style="display: none;">
         <button type="button" class="btn btn-info btnnewphoto">사진수정</button>
       </td>
       <td>회원명: ${dto.name }</td>
       <td rowspan="5" align="center" style="width: 200px;" valign="middle">
           <button type="button" class="btn btn-outline-info btnupdate" num="${dto.num }"
           data-bs-toggle="modal" data-bs-target="#myUpdateModal">수정</button>
           <button type="button" class="btn btn-outline-danger" num="${dto.num }">삭제</button>
       </td>
     </tr>
     
     <tr>
       <td>아이디: ${dto.id }</td>
     </tr>
     <tr>
       <td>이메일: ${dto.email }</td>
     </tr>
     <tr>
       <td>핸드폰: ${dto.hp }</td>
     </tr>
     <tr>
       <td>주소: ${dto.addr }</td>
     </tr>
    </c:if> 
    
    
      

   
   </c:forEach>
</table>
</div>
   <c:if test="${sessionScope.loginok == null}">

    	<b style="font-size: 30px;color: green;'">먼저 로그인을 하시기 바랍니다.</b>
   </c:if> 

<!-- The Modal -->
<div class="modal" id="myUpdateModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원정보수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="d-inline-flex">
            <label style="width: 80px;">Name:  </label>&nbsp;&nbsp;
            <input type="text" class="form-control" id="updatename">
        </div>
        <div class="d-inline-flex">
            <label style="width: 80px;">hp:  </label>&nbsp;&nbsp;
            <input type="text" class="form-control" id="updatehp">
        </div>
        <div class="d-inline-flex">
            <label style="width: 80px;">email:  </label>&nbsp;&nbsp;
            <input type="text" class="form-control" id="updateemail">
        </div>
        <div class="d-inline-flex">
            <label style="width: 80px;">addr:  </label>&nbsp;&nbsp;
            <input type="text" class="form-control" id="updateaddr">
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
      id="btnupdateok">수정</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>




</body>
</html>