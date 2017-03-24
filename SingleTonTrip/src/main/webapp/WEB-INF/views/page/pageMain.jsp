<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<!-- modal -->
<c:if test="${sessionId eq pageId}">
<c:import url="./post/postAdd.jsp"></c:import>
<c:import url="./post/postModify.jsp"></c:import>
<c:import url="./post/postDelete.jsp"></c:import>
<c:import url="./trip/tripAdd.jsp"></c:import>
<c:import url="./trip/tripModify.jsp"></c:import>
<c:import url="./trip/tripDelete.jsp"></c:import>
<c:import url="./trip/planAdd.jsp"></c:import>
<c:import url="./trip/planModify.jsp"></c:import>
<c:import url="./trip/planDelete.jsp"></c:import>
</c:if>
<c:import url="./evaluation/evaluationAdd.jsp"></c:import>
<c:import url="./room/roomReserveList.jsp"></c:import>
<c:import url="./trip/tripJoin.jsp"></c:import>
<body class="profile-page">
<script src="<c:url value='/js/pageJs/pageMain.js'/>"></script>
<input type="hidden" id="pageId" value="${pageId}">
<input type="hidden" id="pageLevel" value="${pageLevel}">

<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
   <div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/examples/city.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
	            <div class="container">
	                <div class="row">
	                    <div class="profile">
	                        <div class="avatar">
	                            <img src="" alt="Circle Image" id="profileImg" class="img-circle img-responsive img-raised">
	                            <div>
		                            <button type='button' id='friendApproveBtn' class='btn btn-info btn-simple btn-xs pageFriendAddBtn' style='display:none;'>
									<i class='fa fa-user-plus' aria-hidden='true'></i></button>
									<c:if test="${sessionId ne null && sessionId ne pageId }">
									<a href='reportAdd?reportId=${pageId}'>
									<button type='button' class='btn btn-danger btn-simple btn-xs'>
									<i class='fa fa-bell' aria-hidden='true'></i></button></a>
									</c:if>
	                            </div>
	                        </div>
	                        <div class="name" id="profileContent">
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
												<i class="fa fa-list" aria-hidden="true"></i>
												Post
				                            </a>
				                        </li>
										<c:if test="${pageLevel == 2}">
										<li id="roomTab">
											<a href="#room" role="tab" data-toggle="tab">
												<i class="fa fa-bed" aria-hidden="true"></i>
												Room
											</a>
										</li>
										</c:if>
										<c:if test="${pageLevel == 3}">
										<li id="tripTab">
											<a href="#trip" role="tab" data-toggle="tab">
												<i class="fa fa-plane" aria-hidden="true"></i>
												Trip
											</a>
										</li>
										</c:if>
				                        <li id="evaluationTab">
				                            <a href="#evaluation" role="tab" data-toggle="tab">
												<i class="fa fa-address-card" aria-hidden="true"></i>
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
										<c:import url="./evaluation/evaluationList.jsp"></c:import>
				                    </div>
								</div>
							</div>
							<!-- End Profile Tabs -->
						</div>
	                </div>

	            </div>
	        </div>
		</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</div>
</body>
</html>