<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="./module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
	<a href="personList">개인회원리스트</a><br>
	<a href="companyList">업체회원리스트</a><br>
	<a href="adApply">광고 신청</a><br>
	<a href="adApplyList">광고 신청 리스트</a><br>
	<a href="payAdd">결제 폼</a><br>
	<a href="adList">광고 리스트</a><br>
	<a href="payCancelList">환불 리스트</a><br>
	
	<c:if test="${sessionId ne null }">
		<a href="person/personMain">포스트</a><br>
	</c:if>
</div>
<c:import url="./module/footer.jsp"></c:import>