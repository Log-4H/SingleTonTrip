//평가등록 modal
$(document).on('click', '#evaluationAddModalBtn', function() {
	var pageLevel = $(this).attr('pageLevel');
	var html = "";
	$("#evaluationAddBtn").hide();
	$("#evaluationCantAddBody").hide();
	$("#evaluationAddBody").hide();
	$("#evaluationAddForm")[0].reset();
	$.ajax({
		url : "evaluationCheck",
		type : "POST",
		data : {
			pageLevel : pageLevel
		},
		dataType : "json",
		success : function(data) {
			var checkList = data.checkList;
			console.log(checkList);
			if(checkList.length < 1){
				$("#evaluationCantAddBody").show();
			}else{
				$("#evaluationAddBody").show();
				$("#evaluationAddBtn").show();
				if(pageLevel == 2){
					$.each(checkList,function(key, item) {
						if(item.evaluationCheck < 1){
							$("#selectEvaluationList").append("<option value='"+item.reserveNo+"'>"+item.roomNm +" / " + item.reserveCheckinDate+"</option>");
						}
					})
				}else if(pageLevel == 3){
					$.each(checkList,function(key, item) {
						if(item.evaluationCheck < 1){
							$("#selectEvaluationList").append("<option value='"+item.tripNo+"'>"+item.tripTitle +" / " + item.tripStartDate+"</option>");
						}
					})
				}
			}
			$("#evaluationAddModal").modal('show');
		}
	})
});
//평가등록
$(document).on('click', '#evaluationAddBtn', function() {
	var pageLevel = $(this).attr('pageLevel');
	var html =""
	$.ajax({
		url : "evaluationAdd",
		type : "POST",
		data : $("#evaluationAddForm").serialize(),
		dataType : "json",
		success : function(data) {
			console.log(data);
			var evaluationList = data.evaluationList;
			html = evaluationListHtml(evaluationList, pageLevel);
			$("#evaluationList").html(html);
		}
	})
});
//평가탭 클릭시 평가리스트 호출
$(document).on('click', '#evaluationTab', function() {
	var lastEvaluationRow = $('.lastEvaluationRow').attr('value');
	lastEvaluationRow = Number(lastEvaluationRow);
	var pageLevel = $("#pageLevel").val();
	$.ajax({
		url : "evaluationList",
		type : "POST",
		data : {
			pageLevel:pageLevel, lastEvaluationRow : lastEvaluationRow
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			var evaluationList = data.evaluationList;
			html = evaluationListHtml(evaluationList, pageLevel);
			console.log(html);
			$("#evaluationList").html(html);
		}
	})
});
//평가리스트 html
function evaluationListHtml(evaluationList, pageLevel){
	var html="";
	$.each(evaluationList,function(key, item) {
		html += "<blockquote>";
		html += "<div class='row'>";
		html += "<div class='col-sm-2'>";
		html += "<a href='pageMain?pageId="+item.memberId+"'>"
		html += "<img src='";
		if(item.memberImg != null){
			html += "./images/"+ item.memberImg+"'";
		}else if(item.personGender == 'M'){
			html += "./images/Male.png'";
		}else if(item.personGender == 'F'){
			html += "./images/Female.png'";
		}
		html += " style='max-width: 150px; max-height: 150px;' class='img-rounded img-responsive'>";
		html += "</a>"
		html += "</div>";
		html += "<div>";
		html += "<div>";
		html += "<p align='right'>";
		if(pageLevel == 2){
			html += item.companyEvaluationRegDate;
		}else if(pageLevel ==3){
			html += item.personEvaluationRegDate;
		}
		html += "</p>";
		html += "<p align='left'>";
		html += "<span class='star-input'>";
		html += "<span class='input'>";
		if(pageLevel == 2){
			html += "<input type='radio' name='star-input' id='p"+item.companyEvaluationRating+"' value='"+item.companyEvaluationRating+"' checked='checked' disabled><label for='p"+item.companyEvaluationRating+"'>"+item.companyEvaluationRating+"</label>";
			html += "</span>";
			html += "<b>"+item.companyEvaluationRating+"</b>점";
		}else if(pageLevel ==3){
			html += "<input type='radio' name='star-input' id='p"+item.personEvaluationRating+"' value='"+item.personEvaluationRating+"' checked='checked' disabled><label for='p"+item.personEvaluationRating+"'>"+item.personEvaluationRating+"</label>";
			html += "</span> ";
			html += " <b>"+item.personEvaluationRating+"</b>점";
		}
		html += "</span>";
		html += "</p>";
		html += "<p align='left'>";
		if(pageLevel == 2){
			html += item.companyEvaluationContent;
		}else if(pageLevel ==3){
			html += item.personEvaluationContent;
		}
		html += "</p>";
		html += "<small align='left'>";
		html += item.memberId;
		html += "</small>";
		html += "</div>";
		html += "</div>";
		html += "</div>";
		html += "</blockquote>";
	});
	return html;
}