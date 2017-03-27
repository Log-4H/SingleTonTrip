<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-pane text-center" id="trip">
	<div class="row">
	<input type="hidden" class="lastTripRow" name="lastTripRow" value="5">
	<c:if test="${sessionId eq pageId}">
		<button type="button" class="btn btn-primary"
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