<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String num=request.getParameter("num");
  MemberDao dao=new MemberDao();
  dao.deleteMember(num);
  
  response.sendRedirect("../index.jsp?main=member/memberlist.jsp");
  
  
%>