<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="intro.model.IntroDao"%>
<%@page import="intro.model.IntroDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>

<%--
<%

  //마지막 컴마를 떼어내는 연습
  String msg = "안녕 오늘은, 기분좋은, 목요일입니다,";
  
  msg = msg.substring(0, msg.length()-1);
  System.out.println(msg);
%>
--%>

<%--방법1:
<%
  
  request.setCharacterEncoding("utf-8");

  String name=request.getParameter("name");
  String age=request.getParameter("age");
  String birthday=request.getParameter("birthday");
  String hometown=request.getParameter("hometown");
  String[] hobbies=request.getParameterValues("hobby"); // Receive hobbies as an array
  String memo=request.getParameter("memo");

  // Create comma-separated string of hobbies
  String hobbiesString = Arrays.stream(hobbies).collect(Collectors.joining(", "));

  //dto선언
  IntroDto dto=new IntroDto();
  dto.setName(name);
  dto.setAge(age);
  dto.setBirthday(birthday); // Fixing the setting of other properties
  dto.setHometown(hometown);
  dto.setHobby(hobbiesString); // Setting the hobbies as a single comma-separated string
  dto.setMemo(memo);

  //dao선언
  IntroDao dao=new IntroDao();
  //insert메서드 호출
  dao.insertIntro(dto);

  //목록파일로 이동
  response.sendRedirect("d3_introList.jsp");
%>

--%>

<%  //방법2:
request.setCharacterEncoding("utf-8");
%>
	
<!-- jsp:useBean은 new로 객체 생성하는것과 같아 -->
<jsp:useBean id="dao" class="intro.model.IntroDao"/>
<jsp:useBean id="dto" class="intro.model.IntroDto"/>
<!-- dto의 멤버와 같은이름의 태그는 자동으로 읽어서 dto에 넣어준다 -->
<jsp:setProperty property="*" name="dto"/>

<%
	String [] hobby = request.getParameterValues("hobby");
	
	String myhobby="";
	
	if(hobby==null){
		myhobby="no";
	}else{
		for(int i=0;i<hobby.length;i++){
			myhobby += hobby[i]+",";
		}
		myhobby = myhobby.substring(0,myhobby.length()-1);
	}

	dto.setHobby(myhobby);
	dao.insertIntro(dto);

	//목록파일로 이동
	response.sendRedirect("d3_introList.jsp");

%>

</body>
</html>

