<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/pageJs/groupAjax.js'/>"></script>
<c:import url="./group/groupList.jsp"></c:import>
<input type="hidden" id="pageId" value="${pageId}">
<input type="hidden" id="pageLevel" value="${pageLevel}">
<input type="hidden" id="sessionId" value="${sessionId}">
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

							html += "<p id='profileId'>" + person.memberId
									+ "</p>";
							html += "<p id='profileNm'>" + person.memberNm
									+ "</p>";
							html += "<p id='profileBirth'>"
									+ person.personBirth + "</p>";
							html += "<p id='profileGender'>"
									+ person.personGender + "</p>";
							html += "<p id='profileEmail'>"
									+ person.memberEmail + "</p>";
							html += "<p id='profileState'>"
									+ person.tripStateNm + "</p>";

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

							html += "<p id='profileId'>" + company.memberId
									+ "</p>";
							html += "<p id='profileNm'>" + company.memberNm
									+ "</p>";
							html += "<p id='profileCom'>" + company.companyNm
									+ "</p>";
							html += "<p id='profileType'>"
									+ company.companyTypeNm + "</p>";
							html += "<p id='profilePhone'>"
									+ company.memberPhone + "</p>";
							html += "<p id='profileEmail'>"
									+ company.memberEmail + "</p>";

							$("#profileContent").html(html);
						}
					})
				}
				;

			});
</script>


<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 80px">
	<!-- The Grid -->
	<div class="w3-row">
		<!-- Left Column -->
		<div class="w3-col m3">
			<!-- Profile -->
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container">
					<h4 class="w3-center">My Profile</h4>
					<p class="w3-center">
						<img id="profileImg" src="" class="w3-circle"
							style="height: 106px; width: 106px" alt="Avatar">
					</p>
					<hr>
					<div id="profileContent"></div>
					<!-- 
					<p>
						<i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i>
						April 1, 1988
					</p> 
					-->
				</div>
			</div>
			<br>

			<!-- Accordion -->
			<div class="w3-card-2 w3-round">
				<div class="w3-accordion w3-white">
					<c:if test="${pageLevel == 2}">
						<button class="w3-btn-block w3-theme-l1 w3-left-align"
							onclick="myFunction('reserveTab')">
							<i class="fa fa-bars fa-fw w3-margin-right"></i> My Reserve
						</button>
						<div align="center" id="reserveTab"
							class="w3-hide w3-Lightgray w3-container">
							<p>reserve</p>
						</div>
					</c:if>
					<c:if test="${pageLevel == 3}">
						<button class="w3-btn-block w3-theme-l1 w3-left-align"
							onclick="myFunction('groupTab')">
							<i class="fa fa-bars fa-fw w3-margin-right"></i> My Groups
						</button>
						<div align="center" id="groupTab"
							class="w3-hide w3-Lightgray w3-container">
							<c:if test="${sessionId eq pageId}">
								<p class="groupListModalShow" value="leader">생성한 그룹</p>
							</c:if>
							<p class="groupListModalShow" value="member">가입한 그룹</p>
						</div>
					</c:if>
				</div>
			</div>
			<br>

			<!-- Interests -->
			<div class="w3-card-2 w3-round w3-white w3-hide-small">
				<div class="w3-container">
					<p>Interests</p>
					<p>
						<span class="w3-tag w3-small w3-theme-d5">Newseeeeeee</span> <span
							class="w3-tag w3-small w3-theme-d4">W3Schools</span> <span
							class="w3-tag w3-small w3-theme-d3">Labels</span> <span
							class="w3-tag w3-small w3-theme-d2">Games</span> <span
							class="w3-tag w3-small w3-theme-d1">Friends</span> <span
							class="w3-tag w3-small w3-theme">Games</span> <span
							class="w3-tag w3-small w3-theme-l1">Friends</span> <span
							class="w3-tag w3-small w3-theme-l2">Food</span> <span
							class="w3-tag w3-small w3-theme-l3">Design</span> <span
							class="w3-tag w3-small w3-theme-l4">Art</span> <span
							class="w3-tag w3-small w3-theme-l5">Photos</span>
					</p>
				</div>
			</div>
			<br>

			<!-- Alert Box -->
			<div
				class="w3-container w3-round w3-theme-l4 w3-border w3-theme-border w3-margin-bottom w3-hide-small">
				<span onclick="this.parentElement.style.display='none'"
					class="w3-hover-text-grey w3-closebtn"> <i
					class="fa fa-remove"></i>
				</span>
				<p>
					<strong>Hey!</strong>
				</p>
				<p>People are looking at your profile. Find out who.</p>
			</div>


		</div>
		<!-- End Left Column -->

		<script>
			function myFunction(id) {
				var x = document.getElementById(id);
				if (x.className.indexOf("w3-show") == -1) {
					x.className += " w3-show";
					x.previousElementSibling.className += " w3-theme-d1";
				} else {
					x.className = x.className.replace("w3-show", "");
					x.previousElementSibling.className = x.previousElementSibling.className
							.replace(" w3-theme-d1", "");
				}
			}
		</script>