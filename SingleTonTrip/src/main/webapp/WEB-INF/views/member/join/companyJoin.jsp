<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- 이미지사진미리보기 -->
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
<!-- 우편번호등록 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">SigletonTrip</h1>
<h2 align="center">회원가입</h2>
	<form action="companyJoin" method="post" enctype="multipart/form-data" id="form1">
		<input type="hidden" name="memberLevel" value="${memberLevel }">
		<div align="center">
			프로필사진
			<img id="blah" src="#" alt="your image" style="max-height: 100px; max-width: 100px"/><br>
			<input type='file' name="imgFile" id="imgInp" />
		</div>
		<div align="center">
			<input type="text" name="memberId" placeholder="아이디"/>
		</div>
		<div align="center">
			<input type="password" name="memberPw" placeholder="비밀번호"/>
		</div>
		<div align="center">
			<input type="text" name="memberNm" placeholder="이름"/>
		</div>
		<div align="center">
			<input type="text" name="memberPhone" placeholder="전화번호"/>
		</div>
		<div align="center">
			<input type="text" name="memberEmail" placeholder="이메일"/>
		</div>
		<div align="center">
			<input type="text" name="companyCrd" placeholder="사업자번호"/>
		</div>
		<div align="center">
			분류:
			<c:forEach items="${companyTypeList}" var="t">
				<input type="radio" name="companyTypeCd" value="${t.companyTypeCd }"/><span>${t.companyTypeNm }</span>
			</c:forEach>
		</div>
		<div align="center">
			주소:
			<input type="text" id="sample6_postcode" placeholder="우편번호">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample6_address" placeholder="주소">
			<input type="text" id="sample6_address2" placeholder="상세주소">
		</div>
		<div align="center"><input type="submit" value="회원가입"></div>
	</form>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>