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
		<div><input type="text" name="memberId" value="${personVo.memberId}" readonly="readonly"/></div>
		<div>NAME</div>
		<div><input type="text" name="memberNm" value="${personVo.memberNm}" readonly="readonly"/></div>
		<div>PHONE</div>
		<div><input type="text" name="memberPhone" value="${personVo.memberPhone}" readonly="readonly"/></div>
		<div>EMAIL</div>
		<div><input type="text" name="memberEmail" value="${personVo.memberEmail}" readonly="readonly"/></div>
		<div>REPORTCOUNT</div>
		<div><input type="text" name="memberReportCount" value="${personVo.memberReportCount}" readonly="readonly"/></div>
		<div>REGDATE</div>
		<div><input type="text" name="memberRegDate" value="${personVo.memberRegDate}" readonly="readonly"/></div>
		<div>STATE</div>
		<div><input type="text" name="actStateNm" value="${personVo.actStateNm}" readonly="readonly"/></div>
		<div>BIRTH</div>
		<div><input type="text" name="personBirth" value="${personVo.personBirth}" readonly="readonly"/></div>
		<div>GENDER</div>
		<div><input type="text" name="personGender" value="${personVo.personGender}" readonly="readonly"/></div>
		<div>MILEGE</div>
		<div><input type="text" name="personTotalMileage" value="${personVo.personTotalMileage}" readonly="readonly"/></div>
		<div>TRIPSTATE</div>
		<div><input type="text" name="tripStateNm" value="${personVo.tripStateNm}" readonly="readonly"/></div>
		<div><a href="<c:url value='memberDrop?memberId=${personVo.memberId}'/> ">삭제하기</a></div>
	</form>
</body>
</html>