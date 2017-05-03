$(document).ready (function (){
	readProject();

});

function readProject(){

	$.ajax({
		method : "POST",
		url : "/projectInfo/listRun",
		data : {},
		success: function(list){

			var str_html = "<select class = 'high_prjt_idx' name = 'high_prjt_idx'>";
			str_html += "<option>없음</option>";
			for(var i = 0; i < list.length; i++)
			{
				str_html += "<option value = '"+list[i].prjt_idx+"'>"+list[i].prjt_sbjt+"</option>";
			}
			str_html += "</select>";
			
			$(".High-Project-List").html(str_html);
			
				
	
		},
		error: function(){alert("ERROR");}
	});
}