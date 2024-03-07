<%@page import="myworld.model.WorldDto"%>
<%@page import="myworld.model.WorldDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
<%

	WorldDao dao = new WorldDao();
	//목록
	List<WorldDto> list = dao.getAllMyWorld();
	SimpleDateFormat sdf = new SimpleDateFormat();
	
	
	JSONArray arr = new JSONArray();
	
	for(WorldDto dto:list){
		
		JSONObject ob = new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("writer",dto.getWriter());
		ob.put("content",dto.getContent());
		ob.put("avata",dto.getAvata());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		//arr에 추가
		arr.add(ob);

	}
	
%>   

<%=arr.toString() %>


    