<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="<c:url value='/js/commons/jquery.min.js'/>"></script>
<script>
$(document).ready(function(){
	$("#form").submit(function(){
		var newPw = $("#newPw").val();
		var newPwCheck =$("#newPwCheck").val();
		if(newPw!=newPwCheck){
			alert("비밀번호 틀렸어요");
			return false;
		}
	});
});
</script>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#imgInp").on('change', function(){
            readURL(this);
        });
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }

          reader.readAsDataURL(input.files[0]);
        }
    }


</script>
<body>
<c:import url="/WEB-INF/views/module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
	<form id="form" action="companyModify" method="post" enctype="multipart/form-data" id="form1">
		<div>
			프로필사진<br>
			<img id="blah" src="#" alt="your image" style="max-height: 100px; max-width: 100px"/><br>
			<input type='file' name="imgFile" id="imgInp" />	
    	</div>
		<div>ID</div>
		<div><input type="text" name="memberId" value="${companyVo.memberId}" readonly="readonly"/></div>
		<div>Current PW</div>
		<div><input type="password" name="memberPw"/></div>
		<div>NEW PW</div>
		<div><input type="password" id="newPw" name="newPw"/></div>
		<div>NEW PW CHECK</div>
		<div><input type="password" id="newPwCheck" name="newPwCheck"/></div>
		<div>NAME</div>
		<div><input type="text" name="memberNm" value="${companyVo.memberNm}"/></div>
		<div>PHONE</div>
		<div><input type="text" name="memberPhone" value="${companyVo.memberPhone}"/></div>
		<div>EMAIL</div>
		<div><input type="text" name="memberEmail" value="${companyVo.memberEmail}"/></div>
		<div>분류</div>
		<div>
			<c:forEach items="${companyTypeList}" var="t">
				<c:choose>
					<c:when test="${t.companyTypeCd eq companyVo.companyTypeCd}">
						<input type="radio" name="companyTypeCd" value="${t.companyTypeCd }" checked="checked"/><span>${t.companyTypeNm }</span>
					</c:when>
					<c:otherwise>
						<input type="radio" name="companyTypeCd" value="${t.companyTypeCd }"/><span>${t.companyTypeNm }</span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<div>TYPE</div>
		<div><input type="text" name="companyTypeNm" value="${companyVo.companyTypeNm}"/></div>
		<div>COMPANYCRD</div>
		<div><input type="text" name="companyCrd" value="${companyVo.companyCrd}"/></div>
		<div>ADDRESS</div>
		<div><input type="text" name="companyAddress" value="${companyVo.companyAddress}"/></div>
		<div><input type="submit" value="개인정보수정"/></div>
	</form>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>