<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/test/top.jsp"></c:import>
<!-- modal -->
<c:if test="${sessionId eq pageId}">
<c:import url="./post/postModify.jsp"></c:import>
<c:import url="./post/postDelete.jsp"></c:import>
<c:import url="./trip/tripAdd.jsp"></c:import>
<c:import url="./trip/tripModify.jsp"></c:import>
<c:import url="./trip/tripDelete.jsp"></c:import>
<c:import url="./trip/planAdd.jsp"></c:import>
<c:import url="./trip/planModify.jsp"></c:import>
<c:import url="./trip/planDelete.jsp"></c:import>
</c:if>
<c:import url="./room/roomReserveList.jsp"></c:import>
<c:import url="./trip/tripJoin.jsp"></c:import>

<script>
	//프로필 요청 
	$(document).ready(
			function() {
				console.log($("#pageLevel").val());
				if ($("#pageLevel").val() == 2) {
					companyDetail();
				} else if ($("#pageLevel").val() == 3) {
					personDetail();
				}
				;

				//개인회원 프로필
				function personDetail() {
					$.ajax({
						url : "personDetail",
						type : "POST",
						dataType : "json",
						success : function(data) {
							var html = "";
							var person = data.person;
							var profileImg = "";
							if (person.memberImg != null) {
								profileImg = "./images/" + person.memberImg;
							} else if (person.personGender == "F") {
								profileImg = "./images/Female.png";
							} else {
								profileImg = "./images/Male.png";
							}
							$("#profileImg").attr("src", profileImg);
							$("#profileImg").attr("src", profileImg);
							html += "<h3 class='title'>" + person.memberNm
									+ "</h3>";
							html += "<h6>"
									+ person.personBirth + "</h6>";
							html += "<h6>"
									+ person.personGender + "</h6>";
							html += "<h6>"
									+ person.memberEmail + "</h6>";
							html += "<h6>"
									+ person.tripStateNm + "</h6>";

							$("#profileContent").html(html);
						}
					})
				}
				;

				//업체회원프로필
				function companyDetail() {
					$.ajax({
						url : "companyDetail",
						type : "POST",
						dataType : "json",
						success : function(data) {
							var html = "";
							var company = data.company;
							var profileImg = "";
							if (company.memberImg != null) {
								profileImg = "./images/" + company.memberImg;
							} else {
								profileImg = "./images/Company.jpg";
							}
							$("#profileImg").attr("src", profileImg);
							$("#profileImg").attr("src", profileImg);

							html += "<h3 class='title'>" + company.companyNm
									+ "</h3>";
							html += "<h6>" + company.memberNm
									+ "</h6>";
							html += "<h6>"
									+ company.companyTypeNm + "</h6>";
							html += "<h6>"
									+ company.memberPhone + "</h6>";
							html += "<h6>"
									+ company.memberEmail + "</h6>";

							$("#profileContent").html(html);
						}
					})
				}
				;

			});
</script>
<body class="profile-page">
<input type="hidden" id="pageId" value="${pageId}">
<input type="hidden" id="pageLevel" value="${pageLevel}">
<input type="hidden" id="sessionId" value="${sessionId}">
<input type="hidden" id="sessionLevel" value="${sessionLevel}">
<c:import url="/WEB-INF/views/test/nav.jsp"></c:import>
   <div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/examples/city.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
	            <div class="container">
	                <div class="row">
	                    <div class="profile">
	                        <div class="avatar">
	                            <img src="" alt="Circle Image" id="profileImg" class="img-circle img-responsive img-raised">
	                        </div>
	                        <div class="name" id="profileContent">
	                            <h3 class="title"></h3>
								<h6></h6>
	                        </div>
	                    </div>
	                </div>
					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="profile-tabs">
			                    <div class="nav-align-center">
									<ul class="nav nav-pills" role="tablist">
										<li class="active" id="postTab">
				                            <a href="#post" role="tab" data-toggle="tab">
												<i class="material-icons">palette</i>
												Post
				                            </a>
				                        </li>
										<c:if test="${pageLevel == 2}">
										<li id="roomTab">
											<a href="#room" role="tab" data-toggle="tab">
												<i class="material-icons">camera</i>
												Room
											</a>
										</li>
										</c:if>
										<c:if test="${pageLevel == 3}">
										<li id="tripTab">
											<a href="#trip" role="tab" data-toggle="tab">
												<i class="material-icons">camera</i>
												Trip
											</a>
										</li>
										</c:if>
				                        <li id="evaluationTab">
				                            <a href="#evaluation" role="tab" data-toggle="tab">
												<i class="material-icons">favorite</i>
				                                Evaluation
				                            </a>
				                        </li>
				                    </ul>
				                    <div class="tab-content gallery">
				                        <c:import url="./post/postList.jsp"></c:import>
										<c:if test="${pageLevel == 2}">
										<c:import url="./room/roomList.jsp"></c:import>
										</c:if>
										<c:if test="${pageLevel == 3}">
										<c:import url="./trip/tripList.jsp"></c:import>
										</c:if>
				                    </div>
								</div>
							</div>
							<!-- End Profile Tabs -->
						</div>
	                </div>

	            </div>
	        </div>
		</div>
<c:import url="/WEB-INF/views/test/footer.jsp"></c:import>
</div>
</body>
</html>