
<%@page import="simpleboardanswer.model.SimpleAnswerDao"%>
<%@page import="simpleboardanswer.model.SimpleAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  //post방식
  request.setCharacterEncoding("utf-8");
  
  String num=request.getParameter("num");
  String nickname=request.getParameter("nickname");
  String content=request.getParameter("content");

  
  //dto
  SimpleAnswerDto dto=new SimpleAnswerDto();
  dto.setNum(num);
  dto.setNickname(nickname);
  dto.setContent(content);
  
  //dao
  SimpleAnswerDao dao=new SimpleAnswerDao();
  //insert
  dao.insertAnswer(dto);
  
%>