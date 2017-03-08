<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="./trip/tripAdd.jsp"></c:import>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDI3-OfEdnYv_YcK0ZnIG-nGAk3WvnMAk4&&sensor=false"></script>
<div class="tab-pane fade" id="trip">
	<input type="hidden" id="lastTripRow" name="lastTripRow" value="10">
		<br>
		<button type="button" id="tripAddBtn" class="w3-btn w3-theme-d2 w3-margin-bottom" onclick="tripAddModalShow()">
			<i class="fa fa-pencil"></i>  여행모집글 등록
		</button>
		<br>
		<div id="tripList">
		</div>
</div>
