<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.CartDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>

<%
request.setCharacterEncoding("utf-8");

String shopnum = request.getParameter("shopnum");
String num = request.getParameter("num");
int cnt = Integer.parseInt(request.getParameter("cnt")); // Convert String to int

ShopDao dao = new ShopDao();
CartDto dto = new CartDto();

dto.setShopnum(shopnum);
dto.setNum(num);
dto.setCnt(cnt);

dao.insertCart(dto);
%>



