<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="planModifyModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				일정 수정
				</h4>
			</div>
			<div class="modal-body" style="max-height: calc(100vh - 210px); overflow-y: auto;">
				<form class="form-horizontal" id="planModifyForm">
					<div class="form-group">
						<label for="planModifySite" class="col-lg-2 control-label">planSite</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="planModifySite" name="planSite" placeholder="input planSite">
						</div>
					</div>
					<div class="form-group">
						<label for="planModifyContent" class="col-lg-2 control-label">planContent</label>
						<div class="col-lg-10">
							<textarea class="form-control" rows="5" id="planModifyContent" name="planContent" style="resize:none;" placeholder="input planContent"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="planModifyStartTime" class="col-lg-2 control-label">planStartTime</label>
						<div class="col-lg-7">
							<input type="datetime-local" class="form-control" id="planModifyStartTime" name="planStartTime">
						</div>
					</div>
					<div class="form-group">
						<label for="planModifyEndTime" class="col-lg-2 control-label">planEndTime</label>
						<div class="col-lg-7">
							<input type="datetime-local" class="form-control" id="planModifyEndTime" name="planEndTime">
						</div>
					</div>
					<div class="form-group">
						<label for="planModifyPrice" class="col-lg-2 control-label">planPrice</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="planModifyPrice" name="planPrice" placeholder="input planPrice">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="planModifyBtn" class="btn btn-primary" data-dismiss="modal">Add</button>
			</div>
		</div>
	</div>
</div>