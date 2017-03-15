<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp" />

<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">

		<div class="w3-col m7">
			<div class="w3-row-padding" >
				<div class="w3-col m12" >
					<div class="w3-card-2 w3-round w3-white">
						<div class="w3-container w3-padding">
							<h3 class="w3-opacity">예약 내역</h3>
							<hr class="w3-clear">
							
							<!-- 받아온 데이터 가져오기 -->
							<input type="date" value="2017-03-12" readonly="readonly" name="reserveCheckinDate">
							<input type="date" value="2017-03-12" name="reserveCheckoutDate">
							
							<hr class="w3-clear">
							
							<!-- DB 에서 가져와야지 -->
								예약자명 :</br>
								연락처 :</br>
								
								판매금액 :</br>
								결제금액 :</br>
								사용 마일리지 : <input type="text" /></br>
								적립 예정금액 : </br>
						</div>
					</div>
				</div>
			</div>
			
			<div class="w3-row-padding" >
				<div class="w3-col m12" >
					<div class="w3-card-2 w3-round w3-white">
						<div class="w3-container w3-padding">
							<h3 class="w3-opacity">예약 내역</h3>
							<hr class="w3-clear">
							
							<!-- 받아온 데이터 가져오기 -->
							<input type="date" value="2017-03-12" readonly="readonly" name="reserveCheckinDate">
							<input type="date" value="2017-03-12" name="reserveCheckoutDate">
							
							<hr class="w3-clear">
							
							<!-- DB 에서 가져와야지 -->
								예약자명 :</br>
								연락처 :</br>
								
								판매금액 :</br>
								결제금액 :</br>
								사용 마일리지 : <input type="text" /></br>
								적립 예정금액 : </br>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 우측 광고  -->
		<c:import url="../page/pageModule/right.jsp" />
		
	</div>

<c:import url="../module/footer.jsp" />