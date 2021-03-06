<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="postAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<form enctype="multipart/form-data" id="postAddForm">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				포스트 등록
				</h4>
			</div>
			<div class="modal-body">
			<input type="text" class="form-control" id="postTitle" name="postTitle" placeholder="Title" required>
			<textarea class="form-control" rows="5" id="postContent" name="postContent" style="resize: none;" placeholder="Content" required></textarea>
			이미지 등록<input type="file" id="postImgFile" name="imgFile" accept="image/gif, image/jpg, image/png, image/jpeg" onchange="fileInfo(this)"><br>
			<div id="postInputImg">
			</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="postAddBtn" class="btn btn-primary" data-dismiss="modal">Add</button>
			</div>
		</form>
		</div>
	</div>
</div>