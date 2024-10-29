<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="Models.*"%>
<%@page import="AppDBContext.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Checking_Login.jsp"%>

<%
User u = (User) session.getAttribute("User");
List<Transaction> list = (List<Transaction>) session.getAttribute("AllHistory");
String type = (String)session.getAttribute("historytype");
User Otheruser = null;
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
<link rel="stylesheet" href="../css/history.css">
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
		<div class="app-main">
		
		   <form action="../../gettimeofhistory?action=<%= type %>" method="post">
                <div class="selectbox">
                    <div class="select">
                        <select name="sel1">
                          <option value="All">All</option>
                          <option value="2023">2023</option>
                          <option value="2022">2022</option>
                          <option value="2021">2021</option>
                        </select>
                      </div>
                      <div class="select">
                        <select name="sel2">
                          <option value="01">January</option>
                          <option value="02">February</option>
                          <option value="03">March</option>
                          <option value="04">April</option>
                          <option value="05">May</option>
                          <option value="06">June</option>
                          <option value="07">July</option>
                          <option value="08">August</option>
                          <option value="09">September</option>
                          <option value="10">October</option>
                          <option value="11">November</option>
                          <option value="12">December</option>
                        </select>
                      </div>
                      <button type="submit" class="mybttn">SUBMIT</button>
                </div>
            </form>

			<div class="app-content">

				<div class="projects-section">

					<div class="projects-section-line">
						<div class="project-boxes jsGridView">
							<%
							for (Transaction i : list) {
							%>
							<%
							api_BankAccount api_bank = new api_BankAccount();
							api_User api_user = new api_User();
							api_Transaction api_tr = new api_Transaction();
							api_Account api_acc = new api_Account(); 
							
							String text = "";
							if(i.getDescription().equals("null")){
								text = "Nothing";
							}else{
								text = i.getDescription();
							}

							String amount = String.format("%.2f", i.getAmount()).toString();
							double amounts = (i.getAmount() / 200);
							String s = String.format("%.1f", amounts).toString();
							String img = "../../image/User/defaultimg.jpeg";
							try {
								BankAccount Otherbank = api_bank.getBankAccount_ByCardnum(i.getCredit());
								if(Otherbank != null){
									String pin = String.valueOf(Otherbank.getPinNumber());
									Account account = api_bank.getAccount(Otherbank.getCardNumber(), pin, acc.getUsername(), acc.getPassword());
									Otheruser = api_user.getUser_By_ID(account.getUserID(), acc.getUsername(), acc.getPassword(), "account");
									img = "../../image/User/" + Otheruser.getIMG();
								}
								

							} catch (Exception e) {
								return;
							} 
							%>
							
							<div class="project-box-wrapper">
								<div class="project-box" style="background-color: #fee4cb;">
									<div class="project-box-header">
										<span><%=i.getDate()%></span>

									</div>
									<div class="project-box-content-header">
										<p class="box-content-header"><%=i.getTransactionType()%></p>
										<p class="box-content-subheader"><%=text%></p>
									</div>
									<div class="box-progress-wrapper">
										<p class="box-progress-header">
											RM
											<%=amount%></p>
										<div class="box-progress-bar">
											<span class="box-progress"
												style="width: <%=s%>%; background-color: #ff942e"></span>
										</div>
										<p class="box-progress-percentage"><%=s%>%
										</p>
									</div>
									<div class="project-box-footer">
										<div class="participants">
											<img src="<%= img %>"
												alt="participant">
										</div>
										<a href="../../History_View?trid=<%= i.getTransactionID() %>" class="mya">View</a>
									</div>
								</div>
							</div>
							<%
							}
							%>






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
						<a class="activity-link" href="account_index.jsp">Go
							Immediately</a>
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
						<a class="activity-link" href="transaction_index.jsp">Go
							Immediately</a>
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
					<a class="activity-link" href="payment_index.jsp">Go
						Immediately</a>
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
					<a class="activity-link" href="investment_index.jsp">Go
						Immediately</a>
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
					<a class="activity-link" href="#">Go Immediately</a>
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
					<a class="activity-link" href="#">Go Immediately</a>
				</div>
			</div>


		</div>
	</div>




	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="../script/user.js"></script>

</body>
</html>