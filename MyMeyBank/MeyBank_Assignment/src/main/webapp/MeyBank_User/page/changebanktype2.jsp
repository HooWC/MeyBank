
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<% 
Account account = (Account)session.getAttribute("Account");
BankAccount bank = (BankAccount)session.getAttribute("changebanktype");
int id = account.getAccountID();
String balance = String.format("%.2f", bank.getBalance()).toString();
String limit = String.format("%.2f", bank.getCardLimit()).toString();

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
<link rel="stylesheet" href="../css/changebanktype.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

</head>
<body>

	<h1 id="id" style="display: none"><%= id %></h1>

	<section class="context-nei">

		<div class="select-option">

			<div class="select-menu">
				<div class="select-btn">
					<span class="sBtn-text">Account Summary</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="account.jsp"
						id="Bank_Account">Bank Account</a></li>
				</ul>
			</div>

			<div class="select-menu active">
				<div class="select-btn">
					<span class="sBtn-text">Saving / Current Account</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="changebanktype1.jsp"
						id="changebanktype1">Change bankaccount type</a></li>
					<li><a class="option option-text" href="changelimit.jsp" id="Transferlimit">Transfer
							limit amount</a></li>
					<li><a class="option option-text" href="new_bankaccount.jsp"
						id="newbankaccount">New Bank Account</a></li>
				</ul>
			</div>


		</div>


		<div class="input-box">

			<h1 class="input-box-title">Change Bankaccount Type</h1>
			<p class="input-box-title-p">Replace Saving / Current bank type
				(S/C)</p>

			<div class="container-xx">
				<div class="steps-xx">
					<span class="circlexx active"></span> <span class="circlexx active"></span>
					<span class="circlexx"></span>
					<div class="progress-barxx">
						<span class="indicatorxx"></span>
					</div>
				</div>
			</div>

			<div class="container-table-box">

				<div class="item-bankchange2">

					<div class="item-child2">
						<p class="fitst-p">Bank Account No</p>
						<p><%= bank.getBankAccNo() %></p>
					</div>

					<div class="item-child2">
						<p class="fitst-p">Account Type</p>
						<p class="fitst-p2"><%= bank.getAccountType() %></p>
					</div>

					<div class="item-child2">
						<p class="fitst-p">Card Number</p>
						<p class="fitst-p2"><%= bank.getCardNumber() %></p>
					</div>

					<div class="item-child2">
						<p class="fitst-p">Pin Number</p>
						<p>***</p>
					</div>

					<div class="item-child2">
						<p class="fitst-p">Current Balance</p>
						<p>
							RM
							<%= balance %></p>
					</div>

					<div class="item-child2">
						<p class="fitst-p">Card Limit</p>
						<p>
							RM
							<%= limit %></p>
					</div>


				</div>

			</div>

			<section class="section-box-acc">
				<div class="box-acc">
					<p class="box-acc-title">Note:</p>

					<ul>
						<li>This service is only available within out Operating Hours
							12:15 a.m - 12 midnight.</li>
						<li>The service fees or transactional changes payable shall
							be inclusice of 6% Goods and Services RM0.20</li>
						<li>Saving Account must have a minimum of RM20.00</li>
						<li>Current Account must have a minimum of RM250.00</li>
					</ul>
				</div>

				<div class="btn-hr">
					<a href="changebanktype1.jsp" class="btn btn-danger">Back</a> <a
						href="changebanktype3.jsp" class="btn btn-danger">Next</a>
				</div>
			</section>


		</div>


	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/changebanktype.js"></script>
	<script>
  	$(function(){
  		
  		$("#box-1").css("background","red");
  		$("#changebanktype1").css("background","red");
  		
  	})
  </script>

</body>
</html>