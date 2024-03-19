
<%@page import="mem_gaip.model.MemgaipDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String m_num=request.getParameter("m_num");
  MemgaipDao dao=new MemgaipDao();
  
  dao.deleteMember(m_num);
  
  response.sendRedirect("memList.jsp");
  
%>