<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="reserveDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				예약 상세정보
				</h4>
			</div>
			<div class="modal-body" style="max-height: calc(100vh - 210px); overflow-y: auto;">
				<div class="form-group">
					<label for="tripTitle" class="col-lg-2 control-label">예약자명</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="tripTitle" name="tripTitle" placeholder="input Title">
					</div>
				</div>
				<div class="form-group">
					<label for="tripTag" class="col-lg-2 control-label">Tag</label>
					<div class="col-lg-5">
						<input type="text" class="form-control" id="tripTag" name="tripTag" placeholder="input Tag">
					</div>
				</div>
				<div class="form-group">
					<label for="tripStartDate" class="col-lg-2 control-label">여행기간</label>
					<div class="col-lg-4">
						<input type="date" class="form-control" id="tripStartDate" name="tripStartDate">
					</div>
					<div class="col-lg-1">~</div>
					<div class="col-lg-4">
						<input type="date" class="form-control" id="tripEndDate" name="tripEndDate">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>