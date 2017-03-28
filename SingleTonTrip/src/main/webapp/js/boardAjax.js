//공지사항 등록 modal
function noticeAddModalShow() {
	$("#noticeAddForm")[0].reset();
	$("#noticeAddModal").modal('show');
};
//공지사항 상세보기
$(document).on('click', '.noticeDetail', function() {
	var boardNo = $(this).attr('value');
	var noticeFlag = $("#noticeFlag" + boardNo).attr('value');
	var html = ""
	if (noticeFlag == 'close') {
		$.ajax({
			url : "noticeDetail",
			type : "POST",
			data : {boardNo : boardNo}, 
			dataType : "json",
			success : function(data) {
				var board = data.board;
				html = noticeDetailHtml(board);
				$("#noticeTr"+boardNo).after(html);
				$("#noticeFlag" + boardNo).val("open");
			}
		})
	} else {
		$("#noticeDetail" + boardNo).remove();
		$("#noticeFlag" + boardNo).val("close");
	}
});

function noticeDetailHtml(board){
	var html = "";
	html += "<tr id='noticeDetail"+board.boardNo+"'>";
	if($("#sessionLevel").val() == 1){
		html += "<td colspan='4'>";
	}else{
		html += "<td colspan='3'>";
	}
	html += "<textarea class='form-control' rows='5' style='resize: none'>";
	html += board.boardContent;
	html +="</textarea>";
	html += "</td>";
	html += "</tr>";
	return html;
}