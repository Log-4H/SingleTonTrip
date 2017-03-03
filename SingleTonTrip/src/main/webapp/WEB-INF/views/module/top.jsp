<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/commons/bootstrap.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/commons/w3.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/view.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/commons/familyMontserrat.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/commons/familyLato.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/commons/font-awesome.min.css'/>" />

<script src="<c:url value='/js/commons/jquery.min.js'/>"></script>
<script src="<c:url value='/js/commons/bootstrap.min.js'/>"></script>
</head>
<body>
	<!--navbar-->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#test">Trip</a>
			</div>
			<form class="navbar-form navbar-left">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="#band">호스팅하기</a>
					</li>
					<li>
						<a href="#tour">여행</a>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							메세지 
							<span class="badge">3</span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">Merchandise</a></li>
							<li><a href="#">Extras</a></li>
							<li><a href="#">Media</a></li>
						</ul>
					<li>
						<a href="#contact">도움말</a>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
							<span class="glyphicon glyphicon-user"></span>
							내정보
						</a>
						<ul class="dropdown-menu">
							<li><a href="mileageList">mileage</a></li>
							<li><a href="#">Extras</a></li>
							<li><a href="#">Media</a></li>
						</ul>
					</li>
					<li>
						<a href="#" id="myBtn"> 
							<span class="glyphicon glyphicon-log-in"></span> 
							로그인
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!--
	<!-- First Parallax Image with Logo Text 
	<div class="bgimg w3-display-container w3-opacity-min" id="home">
		<div
			class="w3-display-middle w3-padding-xlarge w3-border w3-wide w3-text-light-grey w3-center">
			<h1 class="w3-hide-medium w3-hide-small w3-xxxlarge">JANE DOE</h1>
			<h5 class="w3-hide-large" style="white-space: nowrap">JANE DOE</h5>
			<h3 class="w3-hide-medium w3-hide-small">PHOTOGRAPHER</h3>
		</div>
	</div>-->


	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>
						<span class="glyphicon glyphicon-lock"></span> 로그인
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form">
						<div class="form-group">
							<label for="usrname"> <span
								class="glyphicon glyphicon-user"></span> 아이디
							</label> <input type="text" class="form-control" id="usrname"
								placeholder="Enter id">
						</div>
						<div class="form-group">
							<label for="psw"> <span
								class="glyphicon glyphicon-eye-open"></span> 비밀번호
							</label> <input type="password" class="form-control" id="psw"
								placeholder="Enter password">
						</div>
						<div class="checkbox">
							<label><input type="checkbox" value="">아이디저장</label>
						</div>
						<button type="submit" class="btn btn-success btn-block">
							<span class="glyphicon glyphicon-off"></span> 로그인
						</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left"
						data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> 취소
					</button>
					<p>
						회원이 아니십니까? <a href="#">회원가입</a>
					</p>
					<p>
						기억나지않을땐 <a href="#">비밀번호찾기</a>
					</p>
				</div>
			</div>

		</div>
	</div>