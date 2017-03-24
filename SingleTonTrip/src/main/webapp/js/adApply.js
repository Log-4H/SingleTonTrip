function adApply_click(){
	var check = confirm('신청하시겠습니까?');
	if(check == true){
		document.form.submit();
		alert('신청되었습니다.');
	} else {
		return false;
	}
}