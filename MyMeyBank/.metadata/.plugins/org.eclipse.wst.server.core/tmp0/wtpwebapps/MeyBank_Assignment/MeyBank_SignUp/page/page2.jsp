<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String page1 = (String)session.getAttribute("page1");
	if(page1 == null){
		response.sendRedirect("page1.jsp");
		return;
	}
%>
    
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
		String msg = (String)session.getAttribute("errorpage2");
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
              <span class="circlexx active">2</span>
              <span class="circlexx">3</span>
              <span class="circlexx">4</span>
              <div class="progress-barxx">
                <span class="indicatorxx"></span>
              </div>
            </div>
          </div>

          <form action="../../page2" method="post" class="sign-up-form">
            <h2 class="title">SIGN UP</h2>
            <p style="color:red"><%= msg %></p>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="User ID" name="userid" id="userid"/>
            </div>
            <div class="input-field">
              <i class="fas fa-envelope"></i>
              <input type="password" placeholder="Password (6 Digits)" name="password" id="password" maxlength="6"/>
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="text" placeholder="VerifyWord (16 Digits)" name="verifyWord" id="verifyWord" maxlength="16"/>
            </div>
            <input type="submit" class="btn" value="Next ➜" id="btn-submit" disabled/>
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
          <img src="../../image/undraw_Online_payments_re_y8f2-removebg-preview.png" class="image" alt="" />
        </div>
      </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <script src="../script/page2.js"></script>
  </body>
</html>
