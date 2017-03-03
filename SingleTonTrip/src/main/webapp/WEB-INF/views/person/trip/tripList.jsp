<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-pane fade" id="trip">
	<div class="w3-container w3-card-2 w3-white w3-round w3-margin"
		style="min-height: 1000px;">
		<br>
		<button type="button"
			class="w3-btn w3-theme-d2 w3-margin-bottom commentListBtn">
			<i class="fa fa-comment"></i>  여행모집글 등록
		</button>
		
		<hr class="w3-clear">
		<div id="tripList">
		<c:forEach items="" var="t">
			<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
				<br>
				<span class="w3-right w3-opacity">등록일</span><br>
				<span class="w3-right w3-opacity">
				<button type="button" class="btn btn-primary" onclick="postModifyModalShow(${p.postNo})">수정</button>
				<button type="button" class="btn btn-primary" onclick="postDeleteModalShow(${p.postNo})">삭제</button>
				</span>
				<h4>여행제목</h4>
				<br>
				<hr class="w3-clear">
				<p>여행테마</p>
				<p>여행지역</p>
				<p>모집 상태</p> 
				<hr class="w3-clear">
				<p>여행내용</p>
				<hr class="w3-clear">
				<button type="button"
					class="w3-btn w3-theme-d2 w3-margin-bottom commentListBtn">
					<i class="fa fa-comment"></i>  상세보기
				</button>
			</div>
		</c:forEach>
	</div>

	</div>

</div>