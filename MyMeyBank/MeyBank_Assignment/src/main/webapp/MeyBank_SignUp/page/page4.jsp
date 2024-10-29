<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String page3 = (String)session.getAttribute("page3");
	if(page3 == null){
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
    <div class="container sign-up-mode">
      <div class="forms-container">
        <div class="signin-signup">

          <div class="container-xx">
            <div class="steps-xx">
              <span class="circlexx active">1</span>
              <span class="circlexx active">2</span>
              <span class="circlexx active">3</span>
              <span class="circlexx active">4</span>
              <div class="progress-barxx">
                <span class="indicatorxx"></span>
              </div>
            </div>
          </div>

          <form action="../../page4" method="post" class="sign-up-form">
            <h2 class="title">MAKE SURE ALL <br/>INFORMATION IS CORRECT</h2>
            <br/>
            <input type="submit" class="btn" value="Submit" />
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
          <img src="../../image/undraw_Adventure_re_ncqp-removebg-preview.png" class="image" alt="" />
        </div>
      </div>
    </div>

   	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
  </body>
</html>
