<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/BackImage.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="margin-top: 80px; height: responsive;">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>여행상세보기</h4>
								</div>
									<div class="content">
										<div align='right'>
										<c:if test="${sessionId ne null && trip.recruitStateCd eq 1 && sessionId ne trip.personId}">
											<button type='button' class='btn btn-success' id="tripApplyModalShow" value="${trip.tripNo }"><i class='fa fa-user'>참가신청</i></button>
										</c:if>
									</div>
									<c:choose>
										<c:when test="${trip.recruitStateCd eq 1}">
											<span class='label label-success'>${trip.recruitStateNm}</span>
										</c:when>
										<c:when test="${trip.recruitStateCd eq 2}">
											<span class='label label-warning'>${trip.recruitStateNm}</span>
										</c:when>
										<c:when test="${trip.recruitStateCd eq 3}">
											<span class='label label-danger'>${trip.recruitStateNm}</span>
										</c:when>
									</c:choose>
									<h6>${trip.tripRegDate}</h6>
									<h3><strong>${trip.tripTitle}</strong></h3>
									<p>${trip.tripThemeNm}</p>
									<c:choose>
										<c:when test="${trip.regionDo ne trip.regionSi}">
											<p>${trip.regionDo} ${trip.regionSi}</p>
										</c:when>
										<c:otherwise>
											<p>${trip.regionDo}</p>
										</c:otherwise>
									</c:choose>
									<hr>
									<h4> ${trip.tripContent}</h4>
									<hr>
									<p>참여인원(현재인원/총인원) : ${trip.tripPresentMember}  / ${trip.tripMaxMember}</p>
									<p>여행기간 : ${trip.tripStartDate} ~ ${trip.tripEndDate}</p>
									<p>예상경비(1인경비/총경비) : ${trip.tripPerPrice} / ${trip.tripTotalPrice}</p>
									<p>모집기간 : ${trip.tripRecruitStartDate} ~ ${trip.tripRecruitEndDate}</p>
									<p>태그 : #${trip.tripTag}</p>
									<hr>
									<div id='planDetail'></div>
									<div>
									<button type='button' class='btn btn-primary' id="planDetailBtn" value='${trip.tripNo}'>
									일정보기</button>
									<input type='hidden' id='planFlag' value='close'>
									</div>
									
								</div>
							</div>
							<br><br><br><br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/module/footer.jsp" />
</body>
</html>