<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="signup-page">
	<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/BackImage.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							<form class="form" action="companyJoin" method="post"
								enctype="multipart/form-data" id="form1"
								onsubmit="return joinCheck()">
								<input type="hidden" name="memberLevel" value="${memberLevel}">
								<div class="header header-primary text-center">
									<h4>업체회원가입</h4>
								</div>
								<div class="content" align="center">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">photo</i>
										</span> <img id="blah" src="https://github.com/Log-4H/imgRepo/blob/master/base/commons/default.jpg?raw=true" alt="your image"
											style="max-height: 100px; max-width: 100px" /><br> <input
											type='file' name="imgFile" id="imgInp" />
									</div>

									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">perm_identity</i>
										</span> <input type="text" class="form-control" id="memberId"
											name="memberId" placeholder="아이디">
									</div>
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">business</i>
										</span> <input type="text" class="form-control" name="companyNm"
											id="companyNm" placeholder="업체명" />
									</div>

									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">lock_outline</i>
										</span> <input type="password" class="form-control" id="memberPw"
											name="memberPw" placeholder="비밀번호" />
									</div>

									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">lock_outline</i>
										</span> <input type="password" class="form-control"
											id="memberPwCheck" name="memberPwCheck" placeholder="비밀번호확인" />
									</div>

									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">face</i>
										</span> <input type="text" class="form-control" name="memberNm"
											id="memberNm" placeholder="이름" />
									</div>

									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">call</i>
										</span> <input type="text" class="form-control" name="memberPhone"
											id="memberPhone" placeholder="전화번호" />
									</div>

									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">mail_outline</i>
										</span> <input type="text" class="form-control" name="memberEmail"
											id="memberEmail" placeholder="이메일" />
									</div>

									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">local_printshop</i>
										</span> <input type="text" class="form-control" name="companyCrd"
											id="companyCrd" placeholder="사업자번호" />
									</div>

									<div class="input-group">
										<input type="text" class="form-control" id="postCode"
											placeholder="우편번호"> <input type="button"
											onclick="execDaumPostcode()" value="우편번호 찾기"><br>
										<input type="text" class="form-control"
											id="companyAddressSelect" name="companyAddressSelect"
											placeholder="주소"> <input type="text"
											class="form-control" id="companyAddressDetail"
											name="companyAddressDetail" placeholder="상세주소">
									</div>

									<div class="input-group">
										<c:forEach items="${companyTypeList}" var="t">
											<input type="radio" class="companyTypeCd"
												name="companyTypeCd" value="${t.companyTypeCd }" />
											${t.companyTypeNm }
										</c:forEach>
									</div>
								</div>
								<div class="footer text-center">
									<button type="submit" class="btn btn-simple btn-primary btn-lg">회원가입</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
			<script type="text/javascript">
				function joinCheck() {
					if ($("#memberId").val() == "") {
						alert("아이디를 입력해 주세요.");
						$("#memberId").focus();
						return false;
					} else if ($("#companyNm").val() == "") {
						alert("업체명을 입력해 주세요.");
						$("#companyNm").focus();
						return false;
					} else if ($("#memberPw").val() == "") {
						alert("비밀번호를 입력해 주세요.");
						$("#memberPw").focus();
						return false;
					} else if ($("#memberPwCheck").val() == "") {
						alert("비밀번호를 입력해 주세요.");
						$("#memberPwCheck").focus();
						return false;
					} else if ($("#memberNm").val() == "") {
						alert("이름을 입력해 주세요.");
						$("#memberNm").focus();
						return false;
					} else if ($("#memberPhone").val() == "") {
						alert("전화번호를 입력해 주세요.");
						$("#memberPhone").focus();
						return false;
					} else if ($("#memberEmail").val() == "") {
						alert("이메일을 입력해 주세요.");
						$("#memberEmail").focus();
						return false;
					} else if ($("#companyCrd").val() == "") {
						alert("사업자번호를 입력해 주세요.");
						$("#companyCrd").focus();
						return false;
					} else if ($("#companyAddressDetail").val() == "") {
						alert("주소를 입력해 주세요.");
						$("#companyAddressDetail").focus();
						return false;
					} else if ($(".companyTypeCd:checked").length < 1) {
						alert("업체유형을 입력해 주세요.");
						$(".companyTypeCd").focus();
						return false;
					} else if ($("#memberPw").val() != $("#memberPwCheck")
							.val()) {
						alert("비밀번호를 확인해주세요.");
						$("#memberPw").focus();
						return false;
					}

					else
						return true;
				}
			</script>
			<!-- 이미지사진미리보기 -->
			<script type="text/javascript">
				$(function() {
					$("#imgInp").on('change', function() {
						readURL(this);
					});
				});

				function readURL(input) {
					if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function(e) {
							$('#blah').attr('src', e.target.result);
						}
						reader.readAsDataURL(input.files[0]);
					}
				}
			</script>
			<!-- 우편번호등록 -->
			<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
			<script src="./js/daumAddress.js"></script>
</body>
</html>