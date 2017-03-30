// 프로필 요청
$(document).ready(function() {
	console.log($("#sessionId").val());
	if ($("#pageLevel").val() == 2) {
		companyDetail();
	} else if ($("#pageLevel").val() == 3) {
		personDetail();
	}
	;

	// 개인회원 프로필
	function personDetail() {
		$.ajax({
			url : "personDetail",
			type : "POST",
			dataType : "json",
			success : function(data) {
				console.log(data);
				var html = "";
				var person = data.person;
				var profileImg = "";
				if (person.memberImg != null) {
					profileImg = "./images/" + person.memberImg;
				} else if (person.personGender == "F") {
					profileImg = "./assets/img/base/Female.png";
				} else {
					profileImg = "./assets/img/base/Male.png";
				}
				$("#profileImg").attr("src", profileImg);
				$("#profileImg").attr("src", profileImg);
				html += "<h3 class='title'>"+ person.memberNm + "</h3>";
				html += rate(person.memberEvaluationRating * 10)+" <strong>"+person.memberEvaluationRating+"</strong>";
				html += "<h6>" + person.personBirth + "</h6>";
				html += "<h6>" + person.personGender + "</h6>";
				html += "<h6>" + person.memberEmail + "</h6>";
				html += "<h6>" + person.tripStateNm + "</h6>";
				

				$("#profileContent").html(html);
			}
		})
	}
	;
	// 업체회원프로필
	function companyDetail() {
		$.ajax({
			url : "companyDetail",
			type : "POST",
			dataType : "json",
			success : function(data) {
				var html = "";
				var company = data.company;
				var profileImg = "";
				if (company.memberImg != null) {
					profileImg = "./images/" + company.memberImg;
				} else {
					profileImg = "./assets/img/base/Company.jpg";
				}
				$("#profileImg").attr("src", profileImg);
				$("#profileImg").attr("src", profileImg);
				html += "<h3 class='title'>" + company.companyNm +"</h3>";
				html += rate(company.memberEvaluationRating * 10) +" <strong>"+company.memberEvaluationRating+"</strong>";
				html += "<h6>" + company.memberNm + "</h6>";
				html += "<h6>" + company.companyTypeNm + "</h6>";
				html += "<h6>" + company.memberPhone + "</h6>";
				html += "<h6>" + company.memberEmail + "</h6>";
				$("#profileContent").html(html);
				$("#companyMap").html(
						"<div class='googleMap' id='google_map"+company.companyNo+"' style='max-width:1000px; height:500px;'></div>");
				var planSite = new Array;
				var planContent = new Array;
				planSite.push(company.companyAddress);
				planContent.push(company.companyNm);
				googleMap(company.companyNo, planSite, planContent);
			}
		})
	};
});
//페이지 친구 체크
$(document).ready(
		function() {
			var sessionId = $('#sessionId').val();
			$.ajax({
				url : "pageFriendCheck",
				type : "GET",
				dataType : "json",
				success : function(data) {
					var pageFriendCheck = data.pageFriendCheck;
					if (pageFriendCheck == null
							&& $('#pageId').val() != $('#sessionId').val()) {
						$('#friendApproveBtn').show();
					}
				}
			})
		});
//페이지 친구 추가
$(document).on('click', '.pageFriendAddBtn', function() {
	$.ajax({
		url : "pageFriendAdd",
		type : "GET",
		success : function(data) {
			console.log("friend add success");
			$('#friendApproveBtn').hide();
		}
	})
});