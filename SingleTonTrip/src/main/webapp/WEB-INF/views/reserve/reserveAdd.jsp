<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/examples/city.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<!-- row와 row-fluid 차이가 뭘까 -->
					<div class="row" style="height: 100%; margin-top: 80px; margin-bottom: 80px;">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<!-- 상단 보라색 타이틀 -->
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>방이름</h4>
								</div>
								<form method="post" action="reserveInsert">
									<div id="pricing" class="container-fluid">

										<div class="row-fluid slideanim">
											<div class="col-sm-12 col-xs-12">
												체크인
												<input name="reserveCheckinDate" type="date" value="${reserveCheckinDate }" readonly="readonly" /> 
												체크아웃
												<input name="reserveCheckoutDate"type="date" value="${reserveCheckinDate }" />
											</div>
											<div class="col-sm-6 col-xs-12">
												<div class="panel panel-default text-center">
													<div class="panel-body">
														<div>
															<img src="http://blog.joins.com/usr/f/a/fabiano/14/9.JPG"
																alt="Rounded Image" class="img-rounded img-responsive"
																style="width: 100%; height: 200px;">
														</div>

														</br>
														<div class="input-group">
															<span class="input-group-addon">판매금액</span> 
															<input
																type="text" class="form-control" name=""
																placeholder="${room.roomNormalPrice }"
																readonly="readonly"> 
															<span class="input-group-addon"></span>
														</div>

														<div class="input-group">
															<span class="input-group-addon">예약자명</span> 
															<input
																type="text" class="form-control" name="boardTitle"
																placeholder="${person.memberNm}" readonly="readonly">
															<span class="input-group-addon"></span>
														</div>
														<div class="input-group">
															<span class="input-group-addon">휴대전화</span> 
															<input
																type="text" class="form-control" name="boardTitle"
																placeholder="${person.memberPhone }" readonly="readonly">
															<span class="input-group-addon"></span>
														</div>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-xs-12">
												<div class="panel panel-default text-center">
													<div class="panel-heading">
														<h4>결제정보</h4>
													</div>
													<div class="panel-body">
														<div class="input-group">
															<span class="input-group-addon">보유 마일리지</span> 
															<input
																type="text" class="form-control" name="boardTitle"
																placeholder="${person.personTotalMileage }"
																readonly="readonly"> 
															<span class="input-group-addon"></span>
														</div>
														<div class="input-group">
															<span class="input-group-addon">마일리지 사용</span> 
															<input type="text" class="form-control" name="boardTitle">
															<span class="input-group-addon"></span>
														</div>
														<div class="input-group">
															<span class="input-group-addon">결제 금액</span> 
															<input
																type="text" class="form-control" name="boardTitle"
																readonly="readonly"> 
															<span class="input-group-addon"></span>
														</div>
														<div class="checkbox">
															<label> 
																<input type="checkbox" name="optionsCheckboxes" checked="checked"> 
																이용 약관 동의
															</label>
														</div>
														<%-- 
														<div class="input-group">
															<p>
																<span class="input-group">Paragraph</span> 노쇼(No-Show :
																사전 연락없이 예약 된 숙소를 이용하지 않는 경우)의 경우 요금이 100% 정상 청구 됩니다.
															</p>
														</div>
														<div class="input-group">
															<p>
																<span class="input-group">Paragraph</span> 미성년자는 이용불가하며,
																추후 미성년자에 의한 예약임이 밝혀졌을 시 환불 불가합니다. ‘휴대폰결제’의 경우, 취소 시점에 따라
																취소수수료가 재승인될 수 있습니다. ‘휴대폰결제’의 경우, 익월 취소 시 야놀자포인트로만 환불 처리가
																가능합니다.
															</p>
														</div>

														<table class="chart_cancel">
															<colgroup>
																<col width="50%">
																<col width="50%">
															</colgroup>
															<tbody>
																<tr>
																	<th>취소기준일</th>
																	<th>취소수수료</th>
																</tr>
																<tr>
																	<td>입실 3시간 전 까지</td>
																	<td>없음</td>
																</tr>
																<tr>
																	<td>입실 3시간 전 부터</td>
																	<td>환불불가</td>
																</tr>
															</tbody>
														</table>
 --%>


														</br>
														<!-- <p>
															<strong>Endless</strong> Amet
														</p> -->
														<button type="submit" class="btn btn-info">결제</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
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