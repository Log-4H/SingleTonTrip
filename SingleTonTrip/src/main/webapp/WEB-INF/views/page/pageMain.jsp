<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<c:import url="/WEB-INF/views/module/left.jsp"></c:import>
<input type="hidden" id="pageId" value="${pageId}">
<input type="hidden" id="pageLevel" value="${pageLevel}">
<input type="hidden" id="sessionId" value="${sessionId}">
<input type="hidden" id="sessionLevel" value="${sessionLevel}">
<!-- Middle Column -->
<div class="w3-col m7">
	<div class="w3-row-padding">
		<ul id="pageTab" class="nav nav-tabs">
			<li class="nav active"><a href="#post" data-toggle="tab">Post</a></li>
			<c:if test="${pageLevel == 2}">
			<li class="nav" id="roomTab"><a href="#room" data-toggle="tab">Room</a></li>
			</c:if>
			<c:if test="${pageLevel == 3}">
			<li class="nav" id="tripTab"><a href="#trip" data-toggle="tab">Trip</a></li>
			</c:if>
			
		</ul>
		<div id="pageTabContent" class="tab-content">
			<c:import url="./post/postList.jsp"></c:import>
			<c:if test="${pageLevel == 2}">
			<c:import url="./room/roomList.jsp"></c:import>
			</c:if>
			<c:if test="${pageLevel == 3}">
			<c:import url="./trip/tripList.jsp"></c:import>
			</c:if>
		</div>
	</div>
</div>
<!-- End Middle Column -->
<c:import url="/WEB-INF/views/module/right.jsp"></c:import>