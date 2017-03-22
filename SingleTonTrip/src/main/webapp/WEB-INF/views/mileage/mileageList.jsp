<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/test/top.jsp" />
<style>
div.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

div.list {
	padding: 10px;
}
</style>
<body class="profile-page">
	<c:import url="/WEB-INF/views/test/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/examples/city.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="margin-top: 50px">
						<div class="col-md-6 col-md-offset-3">

							<form action="<c:url value='mileageList'/>" method="get">
								<div class="list">
									<div class="card">
										<select name="selectOption">
											<option value=""></option>
											<option value="1">사용</option>
											<option value="2">적립</option>
										</select> <input type="text" name="selectValue" /> <input
											type="submit" class="btn btn-info btn-sm" value="검색" />
									</div>
								</div>
							</form>
							<c:forEach items="${returnMileageList}" var="mileageList"
								varStatus="status">
								<c:if test="${status.index eq 0 and sessionLevel eq 3}">
									<div class="list">
										<div class="card">
											<h6>사용 가능금액 ${mileageList.person.personTotalMileage}</h6>
										</div>
									</div>
								</c:if>
								<div class="col-md-12 list">
									<div class="card">

										<div class="container-fluid">

											<div class="row">
												<div class="col-xs-2 col-sm-2" style="top: 33px">
													<!-- 사용했을때 -->
													<c:if test="${mileageList.mileageCate.mileageState == 1}">
														<img
															src="https://raw.githubusercontent.com/enujo/imgRepository/master/yes.png"
															alt="Avatar" class="w3-left w3-circle w3-margin-right"
															style="width: 37px">
													</c:if>
													<!-- 적립했을때 -->
													<c:if test="${mileageList.mileageCate.mileageState == 2}">
														<img
															src="https://raw.githubusercontent.com/enujo/imgRepository/master/no.png"
															alt="Avatar" class="w3-left w3-circle w3-margin-right"
															style="width: 37px">
													</c:if>

												</div>
												<div class="col-xs-6 col-sm-6" style="top: 30px">
													<!-- 내용 -->
													<h4>${mileageList.mileageCate.mileageCateNm}</h4>
												</div>

												<div class="col-xs-4 col-sm-4" style="top: 33px">
													<!-- 날짜 -->
													${mileageList.mileageUseDate}
												</div>
												<!-- Add clearfix for only the required viewport -->
												<div class="clearfix visible-xs"></div>

											</div>
										</div>
										<br>
										<hr>
										<p >
											<c:choose>
												<c:when test="${mileageList.mileageUsePrice == 0 }">
													<!-- 적립시 -->
													<h4 align="right" style="padding-right: 50px;">&#43;
														${mileageList.mileageCate.mileageCatePrice}</h4>
												</c:when>
												<c:when test="${mileageList.mileageUsePrice != 0 }">
													<!-- 사용시 -->
													<h4 align="right" style="padding-right: 50px;">${mileageList.mileageUsePrice}</h4>
													<%-- 사용 가능 금액 ${mileageList.person.personTotalMileage} --%>
												</c:when>
												<c:otherwise>
													에러다 이놈아
											    </c:otherwise>
											</c:choose>
										</p>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>

				</div>
			</div>


		</div>
	</div>
	<c:import url="/WEB-INF/views/test/footer.jsp"></c:import>
</body>
</html>