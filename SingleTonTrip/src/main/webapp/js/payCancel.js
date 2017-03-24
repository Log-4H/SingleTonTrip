// 환불 버튼 클릭
function payback_click(){
	var check = confirm('환불 하시겠습니까?');
	if(check == true){
		document.form.submit();
		alert('환불 되었습니다');
	} else {
		return false;
	}
}
// 취소 버튼 클립
function paybackCancel_click(){
	var check = confirm('취소 하시겠습니까?');
	if(check == true){
		document.form.submit();
		alert('취소 되었습니다');
	} else {
		return false;
	}
}