
<%@page import="data.dao.SmartAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
  String idx=request.getParameter("idx");
  SmartAnswerDao dao=new SmartAnswerDao();
  dao.deleteSmartAnswer(idx);
  
 // response.sendRedirect("../0314_simpleboard/contentview.jsp");
%>