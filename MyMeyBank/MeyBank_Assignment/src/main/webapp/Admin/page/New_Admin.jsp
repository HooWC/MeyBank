<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Admin.jsp"%>
<% 
	Admin ad = (Admin)session.getAttribute("Admin");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
	integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
	crossorigin="anonymous" />
<link rel="stylesheet" href="../css/new_admin.css" />
</head>
<body>

<%
		String msg = (String)session.getAttribute("newadminerror");
		if(msg == null){
			msg = "";
		}
	%>

	<form action="../../new_admin" method="post">
		<div id="wrapper">
			<div id="left">
				<div id="signin">
					<div class="logo">
						<h1>
							MeyBank <span style="color: red;">Online</span>
						</h1>
					</div>
					<p style="color:red"><%=msg %></p>
					<div class="form">
						<div>
							<label>Full Name</label> <input type="text" id="MyGmail"
								class="text-input" name="fullname" required />
						</div>
						<div>
							<label>User ID</label> <input type="text" id="MyGmail"
								class="text-input" name="id" required />
						</div>
						<div>
							<label>Password</label> <input type="password" type="password"
								id="MyPassword" maxlength="6" name="password" class="text-input" required />
						</div>
						<button type="submit" class="primary-btn" id="mysubmit">Submit</button>
					</div>
					<div class="or">
						<hr class="bar" />
						<span>OR</span>
						<hr class="bar" />
					</div>
					<a href="admin_home.jsp" class="secondary-btn">Back To Home</a>
				</div>
				<footer id="main-footer">
					<p>Copyright 2022/7/14, Create by Hoo</p>
					<div>
						<a href="https://www.facebook.com/profile.php?id=100075495878672">Terms
							of use</a> | <a href="#">Privacy Policy</a>
					</div>
				</footer>
			</div>
			<div id="right">
				<div id="showcase">
					<div class="showcase-content"></div>
				</div>
			</div>
		</div>


	</form>





</body>
</html>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


