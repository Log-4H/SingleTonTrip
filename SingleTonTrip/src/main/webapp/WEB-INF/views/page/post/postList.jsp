<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/pageJs/postAjax.js'/>"></script>
<c:if test="${sessionId eq pageId}">
<c:import url="./post/postModify.jsp"></c:import>
<c:import url="./post/postDelete.jsp"></c:import>
</c:if>
<div class="tab-pane fade in active" id="post">
	<input type="hidden" class="lastPostRow" name="lastPostRow" value="10">
	<br>
	<c:if test="${sessionId eq pageId}">
	<c:import url="./post/postAdd.jsp"></c:import>
	</c:if>
	<div id="postList">
		<c:forEach items="${postList}" var="p">
			<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
				<br>
				<span class="w3-right w3-opacity">${p.postRegDate}</span><br>
				<c:if test="${sessionId eq pageId}">
				<span class="w3-right w3-opacity">
				<button type="button" class="btn btn-primary" onclick="postModifyModalShow(${p.postNo})">수정</button>
				<button type="button" class="btn btn-primary" onclick="postDeleteModalShow(${p.postNo})">삭제</button>
				</span>
				</c:if>
				<h4>${p.postTitle}</h4>
				<br>
				<hr class="w3-clear">
				<p>${p.postContent}</p>
				<c:if test="${p.postImg ne null }">
					<div class="w3-row-padding" style="margin: 0 -16px">
						<div class="w3-half">
							<img src="<c:url value='/images/${p.postImg}'/>"
								style="width: 100%" class="w3-margin-bottom" onclick='doImgPop("./images/${p.postImg}")'>
						</div>
					</div>
				</c:if>
				<hr class="w3-clear">
				<button type="button"
					class="w3-btn w3-theme-d2 w3-margin-bottom commentListBtn"
					value="${p.postNo}">
					<i class="fa fa-comment"></i>  Comment
				</button>
				<input type="hidden" id="lastCommentRow${p.postNo}" value="10">
				<input type="hidden" id="commentFlag${p.postNo}" value="close">
				<div id="commentList${p.postNo}"></div>
			</div>
		</c:forEach>
	</div>
	<div align="center">
	<button type="button" class="btn btn-primary" id="addList">더보기</button>
	</div>
	<br>
</div>