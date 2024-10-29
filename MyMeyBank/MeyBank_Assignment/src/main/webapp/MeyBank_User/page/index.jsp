<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    
<!-- Hero section -->
<section id="infinite2" class="text-white tm-font-big tm-parallax">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-md tm-navbar2" id="tmNav">
      <div class="container">
        <div class="tm-next">
          <a href="#infinite" class="navbar-brand"><img src="../../image/meybank-logo.png" width="30px">Meybank</a>
        </div>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fas fa-bars navbar-toggler-icon"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <div class="navbar-nav ml-auto">
            <a href="../../Logout" class="logout-key"><i class="fa-solid fa-unlock-keyhole"></i>Logout</a>
          </div>
        </div>
      </div>
    </nav>
  </section>

  <section class="word-box">
    <h1>Welcome to MeyBank Personal Banking</h1>
    <p>Ms VIGNESWARY A/P SOMU NAIDU, your last last login was on <span style="color:orange;font-weight: bold;"><%= time %></span></p>
  </section>

  <section class="twopart">
    <div class="select-box">
        <div class="item-select-box box-1">
        	<a href="account_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
        		<i class="fa-sharp fa-solid fa-file"></i>
            	<p>ACCOUNT</p>
        	</a>
        </div>
        <div class="item-select-box box-2">
        <a href="transaction_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
            <i class="fa-solid fa-arrow-right-arrow-left"></i>
            <p>FUND TRANSFER</p>
            </a>
        </div>
        <div class="item-select-box box-3">
        <a href="payment_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
            <i class="fa-solid fa-dollar-sign"></i>
            <p>PAYMENT</p>
            </a>
        </div>
        <div class="item-select-box box-4">
        <a href="investment_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
            <i class="fa-sharp fa-solid fa-arrow-trend-up"></i>
            <p>INVESTMENT</p>
            </a>
        </div>
        <div class="item-select-box box-5">
        <a href="profile_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
            <i class="fa-regular fa-user"></i>
            <p>PROFILE MAINTENANCE</p>
            </a>
        </div>
        <div class="item-select-box box-6">
        <a href="equity_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
            <i class="fa-sharp fa-solid fa-layer-group"></i>
            <p>EQUITY RESEARCH</p>
            </a>
        </div>
        <div class="item-select-box box-7">
        <a href="mailbox_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
            <i class="fa-solid fa-envelope"></i>
            <p>MAILBOX</p>
            </a>
        </div>
        <div class="item-select-box box-8">
        <a href="contact_index.jsp" style="width:220px;
  				height:220px;
  				margin:2px;
  				color:white;
  				padding:10px;
  				display:flex;
  				flex-direction: column;
  				justify-content:center;
  				align-items:center;
  				cursor: pointer;">
            <i class="fa-solid fa-phone"></i>
            <p>CONTACT US</p>
            </a>
        </div>
    </div>
    
    <div class="img-box">
        <img src="https://www.lowyat.net/wp-content/uploads/2022/10/MBSB-Bank-Banking-CASA-i-Term-Deposit-i-PrimeWin-1.jpg"/>
        <div class="img-box-context">
            <h1>Security Tip</h1>
            <p>Please remember to check if these details are correct each time you log in : <span style="font-weight: bold;">your name, day, date and time of your last time.</span></p>
            <p>If any of the information displayed is inaccurate, please log out immediately and contact PBe Customer Support at 03-21795000 or <a href="#" style="color:red;">customersupport@publicbank.com.my</a></p>
        </div>
    </div>
  </section>


</body>
</html>