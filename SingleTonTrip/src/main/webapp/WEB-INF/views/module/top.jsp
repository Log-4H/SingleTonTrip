<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>싱글톤트립 - 여행혼자갈꺼야?</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
</style>

<body>
<!-- 상단바 -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SigletonTrip</a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#band">호스팅하기</a></li>
				<li><a href="#tour">여행</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">메세지<span class="badge">3</span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Merchandise</a></li>
					<li><a href="#">Extras</a></li>
					<li><a href="#">Media</a></li>
				</ul>
				</li>
      		<li><a href="#" id="myBtn"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
        		<li><a href="joinBegin"><span class="glyphicon glyphicon-list-alt"></span> 회원가입</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-headphones"></span>고객센터</a></li>
			</ul>
		</div>
	</div>
</nav>

  <!-- 로그인 모달 -->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">

        <!-- 모달내용 -->
        <div class="modal-content">
          <div class="modal-header" style="padding:35px 50px;">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 align="center"><span class="glyphicon glyphicon-lock"></span> 로그인</h4>
          </div>
          <div class="modal-body" style="padding:40px 50px;">
            <form action="login" method="post">
              <div class="form-group">
                <label for="usrname"><span class="glyphicon glyphicon-user"></span> 아이디</label>
                <input class="form-control" type="text" id="loginId" name="loginId" value="admin1" placeholder="아이디">
              </div>
              <div class="form-group">
                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
                <input class="form-control" type="password" id="loginPw" name="loginPw" value="admin"  placeholder="비밀번호">
              </div>
              <div class="checkbox">
                <label><input type="checkbox" value="" >아이디저장</label>
              </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> 로그인</button>
            </form>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
            <p>회원이 아니십니까? <a href="#">회원가입</a></p>
            <p>기억나지않을땐 <a href="#">비밀번호찾기</a></p>
          </div>
        </div>

      </div>
    </div>

<!-- 본문 -->

<header class="w3-display-container w3-content w3-wide" style="max-width:1300px;" id="home">
  <img class="w3-image" src="D:/img/camping.jpg" alt="Architecture" style="width:1300px;height:500px;">
  <div class="w3-display-middle w3-margin-top w3-center">
    <h1 class="w3-xxlarge w3-text-white"><span class="w3-padding w3-black w3-opacity-min"><b>여행</b></span> <span class="w3-hide-small w3-text-black">같이 갈래요?</span></h1>
  </div>
</header>
