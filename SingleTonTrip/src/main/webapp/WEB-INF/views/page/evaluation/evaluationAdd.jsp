<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="evaluationAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="evaluationAddTitle">
				평가 등록
				</h4>
			</div>
			<div class="modal-body" id="evaluationCantAddBody" style="display:none;">
				<p>해당 회원과 함께하지 않아 평가를 등록할 수 없습니다.</p>
			</div>
			<div class="modal-body" id="evaluationAddBody" style="display:none;">
			<form class="form-horizontal" id="evaluationAddForm">
			<input type="hidden" value="${pageLevel}" name="pageLevel">
				<div class="form-group">
					<label for="selectEvaluationList" class="col-lg-2 control-label">평가 항목 선택</label>
					<div class="col-lg-10">
						<select class="form-control" id="selectEvaluationList" name="selectEvaluationList">
						<option value="0">평가 항목 선택</option>
						</select> 
					</div>
				</div>
				<div class="form-group">
					<label for="evaluationAddContent" class="col-lg-2 control-label">점수</label>
					<div class="col-lg-10">
						<span class="star-input">
						  <span class="input">
						  	<c:forEach begin="1" end="10" step="1" var="i">
						    <input type="radio" class="evaluationAddRating" name="evaluationAddRating" id="p${i}" value="${i}"><label for="p${i}">${i}</label>
						  </c:forEach>
						  </span>
						</span>
					</div>
				</div>
				<div class="form-group">
					<label for="evaluationAddContent" class="col-lg-2 control-label">Content</label>
					<div class="col-lg-10">
						<textarea class="form-control" rows="5" id="evaluationAddContent" name="evaluationAddContent" style="resize:none;" placeholder="input Content"></textarea>
					</div>
				</div>
				
			</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="evaluationAddBtn" class="btn btn-primary" pageLevel="${pageLevel}" data-dismiss="modal" style="display:none;">Add</button>
			</div>
		</div>
	</div>
</div>