<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-pane text-center" id="evaluation">
<div class="row">
		<br>
		<c:if test="${sessionId ne null}">
			<button type="button" class="btn btn-primary">
				<i class="fa fa-pencil"></i>  평가 등록
			</button>
		</c:if>
		<br>
		<div id="evaluaionList">
		<blockquote>
		<div class="row">
			<div class="col-sm-2">
				<img src="assets/img/logo.png" alt="Creative Tim Logo" class="img-rounded img-responsive">
			</div>
		 <div>
		 <div>
         <p>
         I will be the leader of a company that ends up being worth billions of dollars, because I got the answers. I understand culture. I am the nucleus. I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at.
         </p>
         <small>
         Kanye West, Musician
         </small>
         </div>
         </div>
         </div>
        </blockquote>
		</div>
		</div>
</div>
