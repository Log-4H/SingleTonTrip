<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/pageJs/tripAjax.js'/>"></script>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDI3-OfEdnYv_YcK0ZnIG-nGAk3WvnMAk4&&sensor=false"></script>
<div class="tab-pane text-center" id="trip">
<input type="hidden" class="lastTripRow" name="lastTripRow" value="5">
	<div class="row">
	<c:if test="${sessionId eq pageId}">
		<button type="button" class="w3-btn w3-theme-d2 w3-margin-bottom"
			onclick="tripAddModalShow()">
			<i class="fa fa-pencil"></i>  여행모집글 등록
		</button>
	</c:if>
		<div id="tripList"></div>
		<div align="center">
			<button type="button" class="btn btn-primary" id="addTripList">더보기</button>
		</div>
	</div>
</div>