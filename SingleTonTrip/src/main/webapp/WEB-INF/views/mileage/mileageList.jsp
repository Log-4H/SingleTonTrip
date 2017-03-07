<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp" />
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 130px">
	<div class="w3-col m7">
		<form action="<c:url value='mileageList'/>" method="get">
			<div class="w3-row-padding">
				<div class="w3-col m12">
					<div class="w3-card-2 w3-round w3-white">
						<div class="w3-container w3-padding">


							<!-- <p contenteditable="true" class="w3-border w3-padding"></p> -->
							<select name="selectOption">
								<option value=""></option>
								<option value="1">사용</option>
								<option value="2">적립</option>
							</select> 
							<input type="text" name="selectValue" /> <input type="submit"
								class="w3-btn w3-theme-d1 w3-margin-bottom" value="검색" />
						</div>
					</div>
				</div>
			</div>
		</form>
		<c:forEach items="${returnMileageList}" var="mileageList"
			varStatus="status">
			<c:if test="${status.index eq 0 and sessionLevel eq 3}">
				<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
					<h6 class="w3-opacity">사용 가능금액
						${mileageList.person.personTotalMileage}</h6>
				</div>
			</c:if>

			<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
				<br>
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
				<!-- 날짜 -->
				<span class="w3-right w3-opacity">
					${mileageList.mileageUseDate} </span>

				<!-- 내용 -->
				<h4>${mileageList.mileageCate.mileageCateNm}</h4>
				<hr class="w3-clear">
				<p>
					<c:choose>
						<c:when test="${mileageList.mileageUsePrice == 0 }">
							<!-- 적립시 -->
							<h4 align="right">&#43;
								${mileageList.mileageCate.mileageCatePrice}</h4>
						</c:when>
						<c:when test="${mileageList.mileageUsePrice != 0 }">
							<!-- 사용시 -->
							<h4 align="right">${mileageList.mileageUsePrice}</h4>
							<%-- 사용 가능 금액 ${mileageList.person.personTotalMileage} --%>
						</c:when>
						<c:otherwise>
						에러다 이놈아
				    </c:otherwise>
					</c:choose>
				</p>
			</div>
		</c:forEach>

		<!-- 페이징 -->
		<div>
			<c:if test="${startPage>1}">
				<a
					href="<c:url value='mileageList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<a
					href="<c:url value='mileageList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
			</c:forEach>
			<c:if test="${endPage ne lastPage}">
				<a
					href="<c:url value='mileageList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
			</c:if>
		</div>
	</div>
</div>
<c:import url="../module/footer.jsp"></c:import>
