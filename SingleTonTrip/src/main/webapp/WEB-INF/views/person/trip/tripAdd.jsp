<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="tripAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">
				<input type="text">
				</h4>
			</div>
			<div class="modal-body">
			trip_theme
			<select id="tripThemeList" name="tripThemeCd">
				<option value="0">테마 선택</option>
			</select><br>
			<div class="row">
				region_cd
				<div class="col-md-4">
				<select id="regionDoList" name="regionCd" onchange="regionSiList(this.value)">
					<option value="0">지역 선택</option>
				</select><br>
				</div>
				<div class="col-md-4" id="regionSiList">
				
				</div>
			</div>
			<hr class='w3-clear'>
			content<br>
			<textarea rows="15"></textarea><br>
			<hr class='w3-clear'>
			최대인원 <input type="text"><br>
			태그<input type="text"><br>
			이미지 등록<br>
			여행기간<input type="date"> - <input type="date"><br>
			모집종료일<input type="date"><br>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="tripAddNextBtn" class="btn btn-primary">Next</button>
			</div>
		</div>
	</div>
</div>