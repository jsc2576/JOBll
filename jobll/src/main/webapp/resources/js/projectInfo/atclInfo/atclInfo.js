$(document).ready (function (){
	commentSend();

});

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
			
			var str_html = "";
			
			for(var i = 0; i < list.length; i++)
			{
				str_html += "<h4>"+list[i].usr_id+"</h4>";
				str_html += "<p>"+list[i].cmt_conts+"</p>";
				str_html += "<p>"+list[i].reg_date+"</p><br>";
			}
			
			$(".comment-output-tag").html(str_html);
			$(".comment").val("");
		},
		error: function(){alert("ERROR");}
	});
}