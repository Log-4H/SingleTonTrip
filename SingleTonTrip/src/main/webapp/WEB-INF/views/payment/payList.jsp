<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp" />

<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
	<div class="w3-col m7">
		<div class="w3-row-padding">
			<ul class="nav nav-tabs">
				<li class="nav active">
					<a href="#ad" data-toggle="tab">결제 내역</a>
				</li>
				<c:if test="${sessionLevel == 1}">
					<li class="nav" >
						<form action="<c:url value='payList'/>" method="get">
							<input type="text" name="selectValue" />
							<input type="submit" class="w3-btn w3-theme-d1 w3-margin-bottom" value="검색" />
						</form>
					</li>
				</c:if>
			</ul>
			<div class="tab-content">
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
									<a href="<c:url value='payList?currentPage=${startPage-pageSize}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">prev</button>
									</a>
								</c:if>
								<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
									<a href="<c:url value='payList?currentPage=${i}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">${i}</button>
									</a>
								</c:forEach>
								<c:if test="${endPage ne lastPage}">
									<a href="<c:url value='payList?currentPage=${startPage+pageSize}&selectValue=${selectValue}'/>">
										<button type="button" class="btn btn-primary">next</button>
									</a>
								</c:if>
							</div>
						</div>
						<br>
					</div>
			</div>
		</div>
	</div>
</div>

<c:import url="../module/footer.jsp" />