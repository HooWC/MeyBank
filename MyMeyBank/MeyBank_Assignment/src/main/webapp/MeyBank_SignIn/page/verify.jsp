<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String otp = (String)session.getAttribute("forgetpasswordotp");
	if(otp == null){
		response.sendRedirect("../../MeyBank_Home/page/home.jsp");
		return;
	}
%>
    
<!DOCTYPE html>
<!-- Coding by CodingLab || www.codinglabweb.com -->
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/verify.css" />
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
  </head>
  <body>
    
    <div class="container">
      <header>
        <i class="bx bxs-check-shield"></i>
      </header>
      <h4 style="color:white;">Enter OTP Code</h4>
      <form action="../../verify" method="post">
        <div class="input-field">
          <input type="number" name="n1"/>
          <input type="number" name="n2" disabled />
          <input type="number" name="n3" disabled />
          <input type="number" name="n4" disabled />
        </div>
        <button type="submit">OTP<span id="time1" style="color:red;padding-left: 10px;">120</span><span style="color:red;"> s</span></button>
      </form>
    </div>

    <script src="../script/verify.js"></script>
    <script>

        daojishi();

        function daojishi(){
            var starttime = document.getElementById("time1").innerHTML;
            if(starttime == 0){
            	window.location.href="../../MeyBank_Home/page/home.jsp";
            }

            setTimeout("daojishi()",1000);
            starttime--;
            document.getElementById("time1").innerHTML = starttime;
        }

    </script>
  </body>
</html>


