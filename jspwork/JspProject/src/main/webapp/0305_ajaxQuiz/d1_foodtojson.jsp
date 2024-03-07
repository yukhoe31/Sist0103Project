
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DbConnect"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
 <%
	DbConnect db = new DbConnect();
	Connection conn = db.getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql="select * from food order by num";
	
	try{
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		JSONArray arr = new JSONArray();
		
		while(rs.next()){
 			String num=rs.getString("num");
 			String foodname=rs.getString("foodname");
 			String foodphoto=rs.getString("foodphoto");
 			int price = rs.getInt("price");
 			int cnt = rs.getInt("cnt");		
		
			//자동으로 JSON화 시켜주는 도구
			JSONObject ob = new JSONObject();
			ob.put("num",num);
			ob.put("foodname",foodname);
			ob.put("foodphoto",foodphoto);
			ob.put("price",price);
			ob.put("cnt",cnt);
			
			//array에 추가
			arr.add(ob);

		}%>
		
		
		<%=arr.toString()%> 
		
	<%}catch(SQLException e){
		
	}finally{
		db.dbClose(rs, stmt, conn);
	}
%>   
    
    
