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
		<div id="evaluaionList">
		<blockquote>
		<div class="row">
			<div class="col-sm-2">
				<img src="assets/img/logo.png" style="max-width: 150px; max-height: 150px;" class="img-rounded img-responsive">
			</div>
		 <div>
		 <div>
		  <p align="left">
		 <span class="star-input">
			  <span class="input">
			    <input type="radio" name="star-input" id="p1" value="1"><label for="p1">1</label>
			    <input type="radio" name="star-input" id="p2" value="2"><label for="p2">2</label>
			    <input type="radio" name="star-input" id="p3" value="3"><label for="p3">3</label>
			    <input type="radio" name="star-input" id="p4" value="4"><label for="p4">4</label>
			    <input type="radio" name="star-input" id="p5" value="5"><label for="p5">5</label>
			    <input type="radio" name="star-input" id="p6" value="6"><label for="p6">6</label>
			    <input type="radio" name="star-input" id="p7" value="7"><label for="p7">7</label>
			    <input type="radio" name="star-input" id="p8" value="8"><label for="p8">8</label>
			    <input type="radio" name="star-input" id="p9" value="9"><label for="p9">9</label>
			    <input type="radio" name="star-input" id="p10" value="10" checked="checked"><label for="p10">10</label>
			  </span>
			  <output for="star-input"><b>0</b>점</output>
			</span>
			</p>
         <p align="left">
        sex
         </p>
         <small align="left">
         Kanye West, Musician
         </small>
         </div>
         </div>
         </div>
        </blockquote>
		</div>
		</div>
</div>
