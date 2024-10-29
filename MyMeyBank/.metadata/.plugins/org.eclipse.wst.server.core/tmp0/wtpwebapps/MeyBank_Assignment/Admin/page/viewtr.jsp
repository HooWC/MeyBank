<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="Models.*"%>
	<%@page import="java.util.*"%>
<%@include file="../../Layout/Admin.jsp"%>
	
<%
Account Otheracc = (Account)session.getAttribute("OtherAccount");
BankAccount Otherbank = (BankAccount)session.getAttribute("OtherBankAccount");
User Otheruser = (User)session.getAttribute("OtherUser");
Transaction Othertr = (Transaction)session.getAttribute("tr1");
String amount = String.format("%.2f", Othertr.getAmount()).toString();
String sms = String.format("%.2f", Othertr.getSMSNotification()).toString(); 
%>

<html>
<head>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="../css/viewtr.css">
</head>
<body>

	<div class="main">
		
		<h1 style="display: none;" id="mcid">@ViewBag.trID</h1>

	<div class="my_box">
		<img src="../../image/meybank-logo.png" alt="Logo"
			class="brand-image img-circle elevation-3"> <span
			class="brand-text font-weight-light"
			style="font-family: 'Times New Roman', Times, serif; color: white;">MeyBank
			<span style="color: red;">Online</span>
		</span>
	</div>

	<div class="my_box2">
		<hr />
	</div>


	<div class="row">

		<h2>MEYBANK ONLINE HISTORY</h2>
		<div class="flex">
			<div class="f1">
				<p>Reference Number :</p>
				<p>Transaction Status :</p>
				<p>Transaction Date/Time :</p>
				<p>From Account :</p>
				<p>Amount :</p>
				<br/>
				<p>Transfer Type :</p>
				<p>Beneficiary Bank :</p>
				<p>Beneficiary Account :</p>
				<p>Beneficiary Account Type :</p>
				<p>Beneficiary Name :</p>
				<p>Recipient Reference :</p>
				<p>Other Payment Detail :</p>
				<p>DuitNow Transfer Service Charge :</p>
				<p>Total Charges :</p>
				<br/>
				<p>SMS Notification Charge :</p>
				<p>Total Charges :</p>
				<br/>
				<p>Beneficiary's mobile phone number :</p>
				<p>Beneficiary's email :</p>
			</div>
			<div class="f2" id="TrDetail">
				<p>223417</p>
				<p>Successful</p>
				<p><%= Othertr.getDate() %></p>
				<p><%= Othertr.getDebit() %></p>
				<p>RM <%= amount %></p>
				<br/>
				<p><%= Othertr.getTransactionType() %></p>
				<% String acctype = "null";
				if(Otheracc != null)
					acctype = Otheracc.getBankType();
				%>
				<p><%= acctype %></p>
				<p><%= Othertr.getCredit() %></p>
				<% String banktype = "null";
				if(Otherbank != null)
					banktype = Otherbank.getAccountType();
				%>
				<p><%= banktype %></p>
				<% String fullname = "null";
				if(Otheruser != null)
					fullname = Otheruser.getFullName();
				%>
				<p><%= fullname %></p>
				<p><%= Othertr.getDescription() %></p>
				<p><%= Othertr.getOtherDescription() %></p>
				<p>RM 0.00</p>
				<p>RM 0.00</p>
				<br/>
				<p>RM <%= sms %></p>
				<p>RM <%= sms %></p>
				<br/>
				<p><%= Othertr.getPhoneNumber() %></p>
				<p><%= Othertr.getEmail() %></p>
			</div>
		</div>
	</div>
		
	
	</div>
	<div class="btn">
		<a class="b1" href="history.jsp" id="b1">Back</a>
		<button class="b1 b2" onclick="loadPrint()" id="b2">Print</button>
		<button class="b1 b2" onclick="pdfDo()" id="b3">Download PDF</button>
	</div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		 <script src="https://cdn.bootcss.com/html2canvas/0.5.0-beta4/html2canvas.js"></script>
  <script src="https://cdn.bootcss.com/jspdf/1.3.4/jspdf.debug.js"></script>
	<script>

		function loadPrint() {
			b1.style.display = "none";
			b2.style.display = "none";
			b3.style.display = "none";
			window.print();
			b1.style.display = "block";
			b2.style.display = "block";
			b3.style.display = "block";
		}

	
		 function pdfDo() {
	          var isDo = confirm("确定导出pdf页面");
	          if (!isDo) { return; }
	          var target = document.getElementsByClassName("main")[0];
	          
	          html2canvas(target, {
	              onrendered: function (canvas) {
	                  var contentWidth = canvas.width;
	                  var contentHeight = canvas.height;

	                  //一页pdf显示html页面生成的canvas高度;
// 	                  var pageHeight = contentWidth / 592.28 * 841.89;
	                  var pageHeight = contentWidth / 592.28 * 90001.89;
	                  //未生成pdf的html页面高度
	                  var leftHeight = contentHeight;
	                  //页面偏移
	                  var position = 0;
	                  //a4纸的尺寸[595.28,841.89]，html页面生成的canvas在pdf中图片的宽高
	                  var imgWidth = 595.28;
	                  var imgHeight = 592.28 / contentWidth * contentHeight;
	  
	                  var pageData = canvas.toDataURL('image/jpeg', 1.0);
	  
	                  var pdf = new jsPDF('', 'pt', 'a4');
	  
	                  //有两个高度需要区分，一个是html页面的实际高度，和生成pdf的页面高度(841.89)
	                  //当内容未超过pdf一页显示的范围，无需分页
	                  if (leftHeight < pageHeight) {
	                      pdf.addImage(pageData, 'JPEG', 0, 0, imgWidth, imgHeight);
	                  } else {
	                      while (leftHeight > 0) {
	                          pdf.addImage(pageData, 'JPEG', 0, position, imgWidth, imgHeight)
	                          leftHeight -= pageHeight;
	                          position -= 841.89;
	                          //避免添加空白页
	                          if (leftHeight > 0) {
	                              pdf.addPage();
	                          }
	                      }
	                  }
	                  pdf.save("pdf_file_name.pdf");
	              }
	          })
	      }






	</script>








</body>
</html>


