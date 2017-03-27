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
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							
								<div class="header header-primary text-center">
									<h4>회원가입</h4>
								</div>
								<div class="content">

						<br><br><br><br>
						
						
			                    <div class="nav-align-center">
									<ul class="nav nav-pills" >
										<li class="active">
											<a href="<c:url value='joinTerms?memberLevel=3'/>" >
												<i class="material-icons">assignment_ind</i>
												개인회원
											</a>
										</li>
										<li class="active">
				                            <a href="<c:url value='joinTerms?memberLevel=2'/>" >
												<i class="material-icons">business</i>
												업체회원
				                            </a>
				                        </li>
				                    </ul>
				                    <br><br><br><br><br><br><br><br>
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
</body>
</html>