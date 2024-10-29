
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@page import="AppDBContext.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<%
api_Account api_acc = new api_Account();
api_User api_user = new api_User();
api_BankAccount api_bank = new api_BankAccount();
Account account = (Account) session.getAttribute("Account");
api_acc.getKEY(acc.getUsername(), acc.getPassword());
List<BankAccount> b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
session.setAttribute("banklist", b_list);
List<BankAccount> bank_list = (List<BankAccount>) session.getAttribute("banklist");
String[] banktype_list = (String[]) session.getAttribute("banktype_list");
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
	String msg = (String) session.getAttribute("transaction1errorIBG");
	if (msg == null) {
		msg = "";
	}
	%>


	<section class="context-nei">

		<div class="select-option">

			<div class="select-menu">
				<div class="select-btn">
					<span class="sBtn-text">MeyBank Account</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="transaction_own1.jsp"
						id="transaction_own1">To own MB</a></li>
					<li><a class="option option-text" href="transaction1.jsp"
						id="MB_transfer">MB transfer</a></li>
				</ul>
			</div>

			<div class="select-menu active">
				<div class="select-btn">
					<span class="sBtn-text">Other Bank Account</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="transaction_IBG1.jsp"
						id="IBG">Interbank GIRO (IBG)</a></li>
				</ul>

			</div>


		</div>



		<div class="input-box">

			<h1 class="input-box-title">Other MeyBank Account</h1>
			<p class="input-box-title-p">Transfer Other MeyBank Account
				(TOMA)</p>

			<div class="container-xx">
				<div class="steps-xx">
					<span class="circlexx active"></span> <span class="circlexx"></span>
					<span class="circlexx"></span>
					<div class="progress-barxx">
						<span class="indicatorxx"></span>
					</div>
				</div>
			</div>

			<p id="error"
				style="color: red; font-weight: bold; font-size: 0.9rem; padding: 10px 0px 0px 60px; text-align: center;"><%=msg%></p>

			<form action="../../IBG1" method="post">
				<div class="form-item">

					<div class="item-child">
						<p>From Account</p>
						<div class="form-group">
							<select class="form-control" id="selec1" name="selec1">
								<%
									for (BankAccount i : bank_list) {
								%>
								<%
										String type = i.getAccountType();
										double d = 0;
										if(type.equals("Saving Account")){
											d = 20;
										}else{
											d = 250;
										}
										
										double bal = i.getBalance() - d;
										if(bal < 0){
											bal = 0;
										}
										
										String balance = String.format("%.2f", bal).toString();
								%>
								<option><%=i.getBankAccNo()%>(RM
									<%=balance%>)
								</option>
								<%
								}
								%>
							</select>
						</div>
					</div>

					<div class="item-child">
						<p>Beneficiary Bank</p>
						<div class="form-group">
							<select class="form-control" id="selec12" name="selec12">
								<%
								for (String i : banktype_list) {
								%>
								<option><%=i%></option>
								<%
								}
								%>
							</select>
						</div>
					</div>

					<div class="item-child">
						<p>Beneficiary Account No*</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="selec2" name="selec2"
								onkeyup="value=value.replace(/\D/g,'')"
								onafterpaste="value=value.replace(/\D/g,'')">
							<p>e.g. 4346501811</p>
						</div>
					</div>

					<div class="item-child">
						<p>Recipient Reference*</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="selec3" name="selec3">
						</div>
					</div>

					<div class="item-child">
						<p>Other Payment Details</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="selec4" name="selec4">
							<p>e.g. April Loan Payment</p>
						</div>
					</div>

					<div class="item-child">
						<p>Transaction Amount (RM)</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="selec5" name="selec5"
								onkeyup="value=value.replace(/\D/g,'')"
								onafterpaste="value=value.replace(/\D/g,'')">
							<p style="color: blue; margin: 0px;">By system default, your
								name will be disclosed to the beneficiary.</p>
							<p style="color: blue">Please click "Accept" to proceed or
								click "Cancel" if you do not wish to continue.</p>
						</div>
					</div>

				</div>

				<section class="section-box-acc">
					<div class="box-acc">
						<p class="box-acc-title">Optional Field</p>
						<div class="box-acc-part">
							<p class="box-acc-part-p">Notity Beneficiary By</p>
							<div class="box-oart-two">
								<div>
									<div class="box-input-part">
										<label class="label-class"><input type="checkbox"
											value="" id="opt1open" name="opt1open"> Email </label> <input
											type="text" class="form-control" id="opt1" name="opt1"
											disabled>
									</div>
									<p>(Please insert beneficiary's email address)</p>
								</div>
								<div>
									<div class="box-input-part">
										<label class="label-class" style="margin-right: 15px;"><input
											type="checkbox" value="" id="opt2open" name="opt2open">SMS</label>
										<input type="text" class="form-control" id="opt2" name="opt2"
											onkeyup="value=value.replace(/\D/g,'')"
											onafterpaste="value=value.replace(/\D/g,'')" disabled>
									</div>
									<p>(Please insert beneficiary's moble phone number,i.o.
										012123456(without'-'))</p>
									<p>RM0.20 service change applies</p>
								</div>
							</div>
						</div>
					</div>

					<div class="btn-hr">
						<a href="transaction1.jsp" class="btn btn-danger">Reset</a> <a
							href="transaction_index.jsp" type="button" class="btn btn-danger">Cancel</a>
						<button type="submit" class="btn btn-danger" id="btnn" disabled>Next</button>
					</div>

				</section>
			</form>


		</div>


	</section>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/transaction1.js"></script>
	<script>
		$(function() {

			$("#box-2").css("background", "red");
			$("#IBG").css("background", "red");

			var sel2 = false;
			var sel3 = false;
			var sel4 = false;
			var sel5 = false;
			var opt1open = false;
			var opt2open = false;
			var opt1 = true;
			var opt2 = true;

			$("#selec2").keyup(function() {
				var value = $(this).val();
				if (value != "") {
					sel2 = true;
				} else {
					sel2 = false;
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			$("#selec3").keyup(function() {
				var value = $(this).val();
				if (value != "") {
					sel3 = true;
				} else {
					sel3 = false;
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			$("#selec4").keyup(function() {
				var value = $(this).val();
				if (value != "") {
					sel4 = true;
				} else {
					sel4 = false;
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			$("#selec5").keyup(function() {
				var value = $(this).val();
				var num = parseInt(value);
				if (num > 0 && value != "") {
					sel5 = true;
				} else {
					sel5 = false;
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			$("#opt1open").click(function() {
				if (opt1open == false) {
					console.log(123)
					opt1open = true;
					opt1 = false;
					$("#opt1").prop("disabled", false);
				} else {
					opt1open = false;
					opt1 = true;
					$("#opt1").val("");
					$("#opt1").prop("disabled", true);
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			$("#opt2open").click(function() {
				if (opt2open == false) {
					opt2open = true;
					opt2 = false;
					$("#opt2").prop("disabled", false);
				} else {
					opt2open = false;
					opt2 = true;
					$("#opt2").val("");
					$("#opt2").prop("disabled", true);
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			$("#opt1").keyup(function() {
				var value = $(this).val();
				if (value != "" && value.includes("@gmail.com")) {
					opt1 = true;
				} else {
					opt1 = false;
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			$("#opt2").keyup(function() {
				var value = $(this).val();
				if (value != "" && value.length == 10) {
					opt2 = true;
				} else {
					opt2 = false;
				}
				main(sel2, sel3, sel4, sel5, opt1, opt2);
			})

			function main(sel2, sel3, sel4, sel5, opt1, opt2) {
				if (sel2 == true && sel3 == true && sel4 == true
						&& sel5 == true && opt1 == true && opt2 == true) {
					$("#btnn").prop("disabled", false);
				} else {
					$("#btnn").prop("disabled", true);
				}
			}

		})
	</script>

</body>
</html>