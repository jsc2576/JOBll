$(document).ready (function (){
	writeProjectSupply();

});

function writeProjectSupply(){
	var prjt_idx = $(".prjt_idx").val();
	$.ajax({
		method : "POST",
		url : "/projectSupply/prjt/read",
		data : {prjt_idx : prjt_idx},
		success: function(list){
			var cmpny_idx;
			var str_html = "<select id = 'cmpny' class = 'prjt_idx' name = 'projectSupplyReadOne'>";
			for(var i = 0; i < list.length; i++)
			{
				str_html += "<option value = "+list[i].prjt_idx+">"+list[i].prjt_sbjt+"</option>";
			}
			str_html += "</select>";
			cmpny_idx = $("#cmpny").val();
			
		$(".list").html(str_html);		
	},
	error: function(){alert("ERROR");}
});
}
function sendRequest() {
	
	var str_html = "<input type = 'hidden' class = 'req_prjt_idx' name = 'req_prjt_idx' value = '"+
	$(".prjt_idx option:selected").val()+"'>";
	
	$(".list").append(str_html);
	
	submit();
	
}