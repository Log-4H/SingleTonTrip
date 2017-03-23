<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
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
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/examples/city.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 1400px; margin-top: 50px">
						<div class="col-md-6 col-md-offset-3">

							<form action="<c:url value='mileageList'/>" method="get">
								<div class="list">
									<div class="card">
										<div style="margin:10px;" align="right">
											<select name="selectOption" style=" width: 63.6px; height: 27.6px; margin-top: 10px; padding-bottom: 4px;" >
												<option value="">선택</option>
												<option value="1">사용</option>
												<option value="2">적립</option>
											</select> 
											<c:if test="${sessionLevel eq 1}">
												<input type="text" name="selectValue" style=" width: 230x; height: 27.6px; margin-top: 10px; padding-bottom: 4px;" /> 
											</c:if>
											<input type="submit" class="btn btn-info btn-sm" value="검색"/>
											
										</div>
									</div>
								</div>
							</form>
							<c:forEach items="${returnMileageList}" var="mileageList" varStatus="status">
								<c:if test="${status.index eq 0 and sessionLevel eq 3}">
									<div class="list">
										<div class="card">
											
											<h6 style="margin:20px;">사용 가능금액 ${mileageList.person.personTotalMileage}</h6>
										</div>
									</div>
								</c:if>
								<div class="col-md-12 list">
									<div class="card">
										<div class="container-fluid">
											<c:if test="${sessionLevel eq 1 }">
												<div class="col-xs-3  col-sm-3" style="top: 28px;">
													<h6>${mileageList.person.memberId}</h6>
												</div>
											</c:if>
											
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
												<div class="col-xs-6 col-sm-6" style="top: 28px">
													<!-- 내용 -->
													<h4>${mileageList.mileageCate.mileageCateNm}</h4>
												</div>

												<div class="col-xs-3 col-sm-3" style="top: 33px">
													<!-- 날짜 -->
													${mileageList.mileageUseDate}
												</div>
												<!-- Add clearfix for only the required viewport -->
												<div class="clearfix visible-xs"></div>

										</div>
										<br>
										<hr>
										<p>
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
							<!-- 페이징 -->
							<div align="center">
								<ul class="pagination pagination-info">
									<c:if test="${startPage>1}">
										<li>
											<a href="<c:url value='mileageList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
												prev
											</a>
										</li>
									</c:if>
									
									<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
										<li>
											<a href="<c:url value='mileageList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
												${i}
											</a>
										</li>
									</c:forEach>
									<c:if test="${endPage ne lastPage}">
										<li>
											<a href="<c:url value='mileageList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
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
	<c:import url="/WEB-INF/views//module/footer.jsp" />
</body>
</html>