function issueDelete() {
	var confirm_val = confirm("정말로 삭제하겠습니까?");
	
	if(confirm_val) {
	
		$("#dataSender").attr('action', "/issue/del");
		$("#dataSender").attr('method', 'post');
		
		var idx = "<input type = 'hidden' class = 'atcl_idx' name = 'atcl_idx' value = "+$(".atcl_idx").val()+"> ";
		$("#dataSender").append(idx);
		$("#dataSender").submit();

	}
}

function issueModify() {

		$("#dataSender").attr('action', "/issue/mdf");
		$("#dataSender").attr('method', 'post');
		
		var idx = "<input type = 'hidden' class = 'atcl_idx' name = 'atcl_idx' value = "+$(".atcl_idx").val()+"> ";
		$("#dataSender").append(idx);
		$("#dataSender").submit();
}