<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/test/top.jsp"></c:import>
<script src="<c:url value='/js/imageView.js'/>"></script>
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
	                <div class="description text-center">
                        <p>An artist of considerable range, Chet Faker — the name taken by Melbourne-raised, Brooklyn-based Nick Murphy — writes, performs and records all of his own music, giving it a warm, intimate feel with a solid groove structure. </p>
	                </div>

					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="profile-tabs">
			                    <div class="nav-align-center">
									<ul class="nav nav-pills" role="tablist">
										<li class="active">
											<a href="#studio" role="tab" data-toggle="tab">
												<i class="material-icons">camera</i>
												Studio
											</a>
										</li>
										<li>
				                            <a href="#work" role="tab" data-toggle="tab">
												<i class="material-icons">palette</i>
												Work
				                            </a>
				                        </li>
				                        <li>
				                            <a href="#shows" role="tab" data-toggle="tab">
												<i class="material-icons">favorite</i>
				                                Favorite
				                            </a>
				                        </li>
				                    </ul>

				                    <div class="tab-content gallery">
										<div class="tab-pane active" id="studio">
				                            <div class="row">
												<div class="col-md-6">
													<img src="./assets/img/examples/chris1.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris0.jpg" class="img-rounded" />
												</div>
												<div class="col-md-6">
													<img src="./assets/img/examples/chris3.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris4.jpg" class="img-rounded" />
												</div>
				                            </div>
				                        </div>
				                        <div class="tab-pane text-center" id="work">
											<div class="row">
												<div class="col-md-6">
													<img src="./assets/img/examples/chris5.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris7.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris9.jpg" class="img-rounded" />
												</div>
												<div class="col-md-6">
													<img src="./assets/img/examples/chris6.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris8.jpg" class="img-rounded" />
												</div>
											</div>
				                        </div>
										<div class="tab-pane text-center" id="shows">
											<div class="row">
												<div class="col-md-6">
													<img src="./assets/img/examples/chris4.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris6.jpg" class="img-rounded" />
												</div>
												<div class="col-md-6">
													<img src="./assets/img/examples/chris7.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris5.jpg" class="img-rounded" />
													<img src="./assets/img/examples/chris9.jpg" class="img-rounded" />
												</div>
											</div>
				                        </div>

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
</body>
</html>