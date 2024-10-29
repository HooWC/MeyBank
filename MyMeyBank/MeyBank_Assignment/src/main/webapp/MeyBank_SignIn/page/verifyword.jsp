<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String page2 = (String)session.getAttribute("id");
	if(page2 == null){
		response.sendRedirect("signin.jsp");
		return;
	}
%>
    
<!DOCTYPE html>
<html>
<head>
	<title>Animated Login Form</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

 <%
		String msg = (String)session.getAttribute("verifycode");
		if(msg == null){
			msg = "";
		}
	%>

	<h1 class="my-title">MeyBank</h1>
	<img class="wave" src="../../image/wave.png">
	<div class="container">
		<div class="img">
			<img src="../../image/login form.svg">
		</div>
		<div class="login-content" >
			<form action="../../verifyword" method="post">
			
				<img src="../../image/avatar.svg">
				<h2 class="title" style="font-size:2rem;">This is your verification code?</h2>
				
				<p class="pword" style="padding:10px;background:black;border-radius:10px;color:white;font-size:1rem;"><%= msg %></p>
				
            	<input type="submit" class="btn" value="Next ➜" id="btnn">
				<input type="button" id="banktohome" class="btn" value="Bank To Home">
				
            </form>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="../script/main.js"></script>
    <script>
    	$(function(){
    		$("#banktohome").click(function(){
    			window.location.href="../../MeyBank_Home/page/home.jsp";
    		})
    	})
    </script>
    
</body>
</html>