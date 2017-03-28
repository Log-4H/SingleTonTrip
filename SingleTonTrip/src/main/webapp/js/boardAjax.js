//공지사항 등록 modal
function noticeAddModalShow() {
	$("#noticeAddForm")[0].reset();
	$("#noticeAddModal").modal('show');
};

//faq 등록 modal
function faqAddModalShow() {
	$("#faqAddForm")[0].reset();
	$("#faqAddModal").modal('show');
};

//상세보기
$(document).on('click', '.boardDetail', function() {
	var boardNo = $(this).attr('value');
	console.log(boardNo);
	var flag = $("#flag" + boardNo).attr('value');
	var html = ""
	if (flag == 'close') {
		$.ajax({
			url : "boardDetail",
			type : "POST",
			data : {boardNo : boardNo}, 
			dataType : "json",
			success : function(data) {
				var board = data.board;
				console.log(board.boardNo);
				html = boardDetailHtml(board);
				$("#tr"+boardNo).after(html);
				$("#flag" + boardNo).val("open");
			}
		})
	} else {
		$("#detail" + boardNo).remove();
		$("#flag" + boardNo).val("close");
	}
});

function boardDetailHtml(board){
	var html = "";
	html += "<tr id='detail"+board.boardNo+"'>";
	if($("#sessionLevel").val() == 1){
		html += "<td colspan='4'>";
	}else{
		html += "<td colspan='3'>";
	}
	html += "<textarea class='form-control' rows='5' style='resize: none' readonly>";
	html += board.boardContent;
	html +="</textarea>";
	html += "</td>";
	html += "</tr>";
	return html;
}