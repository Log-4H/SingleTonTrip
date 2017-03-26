<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<style>
a.panelFocus a, a:hover, a:focus {
	color: black;
}
</style>
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/base/BackImage.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 1400px; margin-top: 80px">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>예약 내역</h4>
								</div>
								<div class="content">
									</br>
									<c:forEach items="${map.returnList}" var="i" varStatus="status">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" href="#collapse${status.index}">
														<div class="row">
															<div class="col-xs-12 col-sm-6 col-md-8" align="center">
																<c:choose>
																	<c:when test="${sessionLevel eq 2 || sessionLevel eq 1 }">
																		<h4>${i.reserveVo.person.memberNm}</h4>
																	</c:when>
																	<c:otherwise>
																		<h4>${i.reserveVo.room.company.memberNm}</h4>
																	</c:otherwise>
																</c:choose>
															</div>
															<div class="clearfix visible-xs"></div>
															<div class="col-xs-6 col-md-2">
																<h6>${i.reserveVo.reserveStayDay}일</h6>
															</div>
															<div class="col-xs-6 col-md-2">
																<h6>${i.reserveVo.paymentState.paymentStateNm}</h6>
															</div>
														</div>
													</a>
												</h4>
											</div>
											<div class="panel-body">
												<div id="collapse${status.index}" class="panel-collapse collapse">
													<br />
													<div class="row">
														<c:if test="${sessionLevel eq 2 || sessionLevel eq 1}">
															<div class="col-md-5 col-md-offset-2">
																연락처 : ${i.reserveVo.person.memberPhone}
															</div>
														</c:if>
														<c:if test="${sessionLevel eq 3 }">
															<div class="col-md-5 col-md-offset-2">${i.reserveVo.room.company.companyAddress}</div>
														</c:if>
														<div class="col-md-3 col-md-offset-2 " align="center">
															<a href="#reserveDetailModal" title="상세보기" data-toggle="modal"> 
																${i.reserveVo.room.roomNm} 
															</a>
														</div>
	
													</div>
													<div class="row">
														<div class="col-md-3 col-md-offset-2">
															예약일 : ${i.paymentVo.paymentFinishDate }
														</div>
														<div class="col-md-2 col-md-offset-2 " align="right">판매가</div>
														<div class="col-md-2" align="right">${i.paymentVo.paymentPrice }</div>
													</div>
													<div class="row">
														<div class="col-md-3 col-md-offset-2">
															입실일 : ${i.reserveVo.reserveCheckIn}
														</div>
														<div class="col-md-6">
															퇴실일 : ${i.reserveVo.reserveCheckOut}
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
									<!-- 페이징 -->
									<div align="center">
										<ul class="pagination pagination-info">
											<c:if test="${startPage>1}">
												<li>
													<a href="<c:url value='reserveList?currentPage=${startPage-pageSize}'/>">
														prev 
													</a>
												</li>
											</c:if>

											<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
												<li>
													<a href="<c:url value='reserveList?currentPage=${i}'/>">
														${i} 
													</a>
												</li>
											</c:forEach>
											<c:if test="${endPage ne lastPage}">
												<li>
													<a href="<c:url value='reserveList?currentPage=${startPage+pageSize}'/>">
														next 
													</a>
												</li>
											</c:if>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views//module/footer.jsp" />
</body>
</html>