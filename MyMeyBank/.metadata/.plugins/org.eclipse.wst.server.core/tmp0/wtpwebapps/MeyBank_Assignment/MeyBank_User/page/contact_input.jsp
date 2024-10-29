
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<% 
Account account = (Account)session.getAttribute("Account");
List<BankAccount> bank_list = (List<BankAccount>)session.getAttribute("banklist");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="../css/transaction1.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

</head>
<body>

  <%
		String msg = (String)session.getAttribute("transaction1error");
		if(msg == null){
			msg = "";
		}
	%>


	<section class="context-nei">

	<div class="select-option">

			
			<div class="select-menu active">
				<div class="select-btn">
					<span class="sBtn-text">Contact us</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="contact_input.jsp"
						id="contact">Contact</a></li>
				</ul>
			</div>


		</div>



		<div class="input-box">

			 <h1 class="input-box-title">Contact</h1>
       		<p class="input-box-title-p">Please contact us to solve the problem</p>
			
			<p id="error" style="color:red;font-weight: bold;font-size:0.9rem;padding:10px 0px 0px 60px;text-align:center;"><%= msg %></p>

			<form action="../../contactus" method="post">
				<div class="form-item">

					<div class="item-child">
						<p>Full Name</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="fullname" name="fullname" required>
						</div>
					</div>

					<div class="item-child">
						<p>Email</p>
						<div class="form-group-input">
							<input type="email" class="form-control form-control-input"
								id="email" name="email" required>
						</div>
					</div>

					<div class="item-child">
						<p>Phone</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="phone" name="phone" required onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')" required>
							<p>e.g. 0164486909 No(-)</p>
						</div>
					</div>

					<div class="item-child">
						<p>NRIC</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="nric" name="nric" required onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')" required>
						<p>e.g. 0452222222222 No(-)</p>
						</div>
					</div>
					
					<div class="item-child">
						<p>Content</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="content" name="content" required>
						</div>
					</div>
					
				</div>

				<section class="section-box-acc">

					<div class="btn-hr">
						<a href="contact_input.jsp" class="btn btn-danger">Reset</a>
						<a href="contact_index.jsp" type="button" class="btn btn-danger">Cancel</a>
						<button type="submit" class="btn btn-danger" id="btnn" disabled>Submit</button>
					</div>

				</section>
			</form>


		</div>


	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/transaction1.js"></script>
	<script>
  	$(function(){
  		
  		$("#box-8").css("background","red");
  		$("#contact").css("background","red");
  		
  		var fullname = false;
  		var email = false;
  		var phone = false;
  		var nric = false;
  		var content = false;
  		
  		
  		
  		$("#fullname").keyup(function(){
  			var value = $(this).val();
  			if(value != ""){
  				fullname = true;
  			}else{
  				fullname = false;
  			}
  			main(fullname,email,phone,nric,content);
  		})
  		
  		$("#email").keyup(function(){
  			var value = $(this).val();
  			if(value != "" && value.includes("@gmail.com")){
  				email = true;
  			}else{
  				email = false;
  			}
  			main(fullname,email,phone,nric,content);
  		})
  		
  		$("#phone").keyup(function(){
  			var value = $(this).val();
  			if(value != "" && value.length == 10){
  				phone = true;
  			}else{
  				phone = false;
  			}
  			main(fullname,email,phone,nric,content);
  		})
  		
  		$("#nric").keyup(function(){
  			var value = $(this).val();
  			if(value != "" && value.length == 12){
  				nric = true;
  			}else{
  				nric = false;
  			}
  			main(fullname,email,phone,nric,content);
  		})
  		
  		
  		$("#content").keyup(function(){
  			var value = $(this).val();
  			if(value != ""){
  				content = true;
  			}else{
  				content = false;
  			}
  			main(fullname,email,phone,nric,content);
  		})
  		
  		function main(fullname,email,phone,nric,content){
  			console.log("fullname  "+fullname)
  			console.log("email  "+email)
  			console.log("phone  "+phone)
  			console.log("nric  "+nric)
  			console.log("content  "+content)
  			if(fullname == true && email == true && phone == true && nric == true && content == true){
  				$("#btnn").prop("disabled",false);
  			}else{
  				$("#btnn").prop("disabled",true);
  			}
  		}
  		
  		
  	})
  </script>

</body>
</html>