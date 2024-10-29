<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="../css/forget.css">
        <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>

        <title>Login form responsive</title>  
    </head>
    <body>
    
    <%
		String msg = (String)session.getAttribute("errorforgetpassword");
		if(msg == null){
			msg = "";
		}
	%>
    
        <div class="l-form">
            <div class="shape1"></div>
            <div class="shape2"></div>

            <div class="form">
                <img src="../../image/authentication.svg" alt="" class="form__img">

                <form action="../../forgetpassword" method="post" class="form__content">
                    <h1 class="form__title">Forgot Password</h1>
                    <p style="color:red;text-align:center;font-family: 'Raleway', sans-serif;font-size:0.8rem;"><%= msg %></p>

                    <div class="form__div form__div-one">
                        <div class="form__icon">
                            <i class='bx bx-user-circle'></i>
                        </div>

                        <div class="form__div-input">
                            <label for="" class="form__label">Card Number</label>
                            <input type="text" class="form__input" name="card" maxlength="16" id="card">
                        </div>
                    </div>

                    <div class="form__div">
                        <div class="form__icon">
                            <i class='bx bx-lock' ></i>
                        </div>

                        <div class="form__div-input">
                            <label for="" class="form__label">Pin Number</label>
                            <input type="password" class="form__input" name="pin" maxlength="3" id="pin">
                        </div>
                    </div>
                    <br/>
                    <input type="submit" class="form__button" value="Submit" id="sure" disabled>
                    <input type="button" id="banktohome" class="form__button" value="Bank To Login">
                </form>
            </div>

        </div>
        
        <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
        <script src="../script/forget.js"></script>
        <script>
    	$(function(){
    		$("#banktohome").click(function(){
    			window.location.href="signin.jsp";
    		})
    		
    		var cardnumber = false;
    		var pinnumber = false;
    		
    		
    		$("#card").keyup(function(){
    			if($(this).val() != "" && $(this).val().length == 16){
    				cardnumber = true;
    			}else{
    				cardnumber = false;
    			}
    			CheckOPen(cardnumber,pinnumber);
    		})
    		
    		$("#pin").keyup(function(){
    			if($(this).val() != "" && $(this).val().length == 3){
    				pinnumber = true;
    			}else{
    				pinnumber = false;
    			}
    			CheckOPen(cardnumber,pinnumber);
    		})
    		
    		function CheckOPen(cardnumber,pinnumber){
    			if(cardnumber == true && pinnumber == true){
    				$("#sure").prop("disabled",false);
    			}else{
    				$("#sure").prop("disabled",true);
    			}
    		}
    		
    	})
    </script>
    </body>
</html>