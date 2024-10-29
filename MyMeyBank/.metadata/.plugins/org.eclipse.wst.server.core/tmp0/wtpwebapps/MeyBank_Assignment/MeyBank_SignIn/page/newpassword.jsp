<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String verifyotp = (String)session.getAttribute("verifyotp");
	if(verifyotp == null){
		response.sendRedirect("../../MeyBank_Home/page/home.jsp");
		return;
	}
%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/newpassword.css">
    <title>Login Form</title>
</head>

<body>

	<%
		String msg = (String)session.getAttribute("newpassworderror");
		if(msg == null){
			msg = "";
		}
	%>

    <div class="container">
        <!-- login form -->
        <div class="login-wrap active">
            <div class="title">
                <h1>NEW PASSWORD</h1>
                
            </div>

            <form action="../../newpassword" method="post" >
                <div class="input-area">
                    <input type="password" id="password" name="newpassword" required maxlength="6">
                    <label for="password">Password</label>
                </div>
                <p style="color:red;text-align:center;font-family: 'Raleway', sans-serif;font-size:1rem;"><%= msg %></p>

                <div class="button-area">
                    <button type="submit" class="login-btn" id="btnn" disabled>Submit</button>
                </div>
            </form>

        </div>

    </div>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <script src="../script/newpassword"></script>
    <script>
    $(function(){
    	
    	$("#password").keyup(function(){
    		if($(this).val() != "" && $(this).val().length == 6){
    			$("#btnn").prop("disabled",false);
    		}else{
    			$("#btnn").prop("disabled",true);
    		}
    	})
    		
    })
    
    </script>
</body>

</html>