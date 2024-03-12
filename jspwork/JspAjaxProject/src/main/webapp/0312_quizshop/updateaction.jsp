<%@page import="quizshop.model.QuizShopDao"%>
<%@page import="quizshop.model.QuizShopDto"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="ajaxboard.AjaxBoardDto"%>
<%@page import="ajaxboard.AjaxBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

request.setCharacterEncoding("utf-8");

String num = request.getParameter("unum");
String sang_name = request.getParameter("usang_name");
String photo = request.getParameter("uphoto");
String price = request.getParameter("uprice");
String ipgoday = request.getParameter("uipgoday");


//dto
QuizShopDto dto = new QuizShopDto();
dto.setNum(num);
dto.setSang_name(sang_name);
dto.setPhoto(photo);
dto.setPrice(price);
dto.setIpgoday(ipgoday);


//dao
QuizShopDao dao = new QuizShopDao();
dao.updateQuiz(dto);

response.sendRedirect("shoplist.jsp");

%>