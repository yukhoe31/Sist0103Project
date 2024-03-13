<%@page import="quizshop.model.QuizShopDao"%>
<%@page import="quizshop.model.QuizShopDto"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="ajaxboard.AjaxBoardDto"%>
<%@page import="ajaxboard.AjaxBoardDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--
<%

request.setCharacterEncoding("utf-8");

String unum = request.getParameter("unum");
String usang_name = request.getParameter("usang_name");
String uphoto = request.getParameter("uphoto");
String uprice = request.getParameter("uprice");
String uipgoday = request.getParameter("uipgoday");


//dto
QuizShopDto dto = new QuizShopDto();
dto.setNum(unum);
dto.setSang_name(usang_name);
dto.setPhoto(uphoto);
dto.setPrice(uprice);
dto.setIpgoday(uipgoday);


//dao
QuizShopDao dao = new QuizShopDao();
dao.updateQuiz(dto);

response.sendRedirect("shoplist.jsp");

%>

--%>

<%

request.setCharacterEncoding("utf-8");//이걸 먼저 써줘야 한글이 저장된다.
%>

<jsp:useBean id="dao" class="quizshop.model.QuizShopDao"/>
<jsp:useBean id="dto" class="quizshop.model.QuizShopDto"/>
<jsp:setProperty property="*" name="dto"/>
<%

dao.updateQuiz(dto);
response.sendRedirect("shoplist.jsp");
%>