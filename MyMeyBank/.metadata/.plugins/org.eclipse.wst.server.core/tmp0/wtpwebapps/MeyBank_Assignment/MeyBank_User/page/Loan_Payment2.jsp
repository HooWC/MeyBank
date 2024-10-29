
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<% 

Account account = (Account)session.getAttribute("Account");
Account Otheracc = (Account)session.getAttribute("OtherAccount");
BankAccount Otherbank = (BankAccount)session.getAttribute("OtherBankAccount");
BankAccount mybank = (BankAccount)session.getAttribute("tr1Bank");
User Otheruser = (User)session.getAttribute("OtherUser");
Transaction Othertr = (Transaction)session.getAttribute("tr1");
String amount = String.format("%.2f", Othertr.getAmount()).toString();
String sms = String.format("%.2f", Othertr.getSMSNotification()).toString();
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
		String msg = (String)session.getAttribute("paymenterror");
		String otptime = (String)session.getAttribute("MBTROTHER");
		String MBTROTHEROTP = (String)session.getAttribute("MBTROTHEROTP");
		session.setAttribute("MBTROTHER", "");
		session.setAttribute("MBTROTHEROTP", "");
		if(msg == null){
			msg = "";
		}
		if(otptime == null){
			otptime = "";
		}
		if(MBTROTHEROTP == null){
			MBTROTHEROTP = "";
		}
	%>
	
	<h1 id="otptime" style="display:none;"><%= MBTROTHEROTP %></h1>


	<section class="context-nei">

		<div class="select-option">

			<div class="select-menu active">
				<div class="select-btn">
					<span class="sBtn-text">MB Loan/Financing Payment</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="Loan_Payment.jsp"
						id="Loan_Payment">Loan Payment</a></li>
				</ul>
			</div>


		</div>




		<div class="input-box">

			<h1 class="input-box-title">Loan Transfer</h1>
			<p class="input-box-title-p">Various Loan Transfers (VL/T)</p>

			<div class="container-xx">
				<div class="steps-xx">
					<span class="circlexx active"></span> <span class="circlexx active"></span>
					<span class="circlexx"></span>
					<div class="progress-barxx">
						<span class="indicatorxx"></span>
					</div>
				</div>
			</div>

			<p id="error"
				style="color: red; font-weight: bold; font-size: 0.9rem; padding: 10px 0px 0px 60px; text-align: center;"><%= msg %></p>

			<div class="container-table-box">

				<div class="item-bankchange2">

					<div class="item-child2">
						<p class="fitst-p">From Account</p>
						<p class="fitst-p2"><%= mybank.getBankAccNo() %>(<%= mybank.getAccountType()%>)</p>
					</div>

					<div class="item-child2">
						<p class="fitst-p">Beneficiary Account No</p>
						<p class="fitst-p2"><%= Othertr.getCredit() %></p>
					</div>
					
					<div class="item-child2">
						<p class="fitst-p">Transaction Amount</p>
						<p class="fitst-p2">
							RM
							<%= amount %></p>
					</div>
					
					<div class="item-child2">
						<p class="fitst-p">Instant Transfer Service Change</p>
						<p class="fitst-p2">
							RM
							<%= sms %></p>
					</div>
					
					<div class="item-child2">
						<p class="fitst-p">PAC</p>
						<div>
							<input type="text" class="form-control form-control-input"
								id="otp12" name="otp12" onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')">
							<p id="otptext" style="display:none;">there is still time <span id="time1" style="color:red;">120</span><span style="color:red;"> s</span></p>
						</div>
					</div>


				</div>

			</div>

				<section class="section-box-acc">

				
				<div class="btn-hr">
                	<a href="transaction_index.jsp" class="btn btn-danger">Cancel</a>
                	<a href="../../Tr_OTP?Action=Payment" class="btn btn-danger">Request PAC Now</a>
                	<a href="../../PayMentTR?Action=Payment" class="btn btn-danger" id="btnn" style="visibility: hidden;">Confirm</a>
            	</div>
			</section>



		</div>


	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/transaction1.js"></script>
	<script>
	
	if($("#otptime").html() != ""){
	 	daojishi();
	 	$("#otptext").css("display","block");
	}
	
	 function daojishi(){
         var starttime = document.getElementById("time1").innerHTML;
         if(starttime == 0){
         	window.location.href="../../MeyBank_Home/page/home.jsp";
         }

         setTimeout("daojishi()",1000);
         starttime--;
         document.getElementById("time1").innerHTML = starttime;
     }
	
  	$(function(){
  		
  		$("#box-3").css("background","red");
  		$("#Loan_Payment").css("background","red");
  		
  		$("#otp12").keyup(function(){
  			var value = $(this).val();
  			var otp = $("#otptime").html();
  			if(value == otp){
  				$("#btnn").css("visibility","visible");
  			}else{
  				$("#btnn").css("visibility","hidden");
  			}
  		})
  		
  	})
  </script>

</body>
</html>