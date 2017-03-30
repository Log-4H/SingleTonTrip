<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<style>
.manualImg {
	max-width: 100%;
}

.manualTitle {
	font-weight: 600;
	font-size: 14pt;
}

.manualPurpose {
	font-weight: 900;
	font-size: 18pt;
}
</style>
<script>
	$(document).on('click', '#scrollToManualMenu', function() {
		$(document).scrollTop(0);
	});
</script>
<body class="signup-page">
	<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/BackImage.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div>
						<div class="card card-signup">
							<div class="header header-primary text-center">
								<h4 class="manualTitle">Singleton Trip 메뉴얼</h4>
							</div>
							<div class="content">
								<ul class="nav nav-tabs navbar-info">
									<li class="active in"><a href="#manual1" data-toggle="tab"
										aria-expanded="false">회원가입</a></li>
									<li><a href="#manual2" data-toggle="tab"
										aria-expanded="false">마이페이지</a></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#" aria-expanded="false">
											여행 <span class="caret"></span>
									</a>
										<ul class="dropdown-menu">
											<li><a href="#manual3-1"
												data-toggle="tab" aria-expanded="true">여행등록</a></li>
											<li><a href="#manual3-2" data-toggle="tab"
												aria-expanded="false">여행참가</a></li>
											<li><a href="#manual3-3" data-toggle="tab"
												aria-expanded="false">그룹원 승인/거절</a></li>
											<li><a href="#manual3-4" data-toggle="tab"
												aria-expanded="false">신청취소/그룹탈퇴</a></li>
											<li><a href="#manual3-5" data-toggle="tab"
											aria-expanded="false">모집마감</a></li>
										</ul>
									</li>
									<li><a href="#manual4" data-toggle="tab"
										aria-expanded="false">평가</a></li>
									<li><a href="#manual5" data-toggle="tab"
									aria-expanded="false">친구</a></li>
									<li><a href="#manual6" data-toggle="tab"
									aria-expanded="false">예약</a></li>
									<li><a href="#manual7" data-toggle="tab"
										aria-expanded="false">광고</a></li>
								</ul>
								<div id="myTabContent" class="tab-content">
									<div class="tab-pane fade active in" id="manual1"
										align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 서비스 이용을 위해 회원가입은 필수! *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단바의 회원가입 클릭</p>
										<img src="./assets/img/manual/manual1/1-1.png" class="manualImg">
										<hr>
										<p class="manualTitle">2. 회원 등급 선택</p>
										<br> <img src="./assets/img/manual/manual1/1-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 약관 동의 후 다음</p>
										<br> <img src="./assets/img/manual/manual1/1-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 정보 입력후 회원가입 누르면 가입완료!</p>
										<br> <img src="./assets/img/manual/manual1/1-4.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual2" align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 포스트 등록을 통해 소통하세요! *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단바의 마이페이지 클릭</p>
										<br> <img src="./assets/img/manual/manual2/2-1.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">2. 마이페이지 화면</p>
										<br> <img src="./assets/img/manual/manual2/2-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 포스트 등록 버튼 클릭!</p>
										<br> <img src="./assets/img/manual/manual2/2-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 제목과 내용을 입력</p>
										<br> <img src="./assets/img/manual/manual2/2-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">5. 포스트 등록 완료!</p>
										<br> <img src="./assets/img/manual/manual2/2-5.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual3-1" align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 여행을 같이 갈 회원을 모집하세요! *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 마이페이지의 여행모집글 등록을 클릭!</p>
										<br> <img src="./assets/img/manual/manual3/3-1-1.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">2. 여행지역과 정보, 여행기간을 입력하세요!</p>
										<br> <img src="./assets/img/manual/manual3/3-1-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 등록완료! 상세보기를 누르면 자세한 내용을 볼수 있어요.</p>
										<p style="color:red;">* 여행을 등록하면 자동으로 그룹이 생성되요!</p>
										<br> <img src="./assets/img/manual/manual3/3-1-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 여행 계획을 등록하고 싶으면 일정등록을 눌러주세요</p>
										<br> <img src="./assets/img/manual/manual3/3-1-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">5. 일정시간 및 예상경비를 입력하세요!</p> 
										<p style="color:red;">* PlanSite를 정확히 입력해야 지도에 표시가되요!</p>
										<br> <img src="./assets/img/manual/manual3/3-1-5.png"
											class="manualImg">
										<p class="manualTitle">6. 일정까지 등록완료!</p>
										<br> <img src="./assets/img/manual/manual3/3-1-6.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual3-2" align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 다른 여행그룹에 참가할 수 있어요! *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단바의 여행 클릭!</p>
										<p style="color:red;">* 다른 회원의 페이지에 접속해도 여행을 볼 수 있어요!</p>
										<br> <img src="./assets/img/manual/manual3/3-2-1.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">2. 원하는 여행을 검색 후 클릭!</p>
										<br> <img src="./assets/img/manual/manual3/3-2-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 여행 계획이 마음에 들면 참가신청!</p>
										<br> <img src="./assets/img/manual/manual3/3-2-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 신청 후 그룹장의 승인을 기다려요!</p>
										<br> <img src="./assets/img/manual/manual3/3-2-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">5. 상단의 내 그룹 -> 가입한 그룹 클릭!</p> 
										<br> <img src="./assets/img/manual/manual3/3-2-5.png"
											class="manualImg">
										<p class="manualTitle">6. 내가 가입한 그룹 리스트가 보여요.</p>
										<br> <img src="./assets/img/manual/manual3/3-2-6.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">7. 여행에 대한 정보와 그룹원 정보가 나와요!</p>
										<br> <img src="./assets/img/manual/manual3/3-2-7.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual3-3" align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 가입신청한 회원을 관리해요 *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단의 내 그룹 -> 생성한 그룹 클릭!</p>
										<br> <img src="./assets/img/manual/manual3/3-3-1.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">2. 내가 생성한 그룹 리스트가 보여요.</p>
										<br> <img src="./assets/img/manual/manual3/3-3-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 하단의 참가신청자 클릭!</p>
										<br> <img src="./assets/img/manual/manual3/3-3-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 승인 또는 거절을 눌러 참가여부를 결정하세요.</p>
										<br> <img src="./assets/img/manual/manual3/3-3-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">5. 참가여부가 반영!</p> 
										<br> <img src="./assets/img/manual/manual3/3-3-5.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual3-4" align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 그룹탈퇴 및 신청을 취소 할 수 있어요.*</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단의 내 그룹 -> 가입한 그룹 클릭!</p>
										<br> <img src="./assets/img/manual/manual3/3-4-1.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">2. 노란버튼을 클릭하면 가입신청을 취소할 수 있어요.</p>
										<br> <img src="./assets/img/manual/manual3/3-4-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 빨간버튼을 클릭하면 그룹에서 탈퇴할 수 있어요.</p>
										<p style="color:red;">* 그룹탈퇴시 재가입이 안되니 신중히 결정하세요!</p>
										<br> <img src="./assets/img/manual/manual3/3-4-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 탈퇴 완료!</p>
										<br> <img src="./assets/img/manual/manual3/3-4-4.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual3-5" align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 모집인원을 채우지 못해도 마감할 수 있어요*</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단의 내 그룹 -> 생성한 그룹 클릭!</p>
										<br> <img src="./assets/img/manual/manual3/3-5-1.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">2. 초록버튼을 클릭하면 모집을 마감할 수 있어요.</p>
										<br> <img src="./assets/img/manual/manual3/3-5-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. END를 누르면 모집마감!</p>
										<br> <img src="./assets/img/manual/manual3/3-5-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 모집 마감 완료!</p>
										<br> <img src="./assets/img/manual/manual3/3-5-4.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual4"
										align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 여행 및 업체 이용 후 해당 회원을 평가해주세요! *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 해당 회원의 페이지 접속 후 평가 등록 클릭</p>
										<img src="./assets/img/manual/manual4/4-1.png" class="manualImg">
										<hr>
										<p class="manualTitle">2. 별점과 함께 상세내용을 입력하세요!</p>
										<br> <img src="./assets/img/manual/manual4/4-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 평가등록 완료!</p>
										<br> <img src="./assets/img/manual/manual4/4-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 내가 준 점수가 해당회원에게 반영되요!</p>
										<br> <img src="./assets/img/manual/manual4/4-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 평점이 높은 회원은 메인화면에 나타나요!</p>
										<br> <img src="./assets/img/manual/manual4/4-5.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual5"
										align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 마음에 드는 회원과 친구를 맺어보세요. *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 해당 회원의 페이지 접속 후 친구추가 클릭</p>
										<img src="./assets/img/manual/manual5/5-1.png" class="manualImg">
										<hr>
										<p class="manualTitle">2. 상단바의 친구탭클릭!</p>
										<br> <img src="./assets/img/manual/manual5/5-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 친구요청리스트에서 나에게 신청한 회원을 볼 수 있어요.</p>
										<br> <img src="./assets/img/manual/manual5/5-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 친구신청리스트에서 내가 신청한 회원을 볼 수 있어요.</p>
										<br> <img src="./assets/img/manual/manual5/5-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">5. 친구리스트에서 나와 친구인 회원을 볼 수 있어요.</p>
										<br> <img src="./assets/img/manual/manual5/5-5.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual6"
										align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 마음에 드는 숙소를 예약하세요! *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단바의 숙소 클릭!</p>
										<img src="./assets/img/manual/manual6/6-1.png" class="manualImg">
										<hr>
										<p class="manualTitle">2. 마음에 드는 업체 검색 후 클릭!</p>
										<br> <img src="./assets/img/manual/manual6/6-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 해당업체 페이지의 위치 확인 후 Room 탭 클릭!</p>
										<br> <img src="./assets/img/manual/manual6/6-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 객실 정보를 확인하고 실시간예약 클릭!</p>
										<br> <img src="./assets/img/manual/manual6/6-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">5. 예약할 날짜(숙박시작일)를 선택!</p>
										<br> <img src="./assets/img/manual/manual6/6-5.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">6. 예약정보 확인 후 결제!</p>
										<br> <img src="./assets/img/manual/manual6/6-6.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">7. 결제완료!</p>
										<br> <img src="./assets/img/manual/manual6/6-7.png"
											class="manualImg">
										<hr>
									</div>
									<div class="tab-pane fade" id="manual7"
										align="center">
										<br>
										<br>
										<br>
										<p class="manualPurpose">* 광고를 통해 업체를 홍보하세요! *</p>
										<br>
										<br>
										<br>
										<hr>
										<p class="manualTitle">1. 상단바의 광고 클릭!</p>
										<img src="./assets/img/manual/manual7/7-1.png" class="manualImg">
										<hr>
										<p class="manualTitle">2. 광고 신청 클릭 후 마음에 드는 광고를 선택하세요!</p>
										<br> <img src="./assets/img/manual/manual7/7-2.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">3. 광고신청리스트에서 신청한 광고를 확인할 수 있어요.</p>
										<br> <img src="./assets/img/manual/manual7/7-3.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">4. 결제를 통해 관리자의 승인을 받으세요!</p>
										<br> <img src="./assets/img/manual/manual7/7-4.png"
											class="manualImg">
										<hr>
										<p class="manualTitle">5. 결제 완료후 관리자의 승인을 받으면 광고가 등록되요!</p>
										<br> <img src="./assets/img/manual/manual7/7-5.png"
											class="manualImg">
										<hr>
									</div>
								</div>
							</div>
							<div align="center">
								<button type='button' id="scrollToManualMenu"
									class='btn btn-primary'>상단으로</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>