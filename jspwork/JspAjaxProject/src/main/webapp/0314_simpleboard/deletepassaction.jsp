<%@ page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Action</title>
</head>
<body>
	<%
	//num,pass
    String num = request.getParameter("num");
    String password = request.getParameter("password");
    
    //dao
    SimpleBoardDao dao = new SimpleBoardDao();
    
    //비번확인메서드 호출
    boolean isPasswordCorrect = dao.isEqualPass(num, password);


    //true삭제후 목록
    //false면 경고후 back
    
    if (isPasswordCorrect) {
        // Password is correct, delete the board entry
        dao.deleteSimpleBoard(num);
        %>
		<script type="text/javascript">
        	alert("삭제되었습니다. 목록으로 이동합니다.");
        	location.href='boardlist.jsp';      	
        </script>

		<%} else {
        // Password is incorrect, display an alert and redirect back
		%>
		<script type="text/javascript">
            alert("비밀번호가 맞지 않습니다.");
            history.back();
        </script>
		<%}
%>
</body>
</html>
