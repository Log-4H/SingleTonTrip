<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/pageJs/roomAjax.js'/>"></script>
<div class="tab-pane fade" id="room">
		<br>
		<c:if test="${sessionId eq pageId}">
			<button type="button" class="w3-btn w3-theme-d2 w3-margin-bottom">
				<i class="fa fa-pencil"></i>  객실 등록
			</button>
		</c:if>
		<br>
		<div id="roomList">
		</div>
		<div align="center">
			<button type="button" class="btn btn-primary" id="addRoomList">더보기</button>
		</div>
</div>
