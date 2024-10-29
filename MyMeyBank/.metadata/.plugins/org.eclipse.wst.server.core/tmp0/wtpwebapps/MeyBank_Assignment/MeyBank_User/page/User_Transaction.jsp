<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>

<%
User u = (User) session.getAttribute("User");
String amountUser = (String) session.getAttribute("amountUser");
String senUser = (String) session.getAttribute("senUser");
String countUser = (String) session.getAttribute("countUser");
String amountUsers = (String) session.getAttribute("amountUsers");
String senUsers = (String) session.getAttribute("senUsers");
String countUsers = (String) session.getAttribute("countUsers");
List<User> listUser = (List<User>) session.getAttribute("TodayUser");
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
<link rel="stylesheet" href="../css/user.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>

	<div class="app-container">
		<div class="app-left">
			<button class="close-menu">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
					class="feather feather-x">
					<line x1="18" y1="6" x2="6" y2="18" />
					<line x1="6" y1="6" x2="18" y2="18" /></svg>
			</button>
			<div class="app-logo">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
					class="feather feather-bar-chart-2">
              <line x1="18" y1="20" x2="18" y2="10" />
              <line x1="12" y1="20" x2="12" y2="4" />
              <line x1="6" y1="20" x2="6" y2="14" />       </svg>
				<span>MeyBank Profile</span>
			</div>
			<ul class="nav-list">
				<li class="nav-list-item"><a class="nav-list-link"
					href="User_Home.jsp"> <svg xmlns="http://www.w3.org/2000/svg" width="24"
							height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-columns">
							<path
								d="M12 3h7a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-7m0-18H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h7m0-18v18" /></svg>
						Information
				</a></li>
				<li class="nav-list-item active"><a class="nav-list-link" href="User_Transaction.jsp">
						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-briefcase">
							<rect x="2" y="7" width="20" height="14" rx="2" ry="2" />
							<path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16" /></svg>
						Transaction History
				</a></li>

			</ul>
		</div>
		
		
		<div class="app-main2">
			
			   <h1>Transaction History Select Type</h1>
            <div class="options">
                <div class="optionhoo active" style="--optionBackground:url(https://66.media.tumblr.com/6fb397d822f4f9f4596dff2085b18f2e/tumblr_nzsvb4p6xS1qho82wo1_1280.jpg);">
                   <div class="shadow"></div>
                   <div class="label">
                      <div class="icon">
                         <i class="fas fa-walking"></i>
                      </div>
                      <div class="info">
                         <div class="main">All History</div>
                         <a href="../../History?Action=All" class="sub">Go to interface</a>
                      </div>
                   </div>
                </div>
                <div class="optionhoo" style="--optionBackground:url(https://66.media.tumblr.com/8b69cdde47aa952e4176b4200052abf4/tumblr_o51p7mFFF21qho82wo1_1280.jpg);">
                   <div class="shadow"></div>
                   <div class="label">
                      <div class="icon">
                         <i class="fas fa-snowflake"></i>
                      </div>
                      <div class="info">
                         <div class="main">Own History</div>
                         <a href="../../History?Action=Own" class="sub">Go to interface</a>
                      </div>
                   </div>
                </div>
                <div class="optionhoo" style="--optionBackground:url(https://66.media.tumblr.com/5af3f8303456e376ceda1517553ba786/tumblr_o4986gakjh1qho82wo1_1280.jpg);">
                   <div class="shadow"></div>
                   <div class="label">
                      <div class="icon">
                         <i class="fas fa-tree"></i>
                      </div>
                      <div class="info">
                         <div class="main">Other MB History</div>
                         <a href="../../History?Action=Other" class="sub">Go to interface</a>
                      </div>
                   </div>
                </div>
                <div class="optionhoo" style="--optionBackground:url(https://66.media.tumblr.com/5516a22e0cdacaa85311ec3f8fd1e9ef/tumblr_o45jwvdsL11qho82wo1_1280.jpg);">
                   <div class="shadow"></div>
                   <div class="label">
                      <div class="icon">
                         <i class="fas fa-tint"></i>
                      </div>
                      <div class="info">
                         <div class="main">IBG History</div>
                         <a href="../../History?Action=IBG" class="sub">Go to interface</a>
                      </div>
                   </div>
                </div>
                <div class="optionhoo" style="--optionBackground:url(https://66.media.tumblr.com/f19901f50b79604839ca761cd6d74748/tumblr_o65rohhkQL1qho82wo1_1280.jpg);">
                   <div class="shadow"></div>
                   <div class="label">
                      <div class="icon">
                         <i class="fas fa-sun"></i>
                      </div>
                      <div class="info">
                         <div class="main">Payment History</div>
                         <a href="../../History?Action=Payment" class="sub">Go to interface</a>
                      </div>
                   </div>
                </div>
             </div>
			

		</div>
		
		
		
		
		
		<div class="app-right">
			<button class="close-right">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
					class="feather feather-x">
					<line x1="18" y1="6" x2="6" y2="18" />
					<line x1="6" y1="6" x2="18" y2="18" /></svg>
			</button>
			<div class="profile-box">
				<div class="profile-photo-wrapper">
					<img src="../../image/User/<%=u.getIMG()%>" alt="profile">
				</div>
				<p class="profile-text"><%=u.getFullName()%></p>
				<p class="profile-subtext"><%=u.getEmail()%></p>
			</div>
			<div class="app-right-section">
				<div class="app-right-section-header">
					<h2>Activity</h2>
				</div>
				<div class="activity-line">
					<span class="activity-icon warning"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-alert-circle">
							<circle cx="12" cy="12" r="10" />
							<line x1="12" y1="8" x2="12" y2="12" />
							<line x1="12" y1="16" x2="12.01" y2="16" /></svg>
					</span>
					<div class="activity-text-wrapper">
						<p class="activity-text">HOME</p>
						<a class="activity-link" href="index.jsp">Go Immediately</a>
					</div>
				</div>
				<div class="activity-line">
					<span class="activity-icon applicant"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-alert-circle">
							<circle cx="12" cy="12" r="10" />
							<line x1="12" y1="8" x2="12" y2="12" />
							<line x1="12" y1="16" x2="12.01" y2="16" /></svg>
					</span>
					<div class="activity-text-wrapper">
						<p class="activity-text">ACCOUNT</p>
						<a class="activity-link" href="account_index.jsp">Go Immediately</a>
					</div>
				</div>
				
				<div class="activity-line">
					<span class="activity-icon close"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-alert-circle">
							<circle cx="12" cy="12" r="10" />
							<line x1="12" y1="8" x2="12" y2="12" />
							<line x1="12" y1="16" x2="12.01" y2="16" /></svg>
					</span>
					<div class="activity-text-wrapper">
						<p class="activity-text">FUND TRANSFER</p>
						<a class="activity-link" href="transaction_index.jsp">Go Immediately</a>
					</div>
					</div>
				</div>
				
				<div class="activity-line">
					<span class="activity-icon draft"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-alert-circle">
							<circle cx="12" cy="12" r="10" />
							<line x1="12" y1="8" x2="12" y2="12" />
							<line x1="12" y1="16" x2="12.01" y2="16" /></svg>
					</span>
					<div class="activity-text-wrapper">
						<p class="activity-text">PAYMENT</p>
						<a class="activity-link" href="payment_index.jsp">Go Immediately</a>
					</div>
				</div>
				
				<div class="activity-line">
					<span class="activity-icon warning"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-alert-circle">
							<circle cx="12" cy="12" r="10" />
							<line x1="12" y1="8" x2="12" y2="12" />
							<line x1="12" y1="16" x2="12.01" y2="16" /></svg>
					</span>
					<div class="activity-text-wrapper">
						<p class="activity-text">INVESTMENT</p>
						<a class="activity-link" href="investment_index.jsp">Go Immediately</a>
					</div>
				</div>
				
				<div class="activity-line">
					<span class="activity-icon applicant"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-alert-circle">
							<circle cx="12" cy="12" r="10" />
							<line x1="12" y1="8" x2="12" y2="12" />
							<line x1="12" y1="16" x2="12.01" y2="16" /></svg>
					</span>
					<div class="activity-text-wrapper">
						<p class="activity-text">EQUITY RESEARCH</p>
						<a class="activity-link" href="equity_index.jsp">Go Immediately</a>
					</div>
				</div>
				
				<div class="activity-line">
					<span class="activity-icon close"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-alert-circle">
							<circle cx="12" cy="12" r="10" />
							<line x1="12" y1="8" x2="12" y2="12" />
							<line x1="12" y1="16" x2="12.01" y2="16" /></svg>
					</span>
					<div class="activity-text-wrapper">
						<p class="activity-text">CONTACT US</p>
						<a class="activity-link" href="contact_index.jsp">Go Immediately</a>
					</div>
				</div>
				
				
			</div>
		</div>


	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/user.js"></script>

</body>
</html>