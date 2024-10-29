
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../Layout/User_Index.jsp"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>
<% 
Account account = (Account)session.getAttribute("Account");
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
<link rel="stylesheet" href="../css/equity.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>

	<section class="context-nei">

		<div class="select-option">

			<div class="select-menu active">
				<div class="select-btn">
					<span class="sBtn-text">Equity Research</span> <i
						class="bx bx-chevron-down"></i>
				</div>

				<ul class="options">
					<li><a class="option option-text" href="equity_view.jsp"
						id="equity">View stock progress</a></li>
				</ul>
			</div>




		</div>



		<div class="input-box">
 <h1 class="input-box-title">Equity Research</h1>
       		<p class="input-box-title-p">View Equity (ER)</p>
			<div id="chartdiv"></div>


		</div>


	</section>


<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="//cdn.amcharts.com/lib/4/core.js"></script>
	<script src="//cdn.amcharts.com/lib/4/charts.js"></script>
	<script src="//cdn.amcharts.com/lib/4/themes/animated.js"></script>
	<script src="../script/equity.js"></script>
	<script>
  	$(function(){
  		
  		$("#box-6").css("background","red");
  		$("#equity").css("background","red");

  	})
  </script>

</body>
</html>