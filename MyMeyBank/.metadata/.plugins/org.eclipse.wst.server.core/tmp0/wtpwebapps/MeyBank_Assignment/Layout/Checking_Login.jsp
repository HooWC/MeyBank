<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Models.*"%>

    
    <%
		Account acc = (Account)session.getAttribute("Account");
 		User user = (User)session.getAttribute("User");
 		String time = (String)session.getAttribute("lastlogintime");
		if(acc == null || acc == null || time == null){
			response.sendRedirect("../../MeyBank_Home/page/home.jsp");
			return;
		}
%>