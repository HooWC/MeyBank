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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="../css/accountindex.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>


	<section class="context-nei">

		<div class="select-option">

			<div class="select-menu">
				<div class="select-btn">
					<span class="sBtn-text">MeyBank Account</span> <i
						class="bx bx-chevron-down"></i>
				</div>

					<ul class="options">
					<li><a class="option option-text" href="transaction_own1.jsp" id="transaction_own1">To own MB</a></li>
					<li><a class="option option-text" href="transaction1.jsp" id="MB_transfer">MB transfer</a></li>
				</ul>
			</div>

			<div class="select-menu">
				<div class="select-btn">
					<span class="sBtn-text">Other Bank Account</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="transaction_IBG1.jsp" id="IBG">Interbank GIRO (IBG)</a></li>
				</ul>

			</div>


		</div>


		<div class="input-box">
			<i class="fa-solid fa-arrow-right-arrow-left"></i>
			<h1>
				FUND <br />TRANSFER
			</h1>
			<p>Transfer money effortlessly</p>
		</div>

	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
  <script src="../script/main.js"></script>
  <script>
  	$(function(){
  		$("#box-2").css("background","red");
  	})
  </script>


</body>
</html>