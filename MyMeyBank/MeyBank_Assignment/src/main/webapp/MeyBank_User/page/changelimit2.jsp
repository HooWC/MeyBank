
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<%
Account account = (Account) session.getAttribute("Account");
List<BankAccount> bank_list = (List<BankAccount>) session.getAttribute("banklist");
BankAccount mybank = (BankAccount) session.getAttribute("changelimitbank");
String limit = String.format("%.2f", mybank.getCardLimit()).toString();
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
	String otptime = (String) session.getAttribute("MBTROTHER");
	String MBTROTHEROTP = (String) session.getAttribute("MBTROTHEROTP");
	session.setAttribute("MBTROTHER", "");
	session.setAttribute("MBTROTHEROTP", "");
	if (otptime == null) {
		otptime = "";
	}
	if (MBTROTHEROTP == null) {
		MBTROTHEROTP = "";
	}
	%>

	<h1 id="otptime" style="display: none;"><%=MBTROTHEROTP%></h1>


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

			<form action="../../Changelimit" method="post">
				<div class="container-table-box">

					<div class="item-bankchange2">

						<div class="item-child2">
							<p class="fitst-p">Bank Account No</p>
							<p class="fitst-p2"><%=mybank.getBankAccNo()%>(<%=mybank.getAccountType()%>)
							</p>
						</div>

						<div class="item-child2">
							<p class="fitst-p">Current Daily Transfer Limit</p>
							<p class="fitst-p2">
								RM
								<%=limit%></p>
						</div>

						<div class="item-child2">
							<p class="fitst-p">New Daily Transfer Limit</p>
							<div>
								<select class="form-control" id="selec1" name="selec1">
									<option value="3000">RM 3,000.00</option>
									<option value="5000">RM 5,000.00</option>
									<option value="8000">RM 8,000.00</option>
									<option value="10000">RM 10,000.00</option>
									<option value="15000">RM 15,000.00</option>
									<option value="20000">RM 20,000.00</option>
								</select>
							</div>
						</div>

						<div class="item-child2">
							<p class="fitst-p">PAC</p>
							<div>
								<input type="text" class="form-control form-control-input"
									id="otp12" name="otp12" onkeyup="value=value.replace(/\D/g,'')"
									onafterpaste="value=value.replace(/\D/g,'')">
								<p id="otptext" style="display: none;">
									there is still time <span id="time1" style="color: red;">120</span><span
										style="color: red;"> s</span>
								</p>
							</div>
						</div>

					</div>
				</div>

				<section class="section-box-acc">
					<div class="btn-hr">
						<a href="changelimit.jsp" class="btn btn-danger">Cancel</a> <a
							href="../../Tr_OTP?Action=limit" class="btn btn-danger">Request
							PAC Now</a>
						<button type="submit" class="btn btn-danger" id="btnn"
							style="visibility: hidden;">Confirm</button>
					</div>
				</section>


			</form>

		</div>


	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/transaction1.js"></script>
	<script>
		if ($("#otptime").html() != "") {
			daojishi();
			$("#otptext").css("display", "block");
		}

		function daojishi() {
			var starttime = document.getElementById("time1").innerHTML;
			if (starttime == 0) {
				window.location.href = "../../MeyBank_Home/page/home.jsp";
			}

			setTimeout("daojishi()", 1000);
			starttime--;
			document.getElementById("time1").innerHTML = starttime;
		}

		$(function() {

			$("#box-2").css("background", "red");
			$("#Transferlimit").css("background", "red");

			$("#otp12").keyup(function() {
				var value = $(this).val();
				var otp = $("#otptime").html();
				if (value == otp) {
					$("#btnn").css("visibility", "visible");
				} else {
					$("#btnn").css("visibility", "hidden");
				}
			})

		})
	</script>

</body>
</html>