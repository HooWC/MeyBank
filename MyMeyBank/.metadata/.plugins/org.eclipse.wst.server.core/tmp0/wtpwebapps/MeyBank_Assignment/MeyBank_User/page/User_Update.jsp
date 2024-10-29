
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<%
Account account = (Account) session.getAttribute("Account");
List<BankAccount> bank_list = (List<BankAccount>) session.getAttribute("banklist");
String[] banktype_list = (String[]) session.getAttribute("banktype_list");
User u = (User)session.getAttribute("User");
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
	String msg = (String) session.getAttribute("updateusererror");
	if (msg == null) {
		msg = "";
	}
	%>


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

			<h1 class="input-box-title">Update Information</h1>
			<p class="input-box-title-p">Update Information (U/I)</p>


			<p id="error"
				style="color: red; font-weight: bold; font-size: 0.9rem; padding: 10px 0px 0px 60px; text-align: center;"><%=msg%></p>

			<form action="../../User_Update" method="post" enctype="multipart/form-data">
				<div class="form-item">

					<div class="item-child">
						<p>Avatar</p>
						<div class="form-group-input">
							<input name="Photo" type="file" id="Photo" class="form-control" />
						</div>
					</div>

					<div class="item-child">
						<p>FullName</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="fullname" name="fullname" value="<%= u.getFullName() %>">
						</div>
					</div>

					<div class="item-child">
						<p>Email</p>
						<div class="form-group-input">
							<input type="text" class="form-control form-control-input"
								id="gmail" name="gmail" value="<%= u.getEmail() %>">
						</div>
					</div>
					
					<div class="item-child">
						<p>Password</p>
						<div class="form-group-input">
							<input type="password" class="form-control form-control-input"
								id="password" name="password" maxlength="6">
						</div>
					</div>

				</div>

				<section class="section-box-acc">
				<div class="box-acc">
					<p class="box-acc-title">Note:</p>

					<ul>
						<li>This service is only available within out Operating Hours
							12:15 a.m - 12 midnight.</li>
						<li>Update data needs to pay RM0.20</li>
					</ul>
				</div>
				
				<div class="btn-hr">
						<a href="profile_index.jsp" class="btn btn-danger">Cancel</a>
						<button type="submit" class="btn btn-danger" id="btnn" disabled>Confirm</button>
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

			var fullname = true;
			var gmail = true;
			
			main(fullname, gmail);

			$("#fullname").keyup(function() {
				var value = $(this).val();
				if (value != "") {
					fullname = true;
				} else {
					fullname = false;
				}
				main(fullname, gmail);
			})

			$("#gmail").keyup(function() {
				var value = $(this).val();
				if (value != "") {
					gmail = true;
				} else {
					gmail = false;
				}
				main(fullname, gmail);
			})

	
			function main(fullname, gmail) {
				if (fullname == true && gmail == true) {
					$("#btnn").prop("disabled", false);
				} else {
					$("#btnn").prop("disabled", true);
				}
			}

		})
	</script>

</body>
</html>