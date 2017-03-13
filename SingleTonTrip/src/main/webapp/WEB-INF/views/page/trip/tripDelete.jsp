<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="tripDeleteModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<input type="hidden" name="tripNo" id="tripDeleteNo" value="">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				여행 삭제
				</h4>
			</div>
			<div class="modal-body">
			여행을 삭제하시겠습니까?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="tripDeleteBtn" class="btn btn-primary" data-dismiss="modal">Delete</button>
			</div>
		</div>
	</div>
</div>