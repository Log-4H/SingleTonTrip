<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/pageJs/evaluationAjax.js'/>"></script>
<div class="tab-pane text-center" id="evaluation">
<div class="row">
<input type="hidden" class="lastEvaluationRow" name="lastEvaluationRow" value="5">
		<br>
		<c:if test="${sessionId ne null && sessionId ne pageId}">
			<button type="button" id="evaluationAddModalBtn" class="btn btn-primary" pageLevel="${pageLevel}" >
				<i class="fa fa-pencil"></i>  평가 등록
			</button>
		</c:if>
		<br>
		
		<div id="evaluationList">
			
		</div>
		<div align="center">
			<button type="button" class="btn btn-primary" id="addEvaluationList">더보기</button>
		</div>
	</div>
</div>
