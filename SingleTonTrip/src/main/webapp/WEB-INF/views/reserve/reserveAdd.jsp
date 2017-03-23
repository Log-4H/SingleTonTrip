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
					<div class="row" style="height: 1400px; margin-top: 80px">
					
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<form method="post" action="faqAdd">
									<div class="header header-primary text-center" style="height: 80px;">
										<h4>예약</h4>
									</div>
									<div class="content">
									<div class="row-fluid">
									<div class="col-md-6">
									예약정보
									<!-- 받아온 데이터 가져오기 -->
										<div class="col-md-4" >
											체크인
											<input class="form-control  text-center"  type="date" value="2017-03-12" readonly="readonly" name="reserveCheckinDate" style=" border-left-width: 0px; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0.08; "  >
										</div >
										<div class="col-md-4" >
											체크아웃
											<input class="form-control  text-center" type="date" value="2017-03-13" name="reserveCheckoutDate" style=" border-left-width: 0px; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0.08; ">
										</div>
										
							

										</br>
										
										<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="text" class="form-control" name="boardTitle" placeholder="예약자명">
										</div>
										<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="text" class="form-control" name="boardTitle" placeholder="연락처">
										</div>
									</div>
									<div class="col-md-6">
									결제정보
									<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="text" class="form-control" name="boardTitle" placeholder="판매금액">
										</div>
										
										<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="text" class="form-control" name="boardTitle" placeholder="결제금액">
										</div>
										<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="text" class="form-control" name="boardTitle" placeholder="사용 마일리지">
										</div>
										<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="text" class="form-control" name="boardTitle" placeholder="적립 예정 마일리지">
										</div>
										<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="text" class="form-control" name="boardTitle" placeholder="적립 예정 마일리지">
										</div>
									</div>
										</div>
										
									</div>
									<div class="footer text-center">
										<button type="submit" class="btn btn-simple btn-primary btn-lg">결제</button>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 우측 광고  
		<c:import url="../page/pageModule/right.jsp" />
		-->
	</div>
	<c:import url="/WEB-INF/views/module/footer.jsp" />
</body>
</html>