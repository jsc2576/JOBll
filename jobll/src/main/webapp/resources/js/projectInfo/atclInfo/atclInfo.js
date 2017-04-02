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

function commentSend() {
	
	var atcl_idx = $(".atcl_idx").val();
	var cmt_conts = $(".comment").val();
	$.ajax({
		method : "POST",
		url : "/cmt/reg",
		data : {atcl_idx : atcl_idx, cmt_conts : cmt_conts},
		success: function(list){
			
			
		},
		error: function(){alert("ERROR");}
	});
}