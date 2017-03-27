<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<script type="text/javascript">
$(function() {
    $('#endDate').change(function(e) {
        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;
        var startDateArr = startDate.split('-');
        var endDateArr = endDate.split('-');
        var checkinDate = new Date(startDateArr[0], startDateArr[1], startDateArr[2]);
        var checkoutDate = new Date(endDateArr[0], endDateArr[1], endDateArr[2]);
         
        // 날짜 차이 알아 내기
        var diff = checkoutDate - checkinDate;
        var currDay = 24 * 60 * 60 * 1000;// 시 * 분 * 초 * 밀리세컨
        var currMonth = currDay * 30;// 월 만듬
        var currYear = currMonth * 12; // 년 만듬
        
        var diff = parseInt(diff/currDay);
       /*  document.write("* 날짜 두개 : " + strDate1 + ", " + strDate2 + "<br/>");
        document.write("* 일수 차이 : " + parseInt(diff/currDay) + " 일<br/>");
        document.write("* 월수 차이 : " + parseInt(diff/currMonth) + " 월<br/>");
        document.write("* 년수 차이 : " + parseInt(diff/currYear) + " 년<br/><br/>"); */
        $("#stayDay").html(diff+'박');
    });
});

</script>

<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/base/BackImage.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 100%; margin-top: 80px; margin-bottom: 80px;">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								
								<!-- 상단 보라색 타이틀 -->
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>방이름</h4>
								</div>
								
								<!-- 전송 -->
								<form method="post" action="reserveInsert">
									<div id="pricing" class="container-fluid">
									<input name="reserve.room.roomNo" type="hidden" value="${room.roomNo} ">

										<div class="row-fluid slideanim">
											<div class="col-sm-12 col-xs-12">
												체크인
												<input name="reserve.reserveCheckinDate" id="startDate" type="date" value="${reserveCheckinDate }" readonly="readonly" /> 
												체크아웃
												<input name="reserve.reserveCheckoutDate" id="endDate" type="date" value="${reserveCheckinDate }" />
												<p id="stayDay" ></p>
											</div>
											
											<!-- 예약정보 -->
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
																type="text" class="form-control" name="payment.paymentTotalPrice"
																value="${room.roomNormalPrice }"
																readonly="readonly"> 
															<span class="input-group-addon"></span>
														</div>

														<div class="input-group">
															<span class="input-group-addon">예약자명</span> 
															<input
																type="text" class="form-control"
																placeholder="${person.memberNm}" readonly="readonly">
															<span class="input-group-addon"></span>
														</div>
														<div class="input-group">
															<span class="input-group-addon">휴대전화</span> 
															<input
																type="text" class="form-control"
																placeholder="${person.memberPhone }" readonly="readonly">
															<span class="input-group-addon"></span>
														</div>
													</div>
												</div>
											</div>
											
											<!-- 결제 정보 -->
											<div class="col-sm-6 col-xs-12">
												<div class="panel panel-default text-center">
													<div class="panel-heading">
														<h4>결제정보</h4>
													</div>
													<div class="panel-body">
														<div class="input-group">
															<span class="input-group-addon">보유 마일리지</span> 
															<input
																type="text" class="form-control"
																placeholder="${person.personTotalMileage }"
																readonly="readonly"> 
															<span class="input-group-addon"></span>
														</div>
														<div class="input-group">
															<span class="input-group-addon">마일리지 사용</span> 
															<input type="text" class="form-control" name="payment.paymentUseMileage">
															<span class="input-group-addon"></span>
														</div>
														<div class="input-group">
															<span class="input-group-addon">결제 금액</span> 
															<input
																type="text" class="form-control" name="payment.paymentPrice"
																readonly="readonly"> 
															<span class="input-group-addon"></span>
														</div>
														<div class="checkbox">
															<label> 
																<input type="checkbox" name="" checked="checked"> 
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