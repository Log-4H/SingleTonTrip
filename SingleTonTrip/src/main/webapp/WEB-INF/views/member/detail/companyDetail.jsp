<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<div>ID</div>
		<div><input type="text" name="memberId" value="${companyVo.memberId}" readonly="readonly"/></div>
		<div>NAME</div>
		<div><input type="text" name="memberNm" value="${companyVo.memberNm}" readonly="readonly"/></div>
		<div>PHONE</div>
		<div><input type="text" name="memberPhone" value="${companyVo.memberPhone}" readonly="readonly"/></div>
		<div>EMAIL</div>
		<div><input type="text" name="memberEmail" value="${companyVo.memberEmail}" readonly="readonly"/></div>
		<div>REPORTCOUNT</div>
		<div><input type="text" name="memberReportCount" value="${companyVo.memberReportCount}" readonly="readonly"/></div>
		<div>REGDATE</div>
		<div><input type="text" name="memberRegDate" value="${companyVo.memberRegDate}" readonly="readonly"/></div>
		<div>STATE</div>
		<div><input type="text" name="actStateNm" value="${companyVo.actStateNm}" readonly="readonly"/></div>
		<div>TYPE</div>
		<div><input type="text" name="companyTypeNm" value="${companyVo.companyTypeNm}" readonly="readonly"/></div>
		<div>COMPANYCRD</div>
		<div><input type="text" name="companyCrd" value="${companyVo.companyCrd}" readonly="readonly"/></div>
		<div>ADDRESS</div>
		<div><input type="text" name="companyAddress" value="${companyVo.companyAddress}" readonly="readonly"/></div>
		<div><a href="<c:url value='memberDrop?memberId=${companyVo.memberId}'/> ">삭제하기</a></div>
	</form>
</body>
</html>