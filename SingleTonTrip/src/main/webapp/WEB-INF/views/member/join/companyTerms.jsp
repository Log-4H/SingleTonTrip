<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="signup-page">
<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
      <div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/base/BackImage.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div>
						<div class="card card-signup">
							
								<div class="header header-primary text-center">
									<h4>업체회원약관</h4>
								</div>
								<div class="content">
									<br><br>
								<div align="center">
									<c:import url='terms.jsp'></c:import><br>
								</div>
								
									<div align="center" class="checkbox">
										<label>
											약관 동의 하시겠습니까?
											<input type="checkbox" id="checkbox" name="optionsCheckboxes">
										</label>
									</div>
								
				               <br>
				               	<div align="center">
				               		<a href="companyJoin?memberLevel=${memberLevel}"><button class="btn btn-primary" id="joinNextBtn" disabled="disabled">다음</button></a>
								</div>
									<!-- If you want to add a checkbox to this form, uncomment this code

									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											Subscribe to newsletter
										</label>
									</div> -->
								</div>
							
							
								
						</div>
					</div>
				</div>
			</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
<script>
$(document).ready(function(){
    $("#checkbox").change(function(){
        if($("#checkbox").is(":checked")){
        	$('#joinNextBtn').attr('disabled',false);
        }else{
        	$('#joinNextBtn').attr('disabled',true);
        }
    });
});
</script>
</body>
</html>