<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="tripDetailModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="tripDetailTitle"></h4>
			</div>
			<div class="modal-body">
			테마<p id="tripDetailThemeNm"></p>
			지역<p id="tripDetailRegionDoSi"></p>
			내용<p id="tripDetailContent"></p>
			참여인원(현재인원/총인원)<p id="tripDetailMemberCount"></p>
			여행기간<p id="tripDetailDate"></p>
			예상경비(1인경비/총경비)<p id="tripDetailPrice"></p>
			모집기간<p id="tripDetailRecruitDate"></p>
			태그<p id="tripDetailTag"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="tripJoinBtn" class="btn btn-primary">Join</button>
			</div>
		</div>
	</div>
</div>