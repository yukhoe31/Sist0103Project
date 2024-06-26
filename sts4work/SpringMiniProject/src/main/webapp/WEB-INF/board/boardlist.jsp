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
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="margin: 100px 100px; width: 1000px;">
<c:if test="${sessionScope.loginok!=null }">
   <button type="button" class="btn btn-outline-success"
   style="width: 100px; margin-left: 900px;"
   onclick="location.href='form'">글쓰기</button>
</c:if>
<br><br>
<table class="table table-bordered" >
   <tr class="table-success">
     <th width="60">번호</th>
     <th width="460">제목</th>
     <th width="160">작성자</th>
     <th width="80">조회</th>
     <th width="250">등록일</th>
   </tr>
   
   <c:if test="${totalCount==0 }">
      <tr height="50">
        <td colspan="5" align="center">
           <h5><b>등록된 글이 없습니다</b></h5>
        </td>
      </tr>
   </c:if>
   
   <c:if test="${totalCount>0 }">
      <c:forEach  var="a" items="${list }">
          <tr>
            <td align="center">${no }</td>  
            <c:set var="no" value="${no-1 }"/>
            <td>
               <a href="content?num=${a.num }&currentPage=${currentPage}" style="color: black;">
                 ${a.subject }
               </a>
               <c:if test="${a.uploadfile!='no' }">
                   <i class="bi bi-image"  style="color: gray;"></i>
               </c:if>
               
               <c:if test="${a.acount >0 }">
               		<a style="color:red;" href="content?num=${a.num }&currentPage=${currentPage}">[${a.acount}]</a>
               
               </c:if>
               
            </td>
            <td>${a.name }</td>
            <td>${a.readcount }</td>
            <td>
              <fmt:formatDate value="${a.writeday }" pattern="yyyy-MM-dd"/>
            </td>
          </tr>
      </c:forEach>
   </c:if>
</table>
</div>


<!-- 페이징 -->
<div style="margin: 100px 100px; width: 1000px; text-align: center;">
  <ul class="pagination justify-content-center">
     <!--  이전-->
     <c:if test="${startPage>1 }">
        <li class="page-item ">
	   <a class="page-link" href="list?currentPage=${startPage-1 }" style="color: black;">이전</a>
	  </li>
     </c:if>
     
     <!--페이지번호  -->
     <c:forEach var="pp"  begin="${startPage }"  end="${endPage }">
       <c:if test="${currentPage==pp }">
       	  <li class="page-item active">
    		<a class="page-link" href="list?currentPage=${pp }">${pp }</a>
    	  </li>
       </c:if>
       
       <c:if test="${currentPage!=pp }">
          <li class="page-item">
    		<a class="page-link" href="list?currentPage=${pp }">${pp }</a>
    		</li>
       </c:if>
     </c:forEach>
     
     
     <!-- 다음 -->
     <c:if test="${endPage<totalPage }">
        <li class="page-item">
    		<a  class="page-link" href="list?currentPage=${endPage+1 }"
    		style="color: black;">다음</a>
    	</li>
     </c:if>
  </ul>
</div>


</body>
</html>