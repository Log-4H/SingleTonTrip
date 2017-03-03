<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="./trip/tripDetail.jsp"></c:import>
<div class="tab-pane fade" id="trip">
	<input type="hidden" id="lastTripRow" name="lastTripRow" value="10">
	<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
		<br>
		<button type="button"
			class="w3-btn w3-theme-d2 w3-margin-bottom commentListBtn">
			<i class="fa fa-pencil"></i>  여행모집글 등록
		</button>
		<br>
		<div id="tripList">
			
		</div>
	</div>
</div>
