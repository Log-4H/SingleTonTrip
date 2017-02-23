<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp"></c:import>

<div class="w3-col m7">
	<form action="<c:url value='mileageList'/>" method="get">
		<div class="w3-row-padding">
			<div class="w3-col m12">
				<div class="w3-card-2 w3-round w3-white">
					<div class="w3-container w3-padding">
						<h6 class="w3-opacity"></h6>
						<!-- <p contenteditable="true" class="w3-border w3-padding"></p> -->
						<select name="selectOption">
							<option value=""></option>
							<option value="2">적립</option>
							<option value="1">사용</option>
						</select> <input type="text" name="selectValue" /> <input type="submit"
							class="w3-btn w3-theme-d1 w3-margin-bottom" value="검색" />



					</div>
				</div>
			</div>
		</div>
	</form>

	<c:forEach items="${returnMileageList}" var="mileageList">
		<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
			<br>
			 
			<img src="http://www.w3schools.com/w3images/avatar2.png"
				alt="Avatar" class="w3-left w3-circle w3-margin-right"
				style="width: 37px">
			
			<span class="w3-right w3-opacity">${mileageList.mileageUseDate}</span>
			<h4>마일리지 카테고리 가져오기</h4>
			<hr class="w3-clear">
			<p><h4>${mileageList.mileageUsePrice}</h4></p>
		</div>
	</c:forEach>

	<div>
		<c:if test="${startPage>1}">
			<a href="<c:url value='mileageList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<a href="<c:url value='mileageList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
		</c:forEach>
		<c:if test="${endPage ne lastPage}">
			<a href="<c:url value='mileageList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
		</c:if>
	</div>




</div>
</body>
</html>