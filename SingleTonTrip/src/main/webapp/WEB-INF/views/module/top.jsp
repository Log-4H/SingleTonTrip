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
			<a class="navbar-brand" href="index">SigletonTrip</a>
		</div>
		<c:if test="${sessionId eq null }">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#band"><span class="glyphicon glyphicon-bed"></span>숙소</a></li>
				<li><a href="#tour"><span class="glyphicon glyphicon-plane"></span>여행</a></li>
			    <li><a href="login"> <!-- id="myBtn" --><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
        		<li><a href="joinBegin"><span class="glyphicon glyphicon-list-alt"></span> 회원가입</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-headphones"></span>고객센터</a></li>
			</ul>
		</div>
		</c:if>
		<c:if test="${sessionLevel eq 1}">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="personList">개인회원리스트</a></li>
				<li><a href="companyList">업체회원리스트</a></li>
				<li><a href="#band"><span class="glyphicon glyphicon-bed"></span>숙소</a></li>
				<li><a href="#tour"><span class="glyphicon glyphicon-plane"></span>여행</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">친구<span class="badge">3</span></a>
						<ul class="dropdown-menu">
							<li><a href="friendAddList">친구요청리스트</a></li>
							<li><a href="friendCheckList">친구신청확인</a></li>
							<li><a href="friendTotalList">친구리스트</a></li>
						</ul>
				</li>
				<li><a href="logout" ><span class="glyphicon glyphicon-log-in"></span> 로그아웃</a></li>
				<li><a href="#" ><span class="glyphicon glyphicon-user"></span>${sessionNm}</a></li>
      			<li><a href="#"><span class="glyphicon glyphicon-headphones"></span>고객센터</a></li>
			</ul>
		</div>
		</c:if>
		<c:if test="${sessionLevel eq 2}">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="adApply">광고 신청</a></li>
				<li><a href="#band"><span class="glyphicon glyphicon-bed"></span>숙소</a></li>
				<li><a href="#tour"><span class="glyphicon glyphicon-plane"></span>여행</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">친구<span class="badge">3</span></a>
						<ul class="dropdown-menu">
							<li><a href="friendAddList">친구요청리스트</a></li>
							<li><a href="friendCheckList">친구신청확인</a></li>
							<li><a href="friendTotalList">친구리스트</a></li>
						</ul>
				</li>
				<li><a href="logout" ><span class="glyphicon glyphicon-log-in"></span> 로그아웃</a></li>
				<li><a href="#" ><span class="glyphicon glyphicon-user"></span>${sessionNm}</a></li>
      			<li><a href="#"><span class="glyphicon glyphicon-headphones"></span>고객센터</a></li>
			</ul>
		</div>
		</c:if>
		<c:if test="${sessionLevel eq 3}">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#band"><span class="glyphicon glyphicon-bed"></span>숙소</a></li>
				<li><a href="#tour"><span class="glyphicon glyphicon-plane"></span>여행</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">친구<span class="badge">3</span></a>
						<ul class="dropdown-menu">
							<li><a href="friendAddList">친구요청리스트</a></li>
							<li><a href="friendCheckList">친구신청확인</a></li> 
							<li><a href="friendTotalList">친구리스트</a></li>
						</ul>
				</li>
				<li><a href="logout" ><span class="glyphicon glyphicon-log-in"></span> 로그아웃</a></li>
				<li><a href="#" ><span class="glyphicon glyphicon-user"></span>${sessionNm}</a></li>
      			<li><a href="#"><span class="glyphicon glyphicon-headphones"></span>고객센터</a></li>
			</ul>
		</div>
		</c:if>
	</div>
</nav>

  <!-- 로그인 모달 -->
   <!--  <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">

        모달내용
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
            <p>회원이 아니십니까? <a href="joinBegin">회원가입</a></p>
            <p>아이디가 기억나지않을땐 <a href="memberIdFind">아이디찾기</a></p>
            <p>비밀번호가 생각나지않을땐 <a href="memberPwFind">비밀번호찾기</a></p>
          </div>
        </div>

      </div>
    </div> -->
 <!-- 스크립트 -->
<!-- <script>
//로그인모달
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script> -->