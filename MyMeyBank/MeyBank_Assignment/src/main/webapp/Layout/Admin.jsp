<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Models.*"%>

    
    <%
    	Admin admin = (Admin)session.getAttribute("Admin");
		if(admin == null){
			response.sendRedirect("../../Admin/page/Login.jsp");
			return;
		}
%>