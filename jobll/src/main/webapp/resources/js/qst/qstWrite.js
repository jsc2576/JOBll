$(document).ready(function(){
	enter_korean();
});

function enter_korean(){
	$("#secret").html("비밀글");
}

function make_re(){
	var high_qst_idx = $("#high_qst_idx").val();
	var qst_sbjt = $("#qst_sbjt").val();
	var qst_conts = $("#qst_conts").val();
	var qst_stus;
	
	if(!$("#qst_stus").is(":checked")){
		qst_stus = 1;
	}
	else{
		qst_stus = 3;
	}
	alert(high_qst_idx);
	
	$.ajax({
		method: "POST",
		url: "/qstWrite/send",
		data: {high_qst_idx: high_qst_idx, qst_sbjt: qst_sbjt, qst_conts: qst_conts, qst_stus: qst_stus},
		success: function(data){
			alert(data);
		},
		error: function(){
			alert("error");
		}
	});
	
}