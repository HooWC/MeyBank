
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@page import="AppDBContext.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<% 
api_Account api_acc = new api_Account();
api_User api_user = new api_User();
api_BankAccount api_bank = new api_BankAccount();
Account account = (Account)session.getAttribute("Account");
api_acc.getKEY(acc.getUsername(), acc.getPassword());
List<BankAccount> b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
session.setAttribute("banklist", b_list);
List<BankAccount> bank_list = (List<BankAccount>)session.getAttribute("banklist");
BankAccount Otherbank = (BankAccount)session.getAttribute("OtherBankAccountown");
BankAccount mybank = (BankAccount)session.getAttribute("tr1Bankown");
Transaction Othertr = (Transaction)session.getAttribute("tr1own");
String amount = String.format("%.2f", Othertr.getAmount()).toString();
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

			<h1 class="input-box-title">Other MeyBank Account</h1>
			<p class="input-box-title-p">Transfer Other MeyBank Account
				(TOMA)</p>

			<div class="container-xx">
				<div class="steps-xx">
					<span class="circlexx active"></span> <span class="circlexx active"></span>
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
						<p class="fitst-p">Beneficiary Bank</p>
						<p class="fitst-p2">MeyBank</p>
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
					
				</div>

			</div>

				<section class="section-box-acc">

				
				<div class="btn-hr">
                	<a href="transaction_index.jsp" class="btn btn-danger">Back</a>
                	<a href="transaction_index.jsp" class="btn btn-danger">Confirm</a>
            	</div>
			</section>



		</div>


	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/transaction1.js"></script>
	<script>
	
  	$(function(){
  		
  		$("#box-2").css("background","red");
  		$("#transaction_own1").css("background","red");
  		
  		
  	})
  </script>

</body>
</html>