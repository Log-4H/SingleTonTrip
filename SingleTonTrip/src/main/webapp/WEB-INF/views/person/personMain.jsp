<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/person/personModule/left.jsp"></c:import>
<c:import url="./personModule/postModify.jsp"></c:import>
<c:import url="./personModule/postDelete.jsp"></c:import>
<!-- Middle Column -->
<div class="w3-col m7">
	<div class="w3-row-padding">
		<ul id="myTab" class="nav nav-tabs">
			<li class="nav active"><a href="#post" data-toggle="tab">Post</a></li>
			<li class="nav"><a href="#trip" data-toggle="tab">Trip</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<c:import url="./post/postList.jsp"></c:import>

			<div class="tab-pane fade" id="trip"></div>
		</div>
	</div>
</div>
<!-- End Middle Column -->
<c:import url="/WEB-INF/views/person/personModule/right.jsp"></c:import>