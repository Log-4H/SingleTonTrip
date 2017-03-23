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
	$.ajax({
		url : "evaluationAdd",
		type : "POST",
		data : $("#evaluationAddForm").serialize(),
		dataType : "json",
		success : function(data) {
			
		}
	})
});