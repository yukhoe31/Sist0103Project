<%@page import="org.json.simple.JSONObject"%>
<%@page import="simpleboardanswer.model.SimpleAnswerDao"%>
<%@page import="simpleboardanswer.model.SimpleAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String idx = request.getParameter("idx");
	SimpleAnswerDao dao = new SimpleAnswerDao();
	SimpleAnswerDto dto =dao.getAnswerData(idx);
	
	JSONObject ob = new JSONObject();
	ob.put("idx", dto.getIdx());
	ob.put("nickname", dto.getNickname());
	ob.put("content",dto.getContent());

%>

<%=ob.toString() %>