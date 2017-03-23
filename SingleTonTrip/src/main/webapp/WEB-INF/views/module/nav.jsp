<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="navbar navbar-transparent navbar-fixed-top navbar-color-on-scroll">
   	<div class="container">
       	<!-- Brand and toggle get grouped for better mobile display -->
       	<div class="navbar-header">
       		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-index">
           		<span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
       		</button>

		           <div class="logo-container">
		                <div class="logo">
		                    <img src="assets/img/logo.png" alt="Creative Tim Logo">
		                </div>
		                <div class="brand">
		                    Singleton Trip
		                </div>
		            </div>
					
 	  	</div>
		
       	<div class="collapse navbar-collapse" id="navigation-index">
       		<ul class="nav navbar-nav navbar-right">
       		<li>
       			<form class="navbar-form navbar-left" id="searchListForm" action="searchList" method="post" name="searchListForm">
						<div class="input-group">
							<input type="text" name="value" placeholder="Search" style="color: #000000;">
							<a href="javascript:searchListForm.submit()"><i class="material-icons" style="color: #ffffff;">search</i></a>						
						</div>
					</form>
       		</li>
			<c:if test="${sessionId eq null }">	
				<li><a href="intro"><i class="material-icons">bookmark_border</i>소개</a></li>
				<li><a href="companyList"><i class="material-icons">business</i>숙소</a></li>
				<li><a href="#tour"><i class="material-icons">flight_takeoff</i>여행</a></li>
			    <li><a href="login2"> <!-- id="myBtn" --> <i class="material-icons">input</i>로그인</a></li>
        		<li><a href="joinBegin"><i class="material-icons">assignment_ind</i>회원가입</a></li>
				<li><a href="#"><i class="material-icons">headset_mic</i>고객센터</a></li>
			</c:if>
			<c:if test="${sessionLevel eq 1}">
			<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">video_label</i>광고</a>
						<ul class="dropdown-menu">
							<li><a href="adApplyList">광고 신청 리스트</a></li>
							<li><a href="adList">광고 리스트</a></li>
							<li><a href="payCancelList">환불 리스트</a></li>
						</ul>
				</li>
				<li><a href="#tour"><i class="material-icons">flight_takeoff</i>여행</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">supervisor_account</i>친구</a>
						<ul class="dropdown-menu">
							<li><a href="friendAddList">친구요청리스트</a></li>
							<li><a href="friendCheckList">친구신청확인</a></li>
							<li><a href="friendTotalList">친구리스트</a></li>
						</ul>
				</li>
				<li><a href="#"><i class="material-icons">headset_mic</i>고객센터</a></li>
				
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">face</i>${sessionNm}</a> 		                
			        	<ul class="dropdown-menu">
							<li><a href="logout"> 로그아웃</a></li>
							<li><a href="pageMain?pageId=${sessionId}">페이지</a></li>
							<li><a href="mileageList">마일리지</a></li>
							<li><a href="reserveList">예약정보</a></li>
							<li><a href="payList">결제정보</a></li>
						</ul>
				</li>      			
			
			</c:if>
			
			<c:if test="${sessionLevel eq 2}">
			<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">video_label</i>광고</a>
						<ul class="dropdown-menu">
							<li><a href="adApply">광고 신청</a></li>
							<li><a href="adApplyList">광고 신청 리스트</a></li>
							<li><a href="adList">광고 리스트</a></li>
							<li><a href="payAdd">광고 결제</a></li>
							<li><a href="payCancelList">환불 리스트</a></li>
						</ul>
				</li>
				<li><a href="#tour"><i class="material-icons">flight_takeoff</i>여행</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">supervisor_account</i>친구</a>
						<ul class="dropdown-menu">
							<li><a href="friendAddList">친구요청리스트</a></li>
							<li><a href="friendCheckList">친구신청확인</a></li>
							<li><a href="friendTotalList">친구리스트</a></li>
						</ul>
				</li>
				<li><a href="#"><i class="material-icons">headset_mic</i>고객센터</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">face</i>${sessionNm}</a>
						<ul class="dropdown-menu">
							<li><a href="logout" > 로그아웃</a></li>
							<li class="dropdown"><a href="pageMain?pageId=${sessionId}">페이지</a></li>
							<li><a href="companyDetail?memberId=${sessionId}">업체정보</a></li>
							<li><a href="reserveList">예약정보</a></li>
							<li><a href="payList">결제정보</a></li>
						</ul>
				</li>
			
			</c:if>
			<c:if test="${sessionLevel eq 3}">
			<li>
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">group</i>그룹</a>
						<ul class="dropdown-menu">
							<li><a href="javascript:void(0)" class="groupListModalShow" value="leader">생성한그룹</a></li>
							<li><a href="javascript:void(0)" class="groupListModalShow" value="member">가입한그룹</a></li>
						</ul>
				</li>
				<li><a href="#tour"><i class="material-icons">flight_takeoff</i>여행</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">supervisor_account</i>친구</a>
						<ul class="dropdown-menu">
							<li><a href="friendAddList">친구요청리스트</a></li>
							<li><a href="friendCheckList">친구신청확인</a></li> 
							<li><a href="friendTotalList">친구리스트</a></li>
						</ul>
						</li>
						<li><a href="#"><i class="material-icons">headset_mic</i>고객센터</a></li>
						
			<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="material-icons">face</i>${sessionNm}</a> 		                
			        	<ul class="dropdown-menu">
							<li><a href="logout"> 로그아웃</a></li>
							<li><a href="pageMain?pageId=${sessionId}">페이지</a></li>
							<li><a href="mileageList">마일리지</a></li>
							<li><a href="reserveList">예약정보</a></li>
							<li><a href="payList">결제정보</a></li>
						</ul>
				</li> 
			
			</c:if>
			
			
			
			</ul>
		</div>
	</div>
   </nav>