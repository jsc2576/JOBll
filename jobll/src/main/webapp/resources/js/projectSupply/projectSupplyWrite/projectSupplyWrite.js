$(document).ready (function (){
	writeProjectSupply();

});

function writeProjectSupply(){

	$.ajax({
		method : "POST",
		url : "/projectSupply/listRun",
		data : {},
		success: function(list){

			var str_html = "<select class = 'prjt_idx' name = 'prjt_idx'>";
			str_html += "<option>없음</option>";
			for(var i = 0; i < list.length; i++)
			{
				str_html += "<option value = '"+list[i].prjt_idx+"'>"+list[i].prjt_sup_list_idx+"</option>";
			}
			str_html += "</select>";
			
			$(".SupplyList").html(str_html);
	
		},
		error: function(){alert("ERROR");}
	});
}