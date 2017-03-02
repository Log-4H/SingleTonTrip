<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/person/personModule/left.jsp"></c:import>

<!-- Middle Column -->
<div class="w3-col m7">

	<div class="w3-row-padding">
		<ul id="myTab" class="nav nav-tabs">
			<li class="nav active"><a href="#post" data-toggle="tab">Post</a></li>
			<li class="nav"><a href="#trip" data-toggle="tab">Trip</a></li>

		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="post">
				<input type="hidden" id="lastPostRow" name="lastPostRow" value="10">
				<div class="w3-row-padding">
					<div class="w3-col m12">
						<div class="w3-card-2 w3-round w3-white">
							<div class="w3-container w3-padding">
								<h6 class="w3-opacity">포스트 등록</h6>
								<form enctype="multipart/form-data" id="postAddForm">
									<input type="text" class="form-control" id="postTitle"
										name="postTitle" placeholder="title">
									<hr class="w3-clear">
									<textarea class="form-control" rows="3" id="postContent"
										name="postContent" style="resize: none;" placeholder="content"></textarea>
									<hr class="w3-clear">
									이미지 등록<input type="file" name="imgFile" accept="image/gif, image/jpg, image/png, image/jpeg" onchange="fileInfo(this)"><br>
									<div id="inputImg">
									</div>
								</form>
								<button class="w3-btn w3-theme" id="postAddBtn">
									<i class="fa fa-pencil"></i>  Post
								</button>
							</div>
						</div>
					</div>
				</div>
				<c:import url="./postModify.jsp"></c:import>
				<div id="postList">
					<c:forEach items="${postList}" var="p">
						<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
							<br>
							<span class="w3-right w3-opacity">${p.postRegDate}</span><br>
							<span class="w3-right w3-opacity">
							<button type="button" class="btn btn-primary" onclick="modifyModalShow(${p.postNo})">수정</button>
							</span>
							<h4>${p.postTitle}</h4>
							<br>
							<hr class="w3-clear">
							<p>${p.postContent}</p>
							<c:if test="${p.postImg ne null }">
								<div class="w3-row-padding" style="margin: 0 -16px">
									<div class="w3-half">
										<img src="<c:url value='/images/${p.postImg}'/>"
											style="width: 100%" class="w3-margin-bottom">
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
							<input type="hidden" id="flag${p.postNo}" value="close">
							<div id="commentList${p.postNo}"></div>
						</div>
					</c:forEach>
				</div>

				<button type="button" class="btn btn-primary" id="addList">더보기</button>
			</div>


			<div class="tab-pane fade" id="trip"></div>
		</div>
	</div>
</div>


<!-- End Middle Column -->

<c:import url="/WEB-INF/views/person/personModule/right.jsp"></c:import>