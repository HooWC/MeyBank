<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>

  <%
		String msg = (String)session.getAttribute("adminlogin");
		if(msg == null){
			msg = "";
		}
	%>
    

    <div id="login-page">
        <div class="login">
          <h2 class="login-title">Admin Login</h2>
          <p class="notice">Please login to access the system</p>
          <p style="color:red;"><%= msg %></p>
          <form action="../../admin_login" method="post" class="form-login">
            <label for="email">Username</label>
            <div class="input-email">
              <i class="fas fa-envelope icon"></i>
              <input type="text" id="userid" name="userid" placeholder="Enter your username" required>
            </div>
            <label for="password">Password</label>
            <div class="input-password">
              <i class="fas fa-lock icon"></i>
              <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit"><i class="fas fa-door-open"></i> Sign in</button>
          </form>
<!--             <a href="#">Forgot your password?</a> -->
          <div class="created">
            <p>Created by <a href="https://codepen.io/kelvinqueiroz/">Hoo</a></p>
          </div>
        </div>
        <div class="background">
         
        </div>
      </div>


 	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <script src="./script.js"></script>
</body>
</html>