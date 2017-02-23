<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp"></c:import>

<div class="w3-col m7">
	<c:forEach items="${returnMileageList}" var="mileageList">


		<div class="w3-row-padding">
			<div class="w3-col m12">
				<div class="w3-card-2 w3-round w3-white">
					<div class="w3-container w3-padding">
						<h6 class="w3-opacity"></h6>
						<p contenteditable="true" class="w3-border w3-padding"></p>
					</div>
				</div>
			</div>
		</div>

		<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
			<br> <img src="http://www.w3schools.com/w3images/avatar2.png"
				alt="Avatar" class="w3-left w3-circle w3-margin-right"
				style="width: 60px"> <span class="w3-right w3-opacity">${mileageList.mileageUseDate}</span>
			<h4>John Doe</h4>
			<br>
			<hr class="w3-clear">
			<p>${mileageList.mileageUsePrice}</p>
			<div class="w3-row-padding" style="margin: 0 -16px">
				<div class="w3-half">
					<img src="http://www.w3schools.com/w3images/lights.jpg"
						style="width: 100%" alt="Northern Lights" class="w3-margin-bottom">
				</div>
				<div class="w3-half">
					<img src="http://www.w3schools.com/w3images/nature.jpg"
						style="width: 100%" alt="Nature" class="w3-margin-bottom">
				</div>
			</div>
			<button type="button" class="w3-btn w3-theme-d1 w3-margin-bottom">
				<i class="fa fa-thumbs-up"></i> Like
			</button>
			<button type="button" class="w3-btn w3-theme-d2 w3-margin-bottom">
				<i class="fa fa-comment"></i> Comment
			</button>
		</div>
	</c:forEach>
</div>



<div>
	<c:if test="${startPage>1}">
		<a
			href="<c:url value='personList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<a
			href="<c:url value='personList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
	</c:forEach>
	<c:if test="${endPage ne lastPage}">
		<a
			href="<c:url value='personList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
	</c:if>
</div>
</body>
</html>