<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3><strong>포스트 등록</strong></h3>

<div class="card">
	<div align="right">
	<button class="btn" id="postAddBtn">Post</button>
	</div>
<form enctype="multipart/form-data" id="postAddForm">
	<div class="card-header">
		<input type="text" class="form-control" id="postTitle"
			name="postTitle" placeholder="title">
		<textarea class="form-control" rows="3" id="postContent"
			name="postContent" style="resize: none;" placeholder="content"></textarea>
		<input type="file" id="postImgFile" name="imgFile" accept="image/gif, image/jpg, image/png, image/jpeg" onchange="fileInfo(this)"><br>
		<div id="postInputImg">
		</div>
	</div>
</form>
</div>
