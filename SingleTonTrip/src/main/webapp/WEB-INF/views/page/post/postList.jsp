<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/pageJs/postAjax.js'/>"></script>
<div class="tab-pane active" id="post">
	<div class="row">									
	<input type="hidden" class="lastPostRow" name="lastPostRow" value="10">
	<br>
	<c:if test="${sessionId eq pageId}">
	<c:import url="./post/postAdd.jsp"></c:import>
	</c:if>
	<div id="postList">
		<div class="col-md-6">
			<c:forEach items="${postList}" var="p">
				<div class="card card-nav-tabs">
					<div class="header header-success">
					<div class="col-md-6">
						<h4>${p.postTitle}</h4>
						<h6>${p.postRegDate}</h6>
						</div>
						<div class="col-md-6">
						<c:if test="${sessionId eq pageId}">
						<button type="button" class="btn btn-primary" onclick="postModifyModalShow(${p.postNo})">수정</button>
						<button type="button" class="btn btn-primary" onclick="postDeleteModalShow(${p.postNo})">삭제</button>
						</c:if>
						</div>
					</div>
					<div class="content">
						<div class="tab-content text-center">
							<div class="tab-pane active" id="profile">
								<p> I will be the leader of a company that ends up being worth billions of dollars, because I got the answers. I understand culture. I am the nucleus. I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at. I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at. </p>
							</div>
							<div class="tab-pane" id="messages">
								<p> I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at. I will be the leader of a company that ends up being worth billions of dollars, because I got the answers. I understand culture. I am the nucleus. I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at.</p>
							</div>
							<div class="tab-pane" id="settings">
								<p>I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at. So when you get something that has the name Kanye West on it, it’s supposed to be pushing the furthest possibilities. I will be the leader of a company that ends up being worth billions of dollars, because I got the answers. I understand culture. I am the nucleus.</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
				
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
		
	</div>
	<div align="center">
	<button type="button" class="btn btn-primary" id="addList">더보기</button>
	</div>
	<br>
</div>
</div>