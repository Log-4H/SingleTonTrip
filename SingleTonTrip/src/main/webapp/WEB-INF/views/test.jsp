<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>프로젝트소개</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidenav to 120px */
.w3-sidenav {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidenav (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}}
</style>
<body class="w3-white">

<!-- Icon Bar (Sidenav - hidden on small screens) -->
<nav class="w3-sidenav w3-center w3-small w3-hide-small">
  <!-- Avatar image in top left corner -->
  <img src="<c:url value='/images/main.jpg'/>" style="width:100%">
  <a class="w3-padding-large w3-black" href="#">
    <i class="fa fa-home w3-xxlarge"></i>
    <p>HOME</p>
  </a>
  <a class="w3-padding-large w3-hover-black" href="#about">
    <i class="fa fa-user w3-xxlarge"></i>
    <p>ABOUT</p>
  </a>
  <a class="w3-padding-large w3-hover-black" href="#photos">
    <i class="fa fa-eye w3-xxlarge"></i>
    <p>PHOTOS</p>
  </a>
  <a class="w3-padding-large w3-hover-black" href="#contact">
    <i class="fa fa-envelope w3-xxlarge"></i>
    <p>CONTACT</p>
  </a>
</nav>

<!-- Navbar on small screens (Hidden on medium and large screens) -->
<div class="w3-top w3-hide-large w3-hide-medium" id="myNavbar">
  <div class="w3-bar w3-black w3-opacity w3-hover-opacity-off w3-center w3-small">
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#">HOME</a>
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#about">ABOUT</a>
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#photos">PHOTOS</a>
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#contact">CONTACT</a>
  </div>
</div>

<!-- Page Content -->
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
  <header class="w3-container w3-padding-32 w3-center w3-white" id="home">
    <h1 class="w3-jumbo"><span class="w3-hide-small"></span>SingletonTrip.</h1>
    <p>당신의 즐거운 여행을 위하여.</p>
    <p>2017-2-14~2017-3-29</p>
    <img src="<c:url value='/images/main.jpg'/>" alt="main" class="w3-image" width="992" height="1108">
  </header>

  <!-- About Section -->
  <div class="w3-content w3-justify w3-text-grey w3-padding-64" id="about">
    <h2>프로젝트 소개</h2>
    <hr style="width:200px" class="w3-opacity">
    <p>"sigleton" 야구에서, 주어진 회에 한 번의 기회로 득점이 되는 것. + "trip" 여행.<br>
주어진 여행의 기회를 한번에 성공하기 위해 도와주고자 이프로젝트를 시작하게 되었습니다.
    </p>

    <!-- Grid for pricing tables -->
    <h3 class="w3-padding-16">개발환경</h3>
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-half w3-margin-bottom">
        <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
          <li class="w3-dark-grey w3-xlarge w3-padding-32">OS</li>
          <li class="w3-padding-16">window 7</li>
          <li class="w3-dark-grey w3-xlarge w3-padding-32">WAS</li>
          <li class="w3-padding-16">Apache tomcat 8.0</li>
          <li class="w3-dark-grey w3-xlarge w3-padding-32">언어</li>
          <li class="w3-padding-16">java 1.8</li>
          <li class="w3-padding-16">java script / jquery / ajax</li>
          <li class="w3-padding-16">jsp</li>
          <li class="w3-padding-16">html</li>
          <li class="w3-dark-grey w3-xlarge w3-padding-32">프레임워크</li>
          <li class="w3-padding-16">spring framwork 4.3.5</li>
          <li class="w3-padding-16">maven</li>
          <li class="w3-padding-16">mybatis 3.4.1</li>
          <li class="w3-padding-16">bootstrap</li>
        </ul>
      </div>

      <div class="w3-half">
        <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
          <li class="w3-dark-grey w3-xlarge w3-padding-32">웹브라우저</li>
          <li class="w3-padding-16">Chrome</li>
          <li class="w3-dark-grey w3-xlarge w3-padding-32">DBMS</li>
          <li class="w3-padding-16">MySQL 5.1.40</li>
          <li class="w3-dark-grey w3-xlarge w3-padding-32">개발툴</li>
          <li class="w3-padding-16">spring tool suite</li>
          <li class="w3-padding-16">mysql workbench</li>
          <li class="w3-padding-16">GIT source tree</li>
          <li class="w3-padding-16">exerd</li>
        </ul>
      </div>
    <!-- End Grid/Pricing tables -->
    </div>
    </div>



  <!-- Portfolio Section -->
  <div class="w3-padding-64 w3-content" id="photos">
    <h2>팀소개 및 역활분담</h2>
    <hr style="width:250px" class="w3-opacity">

    <!-- Grid for photos -->
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-half">
        <h3>허준</h3>
        <li></li>
        <li></li>
        <li></li>
      </div>

      <div class="w3-half">
        <h3>임문환</h3>
        <li></li>
        <li></li>
        <li></li>
      </div>

      <div class="w3-half">
        <h3>황문규</h3>
        <li></li>
        <li></li>
        <li></li>
      </div>

      <div class="w3-half">
        <h3>김의현</h3>
          <li></li>
          <li></li>
          <li></li>
      </div>
    <!-- End photo grid -->
    </div>
  <!-- End Portfolio Section -->
  </div>

  <!-- Contact Section -->
  <div class="w3-padding-64 w3-content w3-text-grey" id="contact">
    <h2>ERD</h2>
    <hr style="width:200px" class="w3-opacity">

    <div class="w3-section">
      <img src="https://raw.githubusercontent.com/Log-4H/imgRepo/master/erd.png" style="width:100%">
    </div><br>
  </div>

    <!-- Footer -->
  <footer class="w3-content w3-padding-64 w3-text-grey w3-xlarge">
    <i class="fa fa-facebook-official w3-hover-text-indigo"></i>
    <i class="fa fa-instagram w3-hover-text-purple"></i>
    <i class="fa fa-snapchat w3-hover-text-yellow"></i>
    <i class="fa fa-pinterest-p w3-hover-text-red"></i>
    <i class="fa fa-twitter w3-hover-text-light-blue"></i>
    <i class="fa fa-linkedin w3-hover-text-indigo"></i>
    <p class="w3-medium">Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank" class="w3-hover-text-green">w3.css</a></p>
  <!-- End footer -->
  </footer>

<!-- END PAGE CONTENT -->
</div>

</body>
</html>
