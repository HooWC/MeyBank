<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../assets/bootstrap.min.css" />
  	<link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>

     <!-- Hero section -->
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
            <li class="nav-item" style="background-color: rgb(153, 51, 80);border-radius: 5px;color: #FFF;">
              <a class="nav-link tm-nav-link" href="policy.jsp">Policy</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="faqs.jsp">FAQ's</a>
            </li>
            <li class="nav-item">
              <a class="nav-link tm-nav-link" href="contact.jsp">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </section>

    <div class="img-policy">
        <img src="https://monday.com/blog/wp-content/uploads/2022/09/pasted-image-0-16.jpg"
            class="d-block" alt="...">
    </div>

    <!-- Services-->
    <section class="container py-5 my-md-2 my-lg-3 my-xl-4 my-xxl-5">
        <div class="row align-items-center py-1 py-sm-3 py-md-4 my-lg-2" id="services">
            <div class="col-lg-4 offset-xl-1">
                <h2 class="h1 text-center text-lg-start pb-3 pb-lg-1">Security <span style="color:red;">Policy</span></h2>
                <!-- Show on screens > 992px-->
                <ul class="list-unstyled d-none d-lg-block pb-3 mb-3 mb-lg-4">
                    <li class="d-flex pt-2"><i class="bi bi-check-lg me-2"></i></i> Username and Password</li>
                    <li class="d-flex pt-2"><i class="bi bi-check-lg me-2"></i></i> Information Protection</li>
                    <li class="d-flex pt-2"><i class="bi bi-check-lg me-2"></i></i> Data Confidentiality and Data Integrity</li>
                    <li class="d-flex pt-2"><i class="bi bi-check-lg me-2"></i></i> Systems security and monitoring</li>
                </ul>
            </div>
            <div class="col-lg-8 col-xl-7 col-xxl-6">
                <div class="row row-cols-1 row-cols-sm-2">
                    <div class="col">
                        <div class="card border-0 bg-faded-primary">
                            <div class="card-body body1"><i class="bi  bash bi-gear-wide-connected"></i>
                                <h3 class="h4">Protect Yourself and Your Information Online</h3>
                                <p class="fs-sm">Be careful when you do your banking online. There have been cases of copycat web sites created by unauthorised persons posing as authentic web sites.</p>
                            </div>
                        </div>
                        <div class="card border-0 bg-faded-info mt-4">
                            <div class="card-body body2"><i class="bi  bash  bi-envelope"></i>
                                <h3 class="h4">Information Protection</h3>
                                <p class="fs-sm">Do not send any information about your account via e-mail.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col pt-lg-3">
                        <div class="card border-0 bg-faded-warning mt-4 mt-sm-0 mt-lg-4">
                            <div class="card-body body3"><i class="bi  bash bi-lightbulb-fill"></i>
                                <h3 class="h4">Updating your browser</h3>
                                <p class="fs-sm">Always update your browser when new versions are released because they often include new security features.</p>
                            </div>
                        </div>
                        <div class="card border-0 bg-faded-danger mt-4">
                            <div class="card-body body4"><i class="bi  bash bi-telegram"></i>
                                <h3 class="h4">Security Tips</h3>
                                <p class="fs-sm">Always log out of MeyBank.com immediately after completing transactions and before visiting other websites.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Show button on screens < 992px-->
                <div class="d-lg-none text-center pt-3 mt-3 mt-sm-4"><a class="btn btn-primary" href="#">See all
                        servises</a></div>
            </div>
        </div>
    </section>

    <!-- Tools-->
    <section class="container containerparticular" id="tools">
        <div class="bg-faded-primary rounded-5 py-5 px-4 p-sm-5">
            <div class="d-lg-flex align-items-center g-0 py-2 py-sm-3 py-md-4 p-xl-5">
                <div class="order-lg-2 text-center text-lg-start ps-lg-5 mx-auto me-lg-0">
                    <h2 class="h1 mb-4">The <span style="color:red;">tools</span> <br class='d-none d-lg-inline'>we work with</h2>
                    <p class="pb-3 mb-3 mb-lg-4">Morbi et massa fames ac scelerisque sit commodo dignissim faucibus vel
                        quisque proin lectus. Morbi et massa fames ac scelerisque sit commodo dignissim.</p>
                </div>
                
                <div class="order-lg-1 w-100 mx-auto mx-lg-0" style="max-width: 558px;">
                    <div class="row row-cols-3 g-3 g-sm-4 g-lg-3 g-xl-4 column-box" style="margin-right:10px;">

                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="300"><img class="box-img-img" src="../../image/bing.svg" class="img-assets" alt="Bing"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="500"><img class="box-img-img" src="../../image/facebook.svg" alt="Facebook"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="200"><img class="d-dark-mode-none box-img-img" src="../../image/microsoft-dark.svg"
                                    alt="Facebook"><img class="d-none d-dark-mode-block box-img-img"
                                    src="../../image/microsoft-light.svg" alt="Facebook"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="800"><img class="box-img-img" src="../../image/google.svg" alt="Google"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"><img
                                    class="d-dark-mode-none box-img-img" src="../../image/google-ads-dark.svg" alt="Google Ads"><img
                                    class="d-none d-dark-mode-block box-img-img" src="../../image/google-ads-light.svg"
                                    alt="Google Ads"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="600"><img class="d-dark-mode-none box-img-img" src="../../image/admitad-dark.svg"
                                    alt="Admitad"><img class="d-none d-dark-mode-block box-img-img"
                                    src="../../image/admitad-light.svg" alt="Admitad"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="400"><img class="d-dark-mode-none box-img-img"
                                    src="../../image/google-analytics-dark.svg" alt="Google Analytics"><img
                                    class="d-none d-dark-mode-block box-img-img" src="../../image/google-analytics-light.svg"
                                    alt="Google Analytics"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="700"><img class="d-dark-mode-none box-img-img" src="../../image/instagram-dark.svg"
                                    alt="Instagram"><img class="d-none d-dark-mode-block box-img-img"
                                    src="../../image/instagram-light.svg" alt="Instagram"></div>
                        </div>
                        <div class="col">
                            <div class="bg-light rounded-3 box-img" data-aos="zoom-in" data-aos-easing="ease-out-back"
                                data-aos-delay="100"><img class="d-dark-mode-none box-img-img" src="../../image/tiktok-dark.svg"
                                    alt="TikTok"><img class="d-none d-dark-mode-block box-img-img" src="../../image/tiktok-light.svg"
                                    alt="TikTok"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>
</html>