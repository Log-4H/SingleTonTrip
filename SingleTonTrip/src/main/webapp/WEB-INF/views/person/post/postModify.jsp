<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<form enctype="multipart/form-data" id="modifyForm">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				<input type="text" class="form-control" id="modifyTitle" name="modifyTitle" value="">
				</h4>
			</div>
			<div class="modal-body">
			
			<textarea class="form-control" rows="5" id="modifyContent"
										name="modifyContent" style="resize: none;"></textarea>
			이미지 등록<input type="file" accept="image/gif, image/jpg, image/png, image/jpeg" onchange="fileModalInfo(this)"><br>
			<div id="modalImg">
			
			</div>	
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="modifyPostBtn" value="" class="btn btn-primary" data-dismiss="modal">Save changes</button>
			</div>
		</form>
		</div>
	</div>
</div>
