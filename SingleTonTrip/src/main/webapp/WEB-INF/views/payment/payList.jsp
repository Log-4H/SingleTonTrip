<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
	<div class="w3-row">
		<div class="w3-col m7">
			<form action="<c:url value='payList'/>" method="get">
				<div class="w3-row-padding">
					<div class="w3-col m12">
						<div class="w3-card-2 w3-round w3-white">
							<div class="w3-container w3-padding">
								<!-- <p contenteditable="true" class="w3-border w3-padding"></p> -->
								<select name="selectOption">
									<option value="0">::선택::</option>
									<c:forEach items="${paymentCateList}" var="cate">
										<option value="${cate.paymentCateCd}">${cate.paymentCateNm}//${cate.paymentCateCd}</option>
									</c:forEach>
								</select>
								<c:if test="${sessionLevel == 1 }"> 
									<input type="text" name="selectValue" />
								</c:if>
								<input type="submit" class="w3-btn w3-theme-d1 w3-margin-bottom" value="검색" />
								
							</div>
						</div>
					</div>
				</div>
			</form>
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

					<c:forEach var="payList" items="${payList}">
						<tbody>
							<tr>
								<td>${payList.paymentCate.paymentCateNm}</td>
								<td>${payList.paymentTargetNo}</td>
								<td>${payList.paymentPrice}</td>
								<td>${payList.paymentFinishDate}</td>
								<td>${payList.paymentStateNm}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>

			<!-- 페이징 -->
			<div>
				<c:if test="${startPage>1}">
					<a href="<c:url value='payList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="<c:url value='payList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
				</c:forEach>
				<c:if test="${endPage ne lastPage}">
					<a href="<c:url value='payList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
				</c:if>
			</div>
		</div>
	</div>
</div>

<c:import url="../module/footer.jsp" />
