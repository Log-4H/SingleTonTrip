<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="faqAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<form id="noticeAddForm" action="faqAdd" method="POST">
		<input type="hidden" name="boardCateCd" value='4'>
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				<input type="text" class="form-control" name="boardTitle" placeholder="Title" required>
				</h4>
			</div>
			<div class="modal-body">
			<textarea class="form-control" rows="5" name="boardContent" style="resize: none;" placeholder="Content" required></textarea>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" id="faqAddBtn" class="btn btn-primary">Add</button>
			</div>
		</form>
		</div>
	</div>
</div>