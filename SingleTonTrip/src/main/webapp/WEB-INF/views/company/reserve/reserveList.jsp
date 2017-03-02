<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views//module/top.jsp"></c:import>
<body>
	<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 80px">
		<div class="w3-col m7">
			<div class="w3-row-padding">
				<div class="w3-col m12">
					<div class="w3-card-2 w3-round w3-white">
						<div class="w3-container w3-padding">
							<h3 class="w3-opacity">예약 내역</h3>
							<hr class="w3-clear">
							<c:forEach begin="1" end="10" step="1" var="i">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse${i}">
												<div class="row">
													<div class="col-xs-12 col-sm-6 col-md-8" align="center">
														<h4 class="w3-opacity">제목(컴퍼니 이름)</h4>
													</div>
													<div class="clearfix visible-xs"></div>
													<div class="col-xs-6 col-md-2">
														<h6 class="w3-opacity">숙박(1박)</h6>
													</div>
													<div class="col-xs-6 col-md-2">
														<h6 class="w3-opacity">대기중</h6>
													</div>
												</div>
											</a>
										</h4>
									</div>
									<div id="collapse${i}" class="panel-collapse collapse">
										<br />
										<div class="row">
											<div class="col-md-5 col-md-offset-2">전주 덕진동 워너비
												눈누날ㄹ라라랄라라</div>
											<div class="col-md-3 col-md-offset-2 " align="center">DELUXE
												501</div>
										</div>
										<div class="row">
											<div class="col-md-3 col-md-offset-2">예약일</div>
											<div class="col-md-2 col-md-offset-2 " align="right">판매가</div>
											<div class="col-md-2" align="right">600,000</div>
										</div>
										<div class="row">
											<div class="col-md-3 col-md-offset-2">입실 :
												2017.12.21(금)</div>
											<div class="col-md-6 col-sm-3">퇴실 : 2017.12.21(금)</div>
										</div>

										<div class="panel-body"></div>
									</div>
								</div>
							</c:forEach>
							<c:if test="${sessionLevel eq 1 }">
								<input type="button" class="w3-btn w3-theme" value="삭제" />
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<c:import url="/WEB-INF/views//module/footer.jsp"></c:import>