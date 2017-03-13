<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">

	<div class="w3-col m7">
		<div class="w3-row-padding">
		<!--
			<form action="<c:url value='payList'/>" method="get">
					<div class="w3-col m12">
						<div class="w3-card-2 w3-round w3-white">
							<div class="w3-container w3-padding">
								 <p contenteditable="true" class="w3-border w3-padding"></p>
								<select name="selectOption">
									<option value="0">::선택::</option>
									<c:forEach items="${paymentCateList}" var="cate">
										<option value="${cate.paymentCateCd}">${cate.paymentCateNm}//${cate.paymentCateCd}</option>
									</c:forEach>
								</select>
								
								<c:if test="${sessionLevel == 1 }">
									<input type="text" name="selectValue" />
								
								<input type="submit" class="w3-btn w3-theme-d1 w3-margin-bottom" value="검색" />
								</c:if>
		
							</div>
						</div>
					</div>
			</form>
			 -->	
			<ul id="pageTab" class="nav nav-tabs">
				<c:if test="${sessionLevel == 1 || sessionLevel == 2}">
					<li class="nav active">
						<a href="#ad" data-toggle="tab">광고 결제 내역</a>
					</li>
				</c:if>
				<c:if test="${sessionLevel == 1}">
					<li class="nav" id="roomTab">
						<a href="#reserve" data-toggle="tab">결제 내역</a>
					</li>
				</c:if>
				<c:if test="${sessionLevel == 3}">
					<li class="nav active">
						<a href="#reserve" data-toggle="tab">결제 내역</a>
					</li>
				</c:if>
			</ul>
			<div id="pageTabContent" class="tab-content">
				<c:if test="${sessionLevel ==1 || sessionLevel == 2}">
					<div class="tab-pane fade in active" id="ad">
						<br>
						<div>
							<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
								<table class="table">
									<thead>
										<tr>
											<th>구분</th>
											<th>결제 내용</th>
											<th>가격</th>
											<th>날짜</th>
											<th>상태</th>
										</tr>
									</thead>
						
									<c:forEach var="payList" items="${adPayList}">
										<tbody>
											<tr>
												<td>${payList.paymentCate.paymentCateNm}</td>
												<td>${payList.ad.adContent}</td>
												<td>${payList.paymentPrice}</td>
												<td>${payList.paymentFinishDate}</td>
												<td>${payList.paymentStateNm}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</div>
						<div align="center">
							<div>
								<c:if test="${startPage>1}">
									<a href="<c:url value='payList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">prev</button>
									</a>
								</c:if>
								<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
									<a href="<c:url value='payList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">${i}</button>
									</a>
								</c:forEach>
								<c:if test="${endPage ne lastPage}">
									<a href="<c:url value='payList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">next</button>
									</a>
								</c:if>
							</div>
						</div>
						<br>
					</div>
				</c:if>
				<c:if test="${sessionLevel ==1 || sessionLevel == 3}">
					<c:choose>
						<c:when test="${sessionLevel == 3}">
							<div class="tab-pane fade in active" id="reserve">
						</c:when>
						<c:when test="${sessionLevel == 1}">
							<div class="tab-pane fade" id="reserve">
						</c:when>
					</c:choose>
						<br>
						<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
								<table class="table">
									<thead>
										<tr>
											<th>구분</th>
											<th>결제 내용</th>
											<th>마일리지 사용</th>
											<th>가격</th>
											<th>날짜</th>
											<th>상태</th>
										</tr>
									</thead>
						
									<c:forEach var="payList" items="${reservePayList}">
										<tbody>
											<tr>
												<td>${payList.paymentCate.paymentCateNm}</td>
												<td>${payList.companyNm}(${payList.roomNm})</td>
												<td>${payList.paymentUseMileage}</td>
												<td>${payList.paymentPrice}</td>
												<td>${payList.paymentFinishDate}</td>
												<td>${payList.paymentStateNm}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
						</div>
						<div align="center">
							<div>
								<c:if test="${startPage>1}">
									<a href="<c:url value='payList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">prev</button>
									</a>
								</c:if>
								<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
									<a href="<c:url value='payList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">${i}</button>
									</a>
								</c:forEach>
								<c:if test="${endPage ne lastPage}">
									<a href="<c:url value='payList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">next</button>
									</a>
								</c:if>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<c:import url="../module/footer.jsp" />