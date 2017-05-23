$(document).ready (function (){
	getUsrIdAndLv();
	commentSend();
	
});

var atcl_idx = $(".atcl_idx").val();
var prjt_idx = $(".prjt_idx").val();
var cmt_conts = $(".comment").val();

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
	atcl_idx = $(".atcl_idx").val();
	prjt_idx = $(".prjt_idx").val();
	cmt_conts = $(".comment").val();
	
	$.ajax({
		method : "POST",
		url : "/cmt/reg",
		data : {prjt_idx : prjt_idx, atcl_idx : atcl_idx, cmt_conts : cmt_conts},
		success: function(list){
			
			var str_html = "";
			
			for(var i = 0; i < list.length; i++)
			{
				str_html += "<h4>"+list[i].usr_id+"</h4>";
				if(Auth_data.usr_lv < 3 && Auth_data.usr_id != list[i].usr_id)
				{
					str_html += "<p class = '"+list[i].cmt_idx+"'>"+list[i].cmt_conts+"</p>";
				}
				else
				{
					str_html += "<p class = '"+list[i].cmt_idx+"'>"+list[i].cmt_conts+"" +
					"<a class ='comment_delete Others' onclick = 'commentDelete("+list[i].cmt_idx+")'>삭제</a>" +
					"<a class ='comment_modify Others' onclick = 'commentModifyShow("+list[i].cmt_idx+")'>수정</a>" +
					"<a class ='comment-modify-input Others'>" +
					"<input class ='form-control' type = 'text'>" +
					"<button class = 'btn btn-primary' onclick = 'commentModify("+list[i].cmt_idx+")'>수정</button>" +
					"</a></p>";
				}
				
				str_html += "<p>"+list[i].reg_date+"</p><br>";
			}
			
			$(".comment-output-tag").html(str_html);
			$(".comment").val("");
		},
		error: function(){alert("ERROR");}
	});
}

function commentDelete(cmt_idx) {
	$.ajax({
		method : "POST",
		url : "/cmt/del/send",
		data : {prjt_idx : prjt_idx,cmt_idx : cmt_idx},
		success: function(){
			commentSend();
		},
		error: function(){alert("ERROR");}
	});
}//
function commentModify(cmt_idx) {
	var cmt_conts = $(".comment-modify-input-view input[type=text]").val();
	$.ajax({
		method : "POST",
		url : "/cmt/mdf/send",
		data : {prjt_idx : prjt_idx, cmt_idx : cmt_idx, cmt_conts : cmt_conts},
		success: function(){
			commentSend();
		},
		error: function(){alert("ERROR");}
	});
}
function commentModifyShow(cmt_idx) {
	$(".comment-modify-input").removeClass("comment-modify-input-view");
	$(".comment-modify-input").val("");
	$("."+cmt_idx+" .comment-modify-input").addClass("comment-modify-input-view");
}