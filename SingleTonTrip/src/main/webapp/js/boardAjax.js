//공지사항 등록 modal
function noticeAddModalShow() {
	$("#noticeAddForm")[0].reset();
	$("#noticeAddModal").modal('show');
};

// faq 등록 modal
function faqAddModalShow() {
	$("#faqAddForm")[0].reset();
	$("#faqAddModal").modal('show');
};

//광고문의 등록 modal
function qnaAdAddModalShow() {
	$("#qnaAdAddForm")[0].reset();
	$("#qnaAdAddModal").modal('show');
};
//1:1문의 등록 modal
function qnaOneAddModalShow() {
	$("#qnaOneAddForm")[0].reset();
	$("#qnaOneAddModal").modal('show');
};


// 상세보기
$(document).on('click', '.boardDetail', function() {
	var boardNo = $(this).attr('value');
	var flag = $("#flag" + boardNo).attr('value');
	var html = ""
	if (flag == 'close') {
		$.ajax({
			url : "boardDetail",
			type : "POST",
			data : {
				boardNo : boardNo
			},
			dataType : "json",
			success : function(data) {
				var board = data.board;
				console.log(board.boardNo);
				html = boardDetailHtml(board);
				$("#tr" + boardNo).after(html);
				$("#flag" + boardNo).val("open");
			}
		})
	} else {
		$("#detail" + boardNo).remove();
		$("#flag" + boardNo).val("close");
	}
});
// qna 상세보기
$(document).on('click', '.qnaDetail', function() {
	var boardNo = $(this).attr('value');
	var flag = $("#flag" + boardNo).attr('value');
	var html = ""
	if (flag == 'close') {
		$.ajax({
			url : "qnaDetail",
			type : "POST",
			data : {
				boardNo : boardNo
			},
			dataType : "json",
			success : function(data) {
				console.log(data);
				var board = data.board;
				html = boardDetailHtml(board);
				html += answerHtml(boardNo, board.boardCommentList);
				$("#tr" + boardNo).after(html);
				$("#flag" + boardNo).val("open");
			}
		})
	} else {
		$("#detail" + boardNo).remove();
		$("#comment" + boardNo).remove();
		$("#flag" + boardNo).val("close");
	}
});

function boardDetailHtml(board) {
	var html = "";
	html += "<tr id='detail" + board.boardNo + "'>";
	if ($("#sessionLevel").val() == 1) {
		html += "<td colspan='5'>";
	} else {
		html += "<td colspan='4'>";
	}
	html += "<textarea class='form-control' rows='5' style='resize: none' readonly>";
	html += board.boardContent;
	html += "</textarea>";
	html += "</td>";
	html += "</tr>";
	return html;
}
function answerHtml(boardNo, boardCommentList) {
	var html = "";
	if (boardCommentList.length > 0) {
		$.each(boardCommentList, function(key, item) {
			html += "<tr id='comment" + boardNo + "'>";
			if ($("#sessionLevel").val() == 1) {
				html += "<td colspan='5'>";
			} else {
				html += "<td colspan='4'>";
			}
			html += "<textarea class='form-control' rows='5' style='resize: none' readonly>";
			html += item.boardCommentContent;
			html += "</textarea>";
			html += "</td>";
			html += "</tr>";
		})
	} else {
		html += "<tr id='comment" + boardNo + "'>";
		if ($("#sessionLevel").val() == 1) {
			html += "<td colspan='5'>";
		} else {
			html += "<td colspan='4'>";
		}
		html += "<textarea class='form-control' rows='5' style='resize: none' readonly>";
		html += "안녕하세요. 관리자입니다.\n";
		html += "답변등록 대기중입니다.";
		html += "</textarea>";
		html += "</td>";
		html += "</tr>";
	}
	return html;
}