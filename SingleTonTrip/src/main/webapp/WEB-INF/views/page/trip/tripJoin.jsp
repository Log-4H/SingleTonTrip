<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="tripJoinModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<input type="hidden" name="tripJoinNo" id="tripJoinNo" value="">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				여행 그룹 참가
				</h4>
			</div>
			<div class="modal-body" id="tripJoinBody">
			그룹장의 승인을 기다려야합니다.
			그룹에 참가하시겠습니까?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="tripJoinBtn" class="btn btn-success" data-dismiss="modal" style="display:none;">Join</button>
			</div>
		</div>
	</div>
</div>
