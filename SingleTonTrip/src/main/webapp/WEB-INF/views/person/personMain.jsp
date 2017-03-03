<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="./personModule/left.jsp"></c:import>
<c:import url="./post/postModify.jsp"></c:import>
<c:import url="./post/postDelete.jsp"></c:import>
<!-- Middle Column -->
<div class="w3-col m7">
	<div class="w3-row-padding">
		<ul id="personTab" class="nav nav-tabs">
			<li class="nav active"><a href="#post" data-toggle="tab">Post</a></li>
			<li class="nav" id="tripTab"><a href="#trip" data-toggle="tab">Trip</a></li>
		</ul>
		<div id="personTabContent" class="tab-content">
			<c:import url="./post/postList.jsp"></c:import>
			<c:import url="./trip/tripList.jsp"></c:import>
		</div>
	</div>
</div>
<!-- End Middle Column -->
<c:import url="./personModule/right.jsp"></c:import>