<%@page import="simpleboardanswer.model.SimpleAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
  String num=request.getParameter("num");
  SimpleAnswerDao dao=new SimpleAnswerDao();
  dao.deleteAnswer(num);
%>