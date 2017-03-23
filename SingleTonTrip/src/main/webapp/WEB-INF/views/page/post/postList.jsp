<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/pageJs/postAjax.js'/>"></script>
<div class="tab-pane active" id="post">
	<div class="row">
		<input type="hidden" class="lastPostRow" name="lastPostRow" value="10">
		<c:if test="${sessionId eq pageId}">
		<button type="button" class="btn btn-primary"
			onclick="postAddModalShow()">
			<i class="fa fa-pencil"></i>  포스트 등록
		</button>
		</c:if>
		<div id="postList">
			<c:forEach items="${postList}" var="p">
			<div class="card">
			  <div align="right">
						<c:if test="${sessionId eq pageId}">
					<button type="button" class="btn btn-info"
						onclick="postModifyModalShow(${p.postNo})"><i class="fa fa-edit"></i></button>
					<button type="button" class="btn btn-danger"
						onclick="postDeleteModalShow(${p.postNo})"><i class="fa fa-times"></i></button>
				</c:if>
				</div>
				<div class="card-header">
			    <h3><strong>${p.postTitle}</strong></h3>
				</div>
			  <div class="card-block">
			  <c:if test="${p.postImg ne null }">
					<img src="<c:url value='/images/${p.postImg}'/>" style="width: 50%; height:50%" onclick='doImgPop("./images/${p.postImg}")'>
					</c:if>
					<br>
			    <p class="card-text">${p.postContent}</p>
			    <div class="card-block">
			    <button type="button"
						class="commentListBtn"
						value="${p.postNo}">
						<i class="fa fa-comment"></i>  Comment
					</button>
					<input type="hidden" id="lastCommentRow${p.postNo}" value="10">
					<input type="hidden" id="commentFlag${p.postNo}" value="close">
					<div id="commentList${p.postNo}"></div>
					</div>
			  </div>
			  <div class="card-footer text-muted">
			    <h6>${p.postRegDate}</h6>
			  </div>
			</div>
			<br><br>
			</c:forEach>
	
		</div>
		<div align="center">
			<button type="button" class="btn btn-primary" id="addList">더보기</button>
		</div>
	</div>
</div>