<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="landing-page">
<script>
// 광고 불러온다
$(document).ready(function() {
	$.ajax({
		url : "serviceAdList",
		type : "GET",
		dataType : "json",
		success : function(data) {
			var mainAdList = data.mainAdList;
			var html="";
			$.each(mainAdList,function(key, item) {
				if(key==0){
					html+="<div class='item active slider-size'>";
				}
				else {
					html+="<div class='item slider-size'>";
				}
				// 광고신청할 때 URL 입력했으면 그 주소로 가고 입력 안했으면 광고 신청한 사람의 페이지로 이동
				if(item.adPageAddress == null || item.adPageAddress == ""){
					html+="<a href='pageMain?pageId="+item.companyId+"'>";
				} else {
					html+="<a href='"+item.adPageAddress+"'>";
				}
				html+="<img class='img-responsive center-block' src='./images/"+item.adImg+"' style='width:100%; max-height:333px;'></a>";
				html+="</div>";
			});
			$("#adList").html(html);
			
		}
	})
});
</script>
<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
    <div class="wrapper">
        <div class="header header-filter" style="background-image: url('./assets/img/base/MainImg.jpg');">
            <div class="container">
                <div class="row">
					<div class="col-md-6">
						<h1 class="title">SingleTon Trip</h1>
	                    <h4>당신의 즐거운 여행을 책임집니다.</h4>
	                    <br />
	                    <a href="intro" class="btn btn-danger btn-raised btn-lg">
							<i class="fa fa-play"></i> 소개로
						</a>
					</div>
                </div>
            </div>
        </div>
		<div class="main main-raised">
			<div class="container">
		    	<div class="section text-center section-landing">
		    	<!-- 공지사항 -->
			        <div class="alert">
			            <div class="container-fluid">
							<div class="alert-icon">
								<i class="material-icons">info_outline</i>
							</div>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close" style="color:#000000">
								<span aria-hidden="true"><i class="material-icons">clear</i></span>
							</button>
		
			            	<p align="left" id="notice" style="color:#000000">
			            	<span class='label label-danger' style="color:#FFFFFF">공지사항</span>
			            	공지사항입니다</p>
			            </div>
			        </div>
			        
			        
			        <!-- 슬라이드 광고 -->
			    	<div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
	            		
						<div class="carousel-inner" role="listbox" id="adList">
						
						</div>
						<!-- 좌,우 컨트롤 -->
						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> 
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> 
						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> 
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<c:forEach var="m" items="${mainAdCount}">
								<li data-target="#myCarousel" data-slide-to="${m.adNo}" class="active"></li>
							</c:forEach>
						</ol>
					</div>
	            </div>
				<!-- 우수회원 -->
	        	<div class="section text-center">
	                <h2 class="title">우수회원</h2>
					<div class="team">
						<div class="row">
							<c:forEach items="${bestPerson }" var="bp">
							<div class="col-md-4">
			                    <div class="team-player">
			                    <a href="pageMain?pageId=${bp.memberId }">
			                    	<c:choose>
										<c:when test="${bp.memberImg ne null}">
											<img src="./images/${bp.memberImg}" class="img-raised img-circle">
										</c:when>
										<c:when test="${bp.personGender == 'M'}">
											<img src="./assets/img/base/Male.png" class="img-raised img-circle">
										</c:when>
										<c:when test="${bp.personGender == 'F'}">
											<img src="./assets/img/base/Female.png" class="img-raised img-circle">
										</c:when>
									</c:choose>
									</a>
			                       <h4 class="title"><a href="pageMain?pageId=${bp.memberId }">${bp.memberNm }</a><br />
										<small class="text-muted" align="left"><script>writeRate(${bp.memberEvaluationRating *10})</script><strong>${bp.memberEvaluationRating}</strong></small>
									</h4>
			                        <p class="description">test</p>
									<a href="#pablo" class="btn btn-simple btn-just-icon"><i class="fa fa-twitter"></i></a>
									<a href="#pablo" class="btn btn-simple btn-just-icon"><i class="fa fa-instagram"></i></a>
									<a href="#pablo" class="btn btn-simple btn-just-icon btn-default"><i class="fa fa-facebook-square"></i></a>
			                    </div>
			                </div>
			                </c:forEach>
						</div>
					</div>
	            </div>
	            
	            <!-- 우수업체 -->
	           <div class="section text-center">
	                <h2 class="title">우수업체</h2>
					<div class="team">
						<div class="row">
							<c:forEach items="${bestCompany }" var="bc">
							<div class="col-md-4">
			                    <div class="team-player">
			                    <a href="pageMain?pageId=${bc.memberId }">
			                    	<c:choose>
										<c:when test="${bc.memberImg ne null}">
											<img src="./images/${bc.memberImg}" class="img-raised img-circle">
										</c:when>
										<c:otherwise>
											<img src="./assets/img/base/Company.jpg" class="img-raised img-circle">
										</c:otherwise>
									</c:choose>
									</a>
			                       <h4 class="title"><a href="pageMain?pageId=${bc.memberId }">${bc.companyNm }</a><br />
										<small class="text-muted" align="left"><script>writeRate(${bc.memberEvaluationRating *10})</script><strong>${bc.memberEvaluationRating}</strong></small>
									</h4>
			                        <p class="description">test</p>
									<a href="#pablo" class="btn btn-simple btn-just-icon"><i class="fa fa-twitter"></i></a>
									<a href="#pablo" class="btn btn-simple btn-just-icon"><i class="fa fa-instagram"></i></a>
									<a href="#pablo" class="btn btn-simple btn-just-icon btn-default"><i class="fa fa-facebook-square"></i></a>
			                    </div>
			                </div>
			                </c:forEach>
						</div>
					</div>
	            </div>


	        	<div class="section landing-section">
	                <div class="row">
	                    <div class="col-md-8 col-md-offset-2">
	                        <h2 class="text-center title">Work with us</h2>
							<h4 class="text-center description">Divide details about your product or agency work into parts. Write a few lines about each one and contact us about any further collaboration. We will responde get back to you in a couple of hours.</h4>
	                        <form class="contact-form">
	                            <div class="row">
	                                <div class="col-md-6">
										<div class="form-group label-floating">
											<label class="control-label">Your Name</label>
											<input type="email" class="form-control">
										</div>
	                                </div>
	                                <div class="col-md-6">
										<div class="form-group label-floating">
											<label class="control-label">Your Email</label>
											<input type="email" class="form-control">
										</div>
	                                </div>
	                            </div>

								<div class="form-group label-floating">
									<label class="control-label">Your Messge</label>
									<textarea class="form-control" rows="4"></textarea>
								</div>

	                            <div class="row">
	                                <div class="col-md-4 col-md-offset-4 text-center">
	                                    <button class="btn btn-primary btn-raised">
											Send Message
										</button>
	                                </div>
	                            </div>
	                        </form>
	                    </div>
	                </div>

	            </div>
	        </div>

		</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>