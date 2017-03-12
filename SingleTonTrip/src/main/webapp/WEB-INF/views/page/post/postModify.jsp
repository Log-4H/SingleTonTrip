<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="postModifyModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<form enctype="multipart/form-data" id="postModifyForm">
		<input type="hidden" name="postModifyNo" id="postModifyNo" value="">
		<input type="hidden" class="lastPostRow" name="lastPostRow" value="5">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				<input type="text" class="form-control" id="postModifyTitle" name="postModifyTitle" value="">
				</h4>
			</div>
			<div class="modal-body">
			
			<textarea class="form-control" rows="5" id="postModifyContent" name="postModifyContent" style="resize: none;"></textarea>
			이미지 등록<input type="file" id="modalImgFile" name="imgFile" accept="image/gif, image/jpg, image/png, image/jpeg" onchange="fileModalInfo(this)"><br>
			<div id="postModalImg">
			
			</div>	
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="postModifyBtn" class="btn btn-primary" data-dismiss="modal">Save changes</button>
			</div>
		</form>
		</div>
	</div>
</div>
