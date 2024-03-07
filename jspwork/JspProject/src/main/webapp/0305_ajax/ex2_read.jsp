<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String code=request.getParameter("scode");
   String name=request.getParameter("sname");
   String price=request.getParameter("price");
   String color=request.getParameter("color");

   //JSONObject 가 알아서 json형식으로 parsing해준다!
   JSONObject ob=new JSONObject();
   ob.put("code", code);
   ob.put("name", name);
   ob.put("price", price);
   ob.put("color", color);
%>

<%=ob.toString()%>