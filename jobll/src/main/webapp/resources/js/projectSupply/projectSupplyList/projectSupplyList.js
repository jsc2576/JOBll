$(document).ready (function (){
	readProjectSupplyList();
});

function readProjectSupplyList(){
	$.ajax({
		method : "POST",
		url : "/projectSupply/listRun",
		data : {},
		success: function(list){
			var str_html = "<ul class = 'project supply list'>";
			str_html += "<li><a onclick = 'readProjectSupply("+list[0].prjt_idx+")'>"+list[0].prjt_sup_list_idx+"</a></li>";
			str_html += "</ul>";
			$(".list").html(str_html);
		},
		error: function(){alert("ERROR");}
	});
}

function readProjectSupply(idx){
	
	var str_html = "<input type ='hidden' name = 'prjt_idx' value = '"+idx+"'>";
	
	$(".list").html(str_html);
	
	$("#projectSupply").submit();

}