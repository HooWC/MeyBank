<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<% 
Account account = (Account)session.getAttribute("Account");
int id = account.getAccountID(); 
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
<link rel="stylesheet" href="../css/bankaccount.css">
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

			<div class="select-menu active">
				<div class="select-btn">
					<span class="sBtn-text">Account Summary</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="account.jsp"
						id="Bank_Account">Bank Account</a></li>
				</ul>
			</div>

			<div class="select-menu">
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
			<h1>Account Summary</h1>
			<div class="container-table-box">
				<table
					class="table table-bordered table-striped table-responsive-stack"
					id="tableTwo">
					<thead class="thead-dark">
						<tr>
							<th>Account No</th>
							<th>Account Type</th>
							<th>Currency</th>
							<th>Available Balance</th>
							<th>Current Balance</th>
						</tr>
					</thead>
					<tbody id="tbody">

					</tbody>
				</table>

			</div>
		</div>


	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/bankaccount.js"></script>
	<script>
  	$(function(){
  		
  		$("#box-1").css("background","red");
  		$("#Bank_Account").css("background","red");
  		
  		$.ajax({
				url:"../../AjaxFunction",
				type:"POST",
				data:{
					"AccountData":$("#id").html(),
					"Action":"getAllBankAccount_To_View"
				},
				dataType:"json",
				success:function(data){
					
 					$("#tbody").empty();
					$.each(data,function(x,y){
						
						var type = y.AccountType;
						var bal = 0;
						if(type == "Saving Account"){
							bal = 20;
						}else{
							bal = 250;
						}
						
						var balance = y.Balance - bal;
						if(balance < 0){
							balance = 0;
						}
						
						$("#tbody").append(`
							<tr>
								<td>${"${y.BankAccNo}"}</td>
								<td>${"${y.AccountType}"}</td>
								<td>MYR</td>
								<td>${"${balance.toFixed(2)}"}</td>
								<td>${"${y.Balance.toFixed(2)}"}</td>
							</tr>
						`)
						
					})
					
					$( '.table-responsive-stack' ).each(function() {
						  var thCount = $(this).find("th").length; 
						   var rowGrow = 100 / thCount + '%';
						   $(this).find("th, td").css('flex-basis', rowGrow);   
					});

					
				}
		})
		
  		
  		
  	})
  </script>

</body>
</html>