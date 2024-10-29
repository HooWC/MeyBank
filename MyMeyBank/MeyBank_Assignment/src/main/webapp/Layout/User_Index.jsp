<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../assets/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!--     <link rel="stylesheet" href="../MeyBank_User/css/account_index.css"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    
  </head>
<body>

    <!-- Hero section -->
	<section id="infinite2" class="text-white tm-font-big tm-parallax">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-md tm-navbar2" id="tmNav">
      <div class="container">
        <div class="tm-next">
          <a href="index.jsp" class="navbar-brand"><img src="../../image/meybank-logo.png" width="30px">Meybank</a>
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

  <section id="infinite2" class="text-white">
    <!-- Navigation -->
    <nav class="navbar tm-navbar2 navbar-select">
      <div class="container-list">

        <div class="div-item" id="box-0">
        	<a href="index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;
  					font-size:0.7rem">
        		<i class="fa-solid fa-house"></i>
            	<p>HOME</p>
        	</a> 
        </div>
        <div class="div-item" id="box-1" style="
        	display:flex;
    		flex-direction: column;
    		width: 170px;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;">
        <a href="account_index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-sharp fa-solid fa-file"></i>
            <p>ACCOUNT</p>
            </a>
        </div>
        <div class="div-item" id="box-2" style="display:flex;
    		flex-direction: column;
    		width: 170px;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;">
        <a href="transaction_index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-solid fa-arrow-right-arrow-left"></i>
            <p>FUND TRANSFER</p>
            </a>
        </div>
        <div class="div-item" id="box-3" style="display:flex;
    		flex-direction: column;
    		width: 170px;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;">
        <a href="payment_index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-solid fa-dollar-sign"></i>
            <p>PAYMENT</p>
            </a>
        </div>
        <div class="div-item" id="box-4" style="display:flex;
    		flex-direction: column;
    		width: 170px;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;"> 
        <a href="investment_index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-sharp fa-solid fa-arrow-trend-up"></i>
            <p>INVESTMENT</p>
            </a>
        </div>
        <div class="div-item" id="box-5" style="display:flex;
    		flex-direction: column;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;">
        <a href="profile_index.jsp" style="padding:10px 0px 0px 0px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-regular fa-user"></i>
            <p>PROFILE MAINTENANCE</p>
            </a>
        </div>
        <div class="div-item" id="box-6" style="display:flex;
    		flex-direction: column;
    		width: 170px;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;">
        <a href="equity_index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-sharp fa-solid fa-layer-group"></i>
            <p>EQUITY RESEARCH</p>
            </a>
        </div>
        <div class="div-item" id="box-7" style="display:flex;
    		flex-direction: column;
    		width: 170px;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;">
        <a href="mailbox_index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-solid fa-envelope"></i>
            <p>MAILBOX</p>
            </a>
        </div>
        <div class="div-item" id="box-8" style="display:flex;
    		flex-direction: column;
    		width: 170px;
    		transition: all .3s linear;
    		cursor: pointer;
    		border-right:1px solid #ced4da;">
        <a href="contact_index.jsp" style="padding:10px 10px 0px 10px;
  					display:flex;
  					flex-direction: column;
  					transition: all .3s linear;
  					cursor: pointer;
  					color:white;">
            <i class="fa-solid fa-phone"></i>
            <p>CONTACT US</p>
            </a>
        </div>

      </div>
    </nav>
</section>

 
    
</body>
</html>