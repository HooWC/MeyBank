<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="Models.*"%>
<%@page import="java.util.*"%>
<%@include file="../../Layout/Admin.jsp"%>
<% 
	Admin ad = (Admin)session.getAttribute("Admin");
	List<Admin> list = (List<Admin>)session.getAttribute("Adminlist");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../css/user_home.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>


	<div class="container-1" x-data="{ rightSide: false, leftSide: false }">
		<div class="left-side" :class="{'active' : leftSide}">
			<div class="left-side-button" @click="leftSide = !leftSide">
				<svg viewBox="0 0 24 24" stroke="currentColor" stroke-width="2"
					fill="none" stroke-linecap="round" stroke-linejoin="round">
					<line x1="3" y1="12" x2="21" y2="12"></line>
					<line x1="3" y1="6" x2="21" y2="6"></line>
					<line x1="3" y1="18" x2="21" y2="18"></line></svg>
				<svg stroke="currentColor" stroke-width="2" fill="none"
					stroke-linecap="round" stroke-linejoin="round" viewBox="0 0 24 24">
        <path d="M19 12H5M12 19l-7-7 7-7" />
      </svg>
			</div>
			<div class="logo">MEYBANK</div>
			<div class="side-wrapper">
				<div class="side-title">MENU</div>
				<div class="side-menu">
					<a href="admin_home.jsp"> <svg xmlns="http://www.w3.org/2000/svg"
							fill="none" stroke="currentColor" stroke-width="2"
							stroke-linecap="round" stroke-linejoin="round"
							viewBox="0 0 24 24">
                  <path d="M3 9l9-7 9 7v11a2 2 0 01-2 2H5a2 2 0 01-2-2z" />
                  <path d="M9 22V12h6v10" />
                </svg> Home
					</a> <a href="m_user_home.jsp"
						style="background: red; padding: 8px 10px; border-radius: 5px; color: white;">
						<svg stroke="currentColor" stroke-width="2" fill="none"
							stroke-linecap="round" stroke-linejoin="round"
							viewBox="0 0 24 24">
                  <path d="M2 3h6a4 4 0 0 1 4 4v14a3 3 0 0 0-3-3H2z"></path>
                  <path d="M22 3h-6a4 4 0 0 0-4 4v14a3 3 0 0 1 3-3h7z"></path>
                </svg> Manage Users
					</a> <a href="../../getallaccount"> <svg xmlns="http://www.w3.org/2000/svg"
							fill="none" stroke="currentColor" stroke-width="2"
							stroke-linecap="round" stroke-linejoin="round"
							viewBox="0 0 24 24">
                  <path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0118 0z" />
                  <circle cx="12" cy="10" r="3" /></svg> Manage Account
					</a> <a href="../../getAllContent"> <svg xmlns="http://www.w3.org/2000/svg"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <rect x="3" y="3" width="18" height="18" rx="2" ry="2" />
                  <circle cx="8.5" cy="8.5" r="1.5" />
                  <path d="M21 15l-5-5L5 21" />
                </svg> Manage Contact
					</a> <a href="../../getallhistory"> <svg xmlns="http://www.w3.org/2000/svg"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                  <rect x="3" y="4" width="18" height="18" rx="2" ry="2" />
                  <path d="M16 2v4M8 2v4M3 10h18" />
                </svg> View History
					</a>
				</div>
			</div>
			<div class="side-wrapper">
				<div class="side-title">YOUR FAVOURITE</div>
				<div class="side-menu">
					<a href="update_admin.jsp"> <svg xmlns="http://www.w3.org/2000/svg"
							viewBox="0 0 472.11 472.11">
                  <path
								d="M260.07 216.11a63.94 63.94 0 00-28.26-53.1 55.95 55.95 0 00-43.74-90.9c-.8 0-1.6.1-2.4.12a56 56 0 10-107.2 0c-.8 0-1.6-.12-2.4-.12a55.95 55.95 0 00-43.75 90.9 64 64 0 000 106.2 55.95 55.95 0 0043.75 90.9h112a55.95 55.95 0 0043.74-90.9 63.94 63.94 0 0028.26-53.1z"
								fill="#6a9923" />
                  <path
								d="M193.8 178.51a8 8 0 00-11.32-.16l-42.41 41.03V104.1a8 8 0 00-16 0v56.7l-36.35-36.35a8 8 0 00-11.31 11.3l47.66 47.67V292.8l-34.35-34.34a8 8 0 00-11.31 11.3l45.66 45.67V464.1a8 8 0 0016 0V241.63l53.6-51.78a8 8 0 00.12-11.34z"
								fill="#618c20" />
                  <path
								d="M468.07 216.11a63.94 63.94 0 00-28.26-53.1 55.95 55.95 0 00-43.74-90.9c-.8 0-1.6.1-2.4.12a56 56 0 10-107.2 0c-.8 0-1.6-.12-2.4-.12a55.95 55.95 0 00-43.75 90.9 64 64 0 000 106.2 55.95 55.95 0 0043.75 90.9h112a55.95 55.95 0 0043.74-90.9 63.94 63.94 0 0028.26-53.1z"
								fill="#6a9923" />
                  <path
								d="M401.72 178.46a8 8 0 00-11.31 0l-42.34 42.34V104.11a8 8 0 00-16 0v56.7l-36.35-36.35a8 8 0 00-11.31 11.3l47.66 47.67V292.8l-34.35-34.34a8 8 0 00-11.31 11.3l45.66 45.67V464.1a8 8 0 0016 0V242.87c.6-.3 1.15-.66 1.65-1.1l52-52a8 8 0 000-11.31z"
								fill="#618c20" />
                  <path
								d="M364.07 216.11a63.94 63.94 0 00-28.26-53.1 55.95 55.95 0 00-43.74-90.9c-.8 0-1.6.1-2.4.12a56 56 0 10-107.2 0c-.8 0-1.6-.12-2.4-.12a55.95 55.95 0 00-43.75 90.9 64 64 0 000 106.2 55.95 55.95 0 0043.75 90.9h112a55.95 55.95 0 0043.74-90.9 63.94 63.94 0 0028.26-53.1z"
								fill="#88b337" />
                  <path
								d="M297.72 178.46a8 8 0 00-11.31 0l-42.34 42.34V104.11a8 8 0 00-16 0v56.7l-36.35-36.35a8 8 0 00-11.31 11.3l47.66 47.67V292.8l-34.35-34.34a8 8 0 00-11.31 11.3l45.66 45.67V464.1a8 8 0 0016 0V242.87c.6-.3 1.15-.66 1.65-1.1l52-52a8 8 0 000-11.31z"
								fill="#6a9923" />
                  <path
								d="M372.07 472.11h-272a8 8 0 010-16h272a8 8 0 010 16z"
								fill="#595959" /></svg> Update
					</a> <a href="#"> <svg viewBox="0 0 56 58" width="512"
							xmlns="http://www.w3.org/2000/svg">
                  <g fill="none" transform="translate(0 -1)">
                    <path
								d="M46.8 48.4a30.5 30.5 0 01-8.8-24l6.9-12C44.4 9.6 41.6 1 28 1A32 32 0 003.4 13.5a.2.2 0 00.2.4l2.5-.5a.5.5 0 01.4.8 14.2 14.2 0 00-3.3 4.3.2.2 0 00.3.4l2.5-.6a.5.5 0 01.6.6C5 22.5-.4 37.1.9 56.8a.5.5 0 00.9.2c2.2-3.3 5-6.2 8.4-8.3a.5.5 0 01.7.4c0 2.4.8 4.7 2.4 6.4a.5.5 0 001-.1 14 14 0 015.4-8h.5c1.7 1.2 3 3.8 3.6 5.8.5 1.8 1 3.6 1.1 5.4a.5.5 0 00.8.4c7-4 7.1-8.5 7.2-8.6a.5.5 0 01.9-.2c1.4 1.6 2.7 3.4 3.7 5.2a.5.5 0 001 0c.8-2 1.3-4.3 1.5-6.6l6.4.5a.5.5 0 00.4-1z"
								fill="#f9eab0" />
                    <path
								d="M44.5 49c-4.8-.4-4.3-.3-5.6-.6a.5.5 0 00-.5.5c-.2 2-.6 4-1.2 5.9-1-1.7-2.2-3.2-3.4-4.7a.5.5 0 00-.9.2v.1c-.7 4.4-5.4 7.5-7.2 8.5a.5.5 0 01-.8-.4c-.4-3.6-1.6-8.8-4.6-11a.5.5 0 00-.6 0 14 14 0 00-5.5 7.9c-1.3-1.8-2-4-2-6.2a.5.5 0 00-.6-.4l-.7.4a.5.5 0 00-.7-.4c-2.7 1.7-5 3.9-7 6.4a91.2 91.2 0 015-36.8.5.5 0 00-.4-.1l-1.2.3c-.1-.2-.4-.4-.6-.3l-.7.1c.8-1.5 1.8-3 3-4.2.4-.3 0-1-.4-.8l-1.2.2c0-.2-.3-.3-.5-.2l-.7.1c.4-.4 6.8-10.3 18.4-12.2a27 27 0 013.9-.3c12 0 14.5 8.7 15 11.3l-6.2 12a32.6 32.6 0 007.9 24c.2.3.2.6 0 .8z"
								fill="#f5efca" />
                    <path d="M27.8 1z" fill="#ecf0f1" />
                    <path
								d="M53 29c.1-1.8-.5-3.6-1.8-5-1.5-1.6-4.2-3-9.2-3-12 0-13 2-13 2s0-3.8 10-6.7c.5-.2.8-.6.8-1.1-.1-1 .2-2.1.9-2.9.2-.2.5-.3.8-.3 1.7 0 8 .4 10.5 3 3 3 5 7 1 14z"
								fill="#f0c419" />
                    <path
								d="M51.2 24c-4.5 5.2-3.8-1.8-19.2 1 0 0-3 0-3-2 0 0 1-2 13-2 5 0 7.7 1.4 9.2 3z"
								fill="#f29c1f" />
                    <path d="M32 12.3a3 3 0 11-3.5-2.3z" fill="#f0c419" />
                    <path
								d="M44 18a1 1 0 010-2c.5-.1 1-.3 1.3-.7a1 1 0 011.4 1.4C46 17.4 45 18 44 18z"
								fill="#e57e25" />
                    <circle cx="29" cy="13" fill="#393f4a" r="2" />
                    <path
								d="M34.6 14c-2 0-3.8-.9-5.2-2.2a4 4 0 00-3.4-1.1c-2 .4-3.1 2.7-3.1 2.8a1 1 0 01-1.8-1s1.6-3.1 4.5-3.8c1.8-.3 3.6.3 5 1.5 2.1 1.8 3.6 2 4.4 1.9.4-.1.8-.3 1.1-.6a1 1 0 011.7 1c-.8 1-2 1.6-3.2 1.6z"
								fill="#7f6e5d" />
                  </g>
                </svg> New Admin
					</a> 
					<a href="../../LogoutAdmin">
               <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                  <path d="M339.4 346.5a636.5 636.5 0 00-46.7-140.2 8.4 8.4 0 00-7.6-4.8h-21a8.4 8.4 0 00-8 11 662.9 662.9 0 0129 289.7 8.4 8.4 0 008.4 9.5h50.3c4.4 0 8.1-3.6 8.3-8 2.3-52.8-2-105.6-12.7-157.2z" fill="#ff9940" />
                  <g fill="#f5760f">
                    <path d="M300.7 508.8a8.4 8.4 0 01-2-6.6 662.7 662.7 0 00-29-289.7 8.4 8.4 0 018-11H264a8.4 8.4 0 00-8 11 662.9 662.9 0 0129 289.7 8.4 8.4 0 008.4 9.5H307c-2.4 0-4.7-1-6.3-2.9z" />
                    <path d="M331.2 312.2l-48.8 9.1c.9 5.6 1.7 11.1 2.4 16.7l50.6-9.5c-1.3-5.5-2.7-10.9-4.2-16.3zM288 369.2l1.1 16.7h57.2a641 641 0 00-2.6-16.7H288z" />
                  </g>
                  <path d="M499.7 157.8A125.9 125.9 0 00276.9 212a8.4 8.4 0 0010.2 9.7L495 171a8.5 8.5 0 004.6-13.3z" fill="#a4d64d" />
                  <path d="M351.1 2.9a8.4 8.4 0 00-7.5-2.8 125.9 125.9 0 00-93 185c7.4 13.4 17 25.2 28.6 35.1a8.4 8.4 0 0013.5-4l60.1-205.5c.8-2.7.2-5.6-1.7-7.8z" fill="#8ec42f" />
                  <g fill="#a4d64d">
                    <path d="M327 199.3c-15.3-.3-30.3 2.1-44.7 7.2a8.4 8.4 0 00-3.3 13.7l148 154.7a8.5 8.5 0 0013.8-2.6 125.9 125.9 0 00-113.7-173z" />
                    <path d="M293.3 212.1a125.9 125.9 0 00-222.8-54.3A8.5 8.5 0 0075 171l208 50.7a8.4 8.4 0 0010.2-9.7z" />
                  </g>
                  <path d="M293.2 212.5c-.6-2.8-2.6-5-5.3-6a125.9 125.9 0 00-158.5 165.8c2.2 5.5 9.7 7 13.8 2.6l148-154.7c2-2 2.7-5 2-7.7z" fill="#8ec42f" />
                  <path d="M491.7 496.5c-71.3-45-153.8-68.7-238.6-68.7S86 451.6 14.5 496.5A8.4 8.4 0 0019 512h468.3a8.4 8.4 0 004.4-15.5z" fill="#ffd042" />
                  <path d="M35.5 506c-1-3.6.4-7.5 3.6-9.5A447 447 0 01265.4 428l-12.3-.2a447.2 447.2 0 00-238.6 68.7A8.4 8.4 0 0019 512h24.6c-3.8 0-7-2.5-8-6z" fill="#ffc412" />
                  <circle cx="290.8" cy="218.3" r="29.3" fill="#a4a09a" />
                  <path d="M299.2 239.2a29.3 29.3 0 01-24.5-45.4 29.3 29.3 0 1040.7 40.6c-4.7 3-10.2 4.8-16.2 4.8z" fill="#928d86" />
                  <circle cx="316" cy="256" r="29.3" fill="#a4a09a" />
                  <path d="M324.4 281.1a29.3 29.3 0 01-17.1-53.1 29.4 29.4 0 1025.8 51.8c-2.8.9-5.7 1.3-8.7 1.3z" fill="#928d86" />
                  <circle cx="261.5" cy="256" r="29.3" fill="#a4a09a" />
                  <path d="M269.9 277a29.3 29.3 0 01-24.5-45.5A29.3 29.3 0 10286 272c-4.6 3-10.2 4.9-16.1 4.9z" fill="#928d86" />
                  <g fill="#ffb266">
                    <circle cx="274.1" cy="473.9" r="8.4" />
                    <circle cx="378.9" cy="482.3" r="8.4" />
                    <circle cx="328.6" cy="465.6" r="8.4" />
                    <circle cx="223.8" cy="457.2" r="8.4" />
                    <circle cx="202.8" cy="482.3" r="8.4" />
                    <circle cx="144.2" cy="482.3" r="8.4" />
                  </g>
                </svg>
                Logout
              </a>
				</div>
			</div>

		</div>
		<div class="main">
			<div class="search-bar">

				<button class="right-side-button" @click="rightSide = !rightSide">
					<svg viewBox="0 0 24 24" width="24" height="24"
						stroke="currentColor" stroke-width="2" fill="none"
						stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1">
						<path
							d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"></path></svg>
				</button>
			</div>
			<div class="main-container">
				<div class="profile">
					<div class="profile-avatar">
						<img src="../../image/Admin/<%= ad.getIMG() %>" alt="" class="profile-img">
                		<div class="profile-name"><%= ad.getFullName() %></div>
					</div>
					<img
						src="https://images.unsplash.com/photo-1508247967583-7d982ea01526?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
						alt="" class="profile-cover">
					<div class="profile-menu">
						<a class="profile-menu-link active">All</a>
					</div>
				</div>
				<div class="timeline">

					<form class="search-container">
						<input type="text" id="search-bar" placeholder="Search...">
					</form>

					<div class="moi" id="moi"></div>


				</div>
			</div>
		</div>
		<div class="right-side" :class="{ 'active': rightSide }">


			<div class="side-wrapper contacts">
				<div class="side-title">CONTACTS</div>
				
			<% for(Admin i : list){ %>
            <div class="user">
              <img src="../../image/Admin/<%= i.getIMG() %>" class="user-img">
              <div class="username"><%= i.getFullName() %>
                <div class="user-status offline"></div>
              </div>
            </div>
            <%} %>
				
			</div>

		</div>
		<div class="overlay" @click="rightSide = false; leftSide = false"
			:class="{ 'active': rightSide || leftSide }"></div>
	</div>


	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script>
	
	$(function(){
	
		$.ajax({
			url:"../../AjaxFunction",
			type:"POST",
			data:{
				"Action":"getAllUser"
			},
			dataType:"json",
			success:function(data){
				$("#moi").empty();
				$.each(data,function(x,y){
					
					$("#moi").append(`
						<a href='../../getUserData?id=${"${y.UserID}"}' class="admin d-flex align-items-center rounded-2 p-2">
							<div class="img">
								<img class="rounded-pill" width="45" height="45"
									src='../../image/User/${"${y.IMG}"}'
									alt="admin">
							</div>
							<div class="ms-3">
								<h3 class="fs-6 mb-1">${"${y.FullName}"}</h3>
							</div>
						</a>
					`)
					
				})
			}
		})
		
		$("#search-bar").keyup(function(){
			
			var s = $(this).val();
			
			$.ajax({
			url:"../../AjaxFunction",
			type:"POST",
			data:{
				"Value":$(this).val(),
				"Action":"SearchAllUser"
			},
			dataType:"json",
			success:function(data){
				console.log(s)
				console.log(data)
				
				$("#moi").empty();
				$.each(data,function(x,y){
					
					$("#moi").append(`
						<a href='../../getUserData?id=${"${y.UserID}"}' class="admin d-flex align-items-center rounded-2 p-2">
							<div class="img">
								<img class="rounded-pill" width="45" height="45"
									src='../../image/User/${"${y.IMG}"}'
									alt="admin">
							</div>
							<div class="ms-3">
								<h3 class="fs-6 mb-1">${"${y.FullName}"}</h3>
							</div>
						</a>
					`)
					
				})
			}
		})
			
		})
		
		
	})
	
	
	</script>
</body>
</html>