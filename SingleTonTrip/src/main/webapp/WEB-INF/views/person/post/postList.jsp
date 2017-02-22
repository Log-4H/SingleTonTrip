<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
   
    
    <!-- Middle Column -->
    <div class="w3-col m7">
    <form enctype="multipart/form-data" action="postAdd" method="post">
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card-2 w3-round w3-white">
            <div class="w3-container w3-padding">
              <h6 class="w3-opacity">포스트 등록</h6>
               <input type="text" class="form-control" id="postTitle" name="postTitle" placeholder="title">
               <hr class="w3-clear">
               <textarea class="form-control" rows="3" id="postContent" name="postContent" style="resize:none;" placeholder="content"></textarea>
               <hr class="w3-clear">
               이미지 등록<input type="file" name="imgFile"><br>
              <button type="submit" class="w3-btn w3-theme"><i class="fa fa-pencil"></i>  Post</button> 
            </div>
          </div>
        </div>
      </div>
      </form>
      
      <c:forEach items="${postList}" var="p">
      <div class="w3-container w3-card-2 w3-white w3-round w3-margin"><br>
        <span class="w3-right w3-opacity">몇분전</span>
        <h4>${p.postTitle}</h4><br>
        <hr class="w3-clear">
        <p>${p.postContent}</p>
        <c:if test="${p.postImg ne null }">
          <div class="w3-row-padding" style="margin:0 -16px">
            <div class="w3-half">
              <img src="<c:url value='/images/${p.postImg}'/>" style="width:100%" class="w3-margin-bottom">
            </div>  
        	</div>
        </c:if>
       
        <button type="button" class="w3-btn w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i>  Comment</button> 
      </div>
      </c:forEach>
	<!-- End Middle Column -->
    </div>

  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>