<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div  class="w3-row-padding">
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
					이미지 등록<input type="file" id="postImgFile" name="imgFile" accept="image/gif, image/jpg, image/png, image/jpeg" onchange="fileInfo(this)"><br>
					<div id="postInputImg">
					</div>
				</form>
				<button class="w3-btn w3-theme" id="postAddBtn">
					<i class="fa fa-pencil"></i>  Post
				</button>
			</div>
		</div>
	</div>
</div>