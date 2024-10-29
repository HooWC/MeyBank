<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="../css/style.css" />
    <title>Sign in & Sign up Form</title>
  </head>
  <body>

    <%
		String msg = (String)session.getAttribute("errorpage1");
		if(msg == null){
			msg = "";
		}
	%>

    <div class="container sign-up-mode">

      <div class="forms-container">
        <div class="signin-signup">

          <div class="container-xx">
            <div class="steps-xx">
              <span class="circlexx active">1</span>
              <span class="circlexx">2</span>
              <span class="circlexx">3</span>
              <span class="circlexx">4</span>
              <div class="progress-barxx">
                <span class="indicatorxx"></span>
              </div>
            </div>
          </div>
          
          <form action="../../page1" method="post" class="sign-up-form">
          
            <h2 class="title">SIGN UP</h2>
            <p style="color:red"><%= msg %></p>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="FUll Name" name="fullname" id="fullname"/>
            </div>
            <div class="input-field">
              <i class="fas fa-envelope"></i>
              <input type="email" placeholder="Email" name="Email" id="email"/>
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="text" placeholder="NRIC" name="NRIC" id="nric" onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')"/>
            </div>
            <input type="text" style="display:none;" id="age" name="age">
            <input type="text" style="display:none;" id="birth" name="birth">
            <input type="text" style="display:none;" id="gender" name="gender">
            <input type="submit" id="btn-submit" class="btn" value="Next ➜" disabled/>
            
          </form>
        </div>
      </div>

      <div class="panels-container">
        <div class="panel left-panel">
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>One of us ?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum
              laboriosam ad deleniti.
            </p>
            <button class="btn transparent" id="sign-in-btn">
              <a style="text-decoration: none;color:white;" href="../../MeyBank_SignIn/page/signin.jsp">Sign in</a>
            </button>
          </div>
          <img src="../../image/register.svg" class="image" alt="" />
        </div>
      </div>
    </div>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <script src="../script/page1.js"></script>
    
  </body>
</html>
