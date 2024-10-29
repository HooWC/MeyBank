<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String page2 = (String)session.getAttribute("verifyset");
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
		String id = (String)session.getAttribute("id");
 		String msg = (String)session.getAttribute("passworderror");
		if(id == null){
			id = "";
		}
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
		<div class="login-content">
			<form action="../../passwords" method="post">
			
				<img src="../../image/avatar.svg">
				<h2 class="title">Welcome</h2>
				<p style="color:red;font-size:1rem;"><%= msg %></p>
           		<div class="input-div one focus">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Username</h5>
           		   		<input id="id" name="id" type="text" class="input" value="<%= id %>" disabled>
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Password</h5>
           		    	<input id="pass" name="pass" type="password" class="input" maxlength="6">
            	   </div>
            	</div>
            	<a href="forgetpassword.jsp">Forgot Password?</a>
            	<input type="submit" class="btn" value="Login" id="btnn" disabled>
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
    		
    		var pass = false;
    		
    		$("#pass").keyup(function(){
    			if($(this).val() != "" && $(this).val().length == 6){
    				pass = true;
    			}else{
    				pass = false;
    			}
    			CheckOPen(pass);
    		})
    		
    		function CheckOPen(pass){
    			if(pass == true){
    				$("#btnn").prop("disabled",false);
    			}else{
    				$("#btnn").prop("disabled",true);
    			}
    		}
    	})
    </script>
    
</body>
</html>