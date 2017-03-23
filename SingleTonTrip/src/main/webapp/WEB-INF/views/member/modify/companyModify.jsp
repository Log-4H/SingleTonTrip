<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="signup-page">
<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
      <div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/city.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							<form class="form" action="companyModify" method="post" enctype="multipart/form-data" id="form1">		
								<div class="header header-primary text-center">
									<h4>회원정보수정(업체)</h4>
									<div class="social-line">
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-facebook-square"></i>
										</a>
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-twitter"></i>
										</a>
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-google-plus"></i>
										</a>
									</div>
								</div>
								<div class="content" align="center">
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">photo</i>
										</span>
										<img id="blah" src="#" alt="your image" style="max-height: 100px; max-width: 100px"/><br>
										<input type='file' name="imgFile" id="imgInp" />
									</div>

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">perm_identity</i>
										</span>
										<input type="text" class="form-control" id="memberId" name="memberId" value="${companyVo.memberId}" readonly="readonly">
									</div>

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">business</i>
										</span>
										<input type="text" class="form-control" name="companyNm" value="${companyVo.companyNm}"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="현재비밀번호"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" class="form-control" id="newPw" name="newPw" placeholder="새 비밀번호"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" class="form-control" id="newPwCheck" name="newPwCheck" placeholder="새 비밀번호확인"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">face</i>
										</span>
										<input type="text" class="form-control" name="memberNm" value="${companyVo.memberNm}"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">call</i>
										</span>
										<input type="text" class="form-control" name="memberPhone" value="${companyVo.memberPhone}"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">mail_outline</i>
										</span>
										<input type="text" class="form-control" name="memberEmail" value="${companyVo.memberEmail}"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">local_printshop</i>
										</span>
										<input type="text" class="form-control" name="companyCrd" value="${companyVo.companyCrd}"/>
									</div>
										
									<div class="input-group">
										<input type="text" class="form-control" id="sample6_postcode" placeholder="우편번호">
										<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
										<input type="text" class="form-control" id="sample6_address" name="companyAddressSelect" placeholder="주소">
										<input type="text" class="form-control" id="sample6_address2" name="companyAddressDetail" placeholder="상세주소">
									</div>
									
									<div class="input-group">
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
									<!-- If you want to add a checkbox to this form, uncomment this code

									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											Subscribe to newsletter
										</label>
									</div> -->
								</div>
								<div class="footer text-center">
									<button type="submit" class="btn btn-simple btn-primary btn-lg">회원정보수정</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
<script>
$(document).ready(function(){
	$("#form1").submit(function(){
		var newPw = $("#newPw").val();
		var newPwCheck =$("#newPwCheck").val();
		if(newPw!=newPwCheck){
			alert("비밀번호 틀렸어요");
			return false;
		}
	});
});
</script>
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
</body>
</html>