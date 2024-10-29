<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../../assets/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="../css/accountindex.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
</head>
</head>
<body>


	<section class="context-nei">

		<div class="select-option">


			<div class="select-menu">
				<div class="select-btn">
					<span class="sBtn-text">Profile</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="../../User_GetInformation"
						>Personal Information</a></li>
						<li><a class="option option-text" href="User_Update.jsp" id="User_Update"
						>Update Information</a></li>
				</ul>
			</div>

		</div>


		<div class="input-box">
			<i class="fa-regular fa-user"></i>
			<h1>
				PROFILE <br />MAINTENANCE
			</h1>
			<p>View personal information</p>
		</div>

	</section>

	<script src="../../assets/jquery-2.1.0.min.js"></script>
	<script src="../script/main.js"></script>
	<script>
  	$(function(){
  		$("#box-5").css("background","red");
  	})
  </script>
</body>
</html>