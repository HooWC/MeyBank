<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <link rel="icon" href="images/favicon.png" type="image/gif" />
  <title> Cafeesa| PRAROZ </title>


  <link rel="stylesheet" href="../../assets/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/contact.css" />

</head>

<body>

    
  <section id="infinite2" class="text-white tm-font-big tm-parallax">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-md tm-navbar2" id="tmNav">
      <div class="container">
        <div class="tm-next">
          <a href="home.jsp" class="navbar-brand"><img src="../../image/meybank-logo.png" width="30px">Meybank</a>
        </div>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fas fa-bars navbar-toggler-icon"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="home.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="whatwedo.jsp">What We Do</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="policy.jsp">Policy</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="faqs.jsp">FAQ's</a>
            </li>
            <li class="nav-item" style="background-color: rgb(153, 51, 80);border-radius: 5px;color: #FFF;">
              <a class="nav-link tm-nav-link" href="contact.jsp">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </section>


<!-- contact section -->
<section class="contact_section layout_padding">
  <div class="contact_bg_box">
    <img src="https://images6.alphacoders.com/485/485875.jpg" alt="">
  </div>
  <div class="container">
    <div class="heading_container heading_center">
      <h2>CONTACT</h2>
    </div> 
    <div class="">
      <div class="row">
        <div class="col-md-9 mx-auto">
          <form action="../../contact" method="post">
            <div class="contact_form-container">
              <div class="row">
                <div class="col-sm-6">
                  <input type="text" placeholder="Full Name" name="fullname" id="fullname">
                </div>
                <div class="col-sm-6">
                  <input type="email" placeholder="Email" name="email" id="email">
                </div>
              </div>
              <div class="row">
                <div class="col-sm-6">
                  <input type="text" placeholder="Phone Number" name="phone" id="phone" onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')" maxlength="10"/>
                </div>
                <div class="col-sm-6">
                  <input type="text" placeholder="Number of NRIC" name="nric" id="nric" onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')" maxlength="12"/>
                </div> 
              </div>
              <div class="">
                <input type="text" placeholder="Additional Note" class="message_input" name="text" id="text"/>
              </div>
              <div class="btn_box">
                <button type="submit" id="btnn" disabled>Send</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- End of contact section -->

<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script>

var fullname = false;
var email = false;
var phone = false;
var nric = false;
var text = false;

$("#fullname").keyup(function(){
	if($(this).val() != ""){
		fullname = true;
	}else{
		fullname = false;
	}
	CheckOPen(fullname,email,phone,nric,text);
})

$("#email").keyup(function(){
	if($(this).val() != "" && $(this).val().includes("@gmail.com")){
		email = true;
	}else{
		email = false;
	}
	CheckOPen(fullname,email,phone,nric,text);
})

$("#phone").keyup(function(){
	if($(this).val() != "" && $(this).val().length == 10){
		phone = true;
	}else{
		phone = false;
	}
	CheckOPen(fullname,email,phone,nric,text);
})

$("#nric").keyup(function(){
	if($(this).val() != "" && $(this).val().length == 12){
		nric = true;
	}else{
		nric = false;
	}
	CheckOPen(fullname,email,phone,nric,text);
})

$("#text").keyup(function(){
	if($(this).val() != ""){
		text = true;
	}else{
		text = false;
	}
	CheckOPen(fullname,email,phone,nric,text);
})


function CheckOPen(fullname,email,phone,nric,text){
	console.log("1  " +fullname)
	console.log("2  " +email)
	console.log("3  " +phone)
	console.log("4  " +nric)
	console.log("5  " +text)
	if(fullname == true && email == true && phone == true && nric == true && text == true){
		$("#btnn").prop("disabled",false);
	}else{
		$("#btnn").prop("disabled",true);
	}
}


</script>



</body>

</html>