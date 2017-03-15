<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="./module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">

	<c:if test="${sessionId ne null }">
		<a href="pageMain?pageId=${sessionId}">내 포스트</a><br>
	</c:if>
	<a href="pageMain?pageId=person1">person1 포스트</a><br>
	<a href="pageMain?pageId=person2">person2 포스트</a><br>
	<a href="pageMain?pageId=person3">person3 포스트</a><br>
	<a href="pageMain?pageId=person4">person4 포스트</a><br>
	
	<a href="pageMain?pageId=company1">company1 포스트</a><br>
	<a href="pageMain?pageId=company2">company2 포스트</a><br>
	

</div>
<c:import url="./module/footer.jsp"></c:import>