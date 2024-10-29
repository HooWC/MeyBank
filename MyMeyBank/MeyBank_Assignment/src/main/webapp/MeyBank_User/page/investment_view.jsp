
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
<link rel="stylesheet" href="../css/investment.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
<link href="https://cdn.webdatarocks.com/latest/webdatarocks.min.css" rel="stylesheet"/>
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
					<span class="sBtn-text">Investment</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="investment_view.jsp"
						id="investment">View Investment</a></li>
				</ul>
			</div>

				


		</div>



		<div class="input-box">


			<table><tr><td style="width: 850px;"><div id="wdr-component"></div></td>
<td><div id="googlechart-container" style="width:700px;height:550px;"></div></td></tr></table>


		</div>


	</section>

    
	<script src="https://cdn.webdatarocks.com/latest/webdatarocks.toolbar.min.js"></script>
	<script src="https://cdn.webdatarocks.com/latest/webdatarocks.js"></script>
	<script src="https://cdn.webdatarocks.com/latest/webdatarocks.googlecharts.js"></script>
	<script src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/investment.js"></script>
	<script>
  	$(function(){
  		
  		$("#box-4").css("background","red");
  		$("#investment").css("background","red");

  	})
  </script>

</body>
</html>