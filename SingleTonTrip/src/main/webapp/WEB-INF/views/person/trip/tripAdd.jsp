<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="tripAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				여행 등록
				</h4>
			</div>
			<div class="modal-body" style="max-height: calc(100vh - 210px); overflow-y: auto;">
				<form class="form-horizontal" id="tripAddForm">
					<div class="form-group">
						<label for="tripTitle" class="col-lg-2 control-label">Title</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="tripTitle" name="tripTitle" placeholder="input Title">
						</div>
					</div>
					<div class="form-group">
						<label for="tripThemeList" class="col-lg-2 control-label">Theme</label>
						<div class="col-lg-10">
							<select class="form-control" id="tripThemeList" name="tripThemeCd">
							<option value="0">테마 선택</option>
							</select> 
						</div>
					</div>
					<div class="form-group">
						<label for="regionDoList" class="col-lg-2 control-label">Region</label>
						<div class="col-lg-10">
							<select class="form-control" id="regionDoList" onChange="regionSiListShow(this.value)">
								<option value="0">지역 선택</option>
							</select> <br> 
							<select size="2" id="regionSiList" name="regionCd" class="form-control">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="tripContent" class="col-lg-2 control-label">Content</label>
						<div class="col-lg-10">
							<textarea class="form-control" rows="5" id="tripContent" name="tripContent" style="resize:none;" placeholder="input Content"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="tripMaxMember" class="col-lg-2 control-label">Member</label>
						<div class="col-lg-2">
							<select class="form-control" id="tripMaxMember" name="tripMaxMember">
							<c:forEach begin="2" end="8" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
							</select> 
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
					<div class="form-group">
						<label for="tripRecruitEndDate" class="col-lg-2 control-label">모집종료일</label>
						<div class="col-lg-4">
							<input type="date" class="form-control" id="tripRecruitEndDate" name="tripRecruitEndDate">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="tripAddBtn" class="btn btn-primary" data-dismiss="modal">Add</button>
			</div>
		</div>
	</div>
</div>