<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Profile</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
.skillIcon {width:32px; position: relative; top:10px; margin-right: 5px;}
</style>
<body class="w3-light-grey" style="background-image:url('./assets/profile/back.jpg'); background-attachment: fixed;background-size:100%;">

<!-- Page Container -->
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">

    <!-- Left Column -->
    <div class="w3-third" style="width:300px; height:800px; position:fixed;">

      <div class="w3-white w3-text-grey w3-card-4">
        <div class="w3-display-container" align="center">
        <br>
			<img src="./assets/profile/LMH.jpg" class="w3-circle" alt="Person" style="width:70%; height:200px;">
      <hr>
        </div>
        <div class="w3-container">
          <p><i class="fa fa-id-badge fa-fw w3-margin-right w3-large" style="color:#009688"></i>임문환</p>
          <p><i class="fa fa-calendar fa-fw w3-margin-right w3-large" style="color:#009688"></i>1990.06.08</p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large" style="color:#009688"></i>ymw0608@naver.com</p>
          <p><i class="fa fa-phone fa-fw w3-margin-right w3-large" style="color:#009688"></i>010-5147-8323</p>
          <hr>
          <p><a href="#about" style="text-decoration:none;"><i class="fa fa-id-card-o fa-fw w3-margin-right w3-large" style="color:#009688"></i>About Me</a></p>
          <p><a href="#project" style="text-decoration:none;"><i class="fa fa-file-o fa-fw w3-margin-right w3-large" style="color:#009688"></i>Projects</a></p>
          <p><a href="#skill" style="text-decoration:none;"><i class="fa fa-asterisk fa-fw w3-margin-right w3-large" style="color:#009688"></i>Skills</a></p>
          <hr>
          <p><a href="http://blog.naver.com/ymw0608" target="_blank"><i class="fa fa-home fa-fw w3-margin-right w3-large" style="color:#009688"></i>Naver Blog</a></p>
          <p><a href="https://github.com/ymw0608" target="_blank"><i class="fa fa-github fa-fw w3-margin-right w3-large" style="color:#009688"></i>GitHub</a></p>
        </div>

      </div><br>

    <!-- End Left Column -->
    </div>

    <!-- Right Column -->
    <div class="w3-twothird" style="margin-left: 300px;">

      <div class="w3-container w3-card-2 w3-white w3-margin-bottom">
        <a name="about"></a>
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-id-card-o fa-fw w3-margin-right w3-xxlarge" style="color:#009688"></i>About Me</h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>혁신의 아이콘</b></h5>
          <p>변화의 물결에 순응하며 새로운 혁신을 시도하는 웹프로그래머입니다.</p>
          <hr>
        </div>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>한국스마트교육원 / <a href="http://ksmart.or.kr" target="_blank">http://ksmart.or.kr</a></b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right" style="color:#009688"></i>2016.09.27 - 2017.03.31</h6>
          <p>이것저것배움 ^^</p>
          <hr>
        </div>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>전북대학교 / 컴퓨터공학과</b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right" style="color:#009688"></i>2009.03.01 - 2016.08.27</h6>
          <p>컴퓨터공학과 졸업</p>
          <p></p>
          <hr>
        </div>
      </div>

      <div class="w3-container w3-card-2 w3-white w3-margin-bottom">
        <a name="project"></a>
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-file-o fa-fw w3-margin-right w3-xxlarge" style="color:#009688"></i>Projects</h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>SingleTonTrip</b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right" style="color:#009688"></i>2017.02.14 - 2017.03.29</h6>
          <img src="./assets/profile/singletontrip.png" style="max-height:300px; max-width:500px">
          <p> - 페이스북형태의 SNS기능을 가진 여행모집 및 숙박사이트로 관심있는 지역 및 주제를 통해 여행그룹원 모집 및 회원들간의 소통을 할 수 있다.</p>
          <a href="intro"><button class="w3-btn w3-teal w3-round" type="button">프로젝트로</button></a>
          <a href="fileDownload"><button class="w3-btn w3-teal w3-round" type="button">완료보고서</button></a>
          <hr>
        </div>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>도서관리</b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right" style="color:#009688"></i>2017.01.16 - 2017.01.23</h6>
          <img src="./assets/profile/singletontrip.png" style="max-height:300px; max-width:500px">
          <p> - 도서관의 회원관리 및 도서 대여 / 반납 프로그램</p>
          <a href="intro"><button class="w3-btn w3-teal w3-round" type="button">프로젝트로</button></a>
          <a href="intro"><button class="w3-btn w3-teal w3-round" type="button">완료보고서</button></a>
          <hr>
        </div>
      </div>


      <div class="w3-container w3-card-2 w3-white w3-margin-bottom">
        <a name="skill"></a>
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-asterisk fa-fw w3-margin-right w3-xxlarge" style="color:#009688"></i>Skills</h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>Language</b></h5>
          <h6 class="w3-text-teal">
            <img src="./assets/icon/JAVA.png" class="skillIcon">Java&nbsp;&nbsp;
            <img src="./assets/icon/JavaScript.png" class="skillIcon">JavaScript&nbsp;&nbsp;
            <img src="./assets/icon/html5.png" class="skillIcon">HTML&nbsp;&nbsp;
            <img src="./assets/icon/css.png" class="skillIcon">CSS
          </h6>
          <hr>
          <h5 class="w3-opacity"><b>Server Side</b></h5>
          <h6 class="w3-text-teal">
            <img src="./assets/icon/Java.png" class="skillIcon">JSP / Servlet
          </h6>
          <hr>
          <h5 class="w3-opacity"><b>Data base</b></h5>
          <h6 class="w3-text-teal">
            <img src="./assets/icon/MySQL.png" class="skillIcon">MySQL
            <img src="./assets/icon/oracle.png" class="skillIcon">Oracle
          </h6>
          <hr>
          <h5 class="w3-opacity"><b>FrameWork / Library</b></h5>
          <h6 class="w3-text-teal">
            <img src="./assets/icon/spring.png" class="skillIcon">Spring&nbsp;&nbsp;
            <img src="./assets/icon/mybatis.png" class="skillIcon">MyBatis&nbsp;&nbsp;
            <img src="./assets/icon/jquery.png" class="skillIcon">jQuery&nbsp;&nbsp;
            <img src="./assets/icon/bootstrap.png" class="skillIcon">BootStrap&nbsp;&nbsp;
          </h6>
          <br><br>
        </div>
      </div>

    <!-- End Right Column -->
    </div>

  <!-- End Grid -->
  </div>

  <!-- End Page Container -->
</div>



</body>
</html>
