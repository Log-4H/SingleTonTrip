<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="tripEndModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<input type="hidden" name="tripNo" id="tripEndNo" value="">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				여행 모집 마감
				</h4>
			</div>
			<div class="modal-body">
			모집을 마감하시겠습니까?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="tripEndBtn" class="btn btn-primary" data-dismiss="modal">End</button>
			</div>
		</div>
	</div>
</div>
