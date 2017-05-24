$(document).ready (function (){
	GetProjectTable(2);

});

function readProjectList(){

	$.ajax({
		method : "POST",
		url : "/projectInfo/GetProjectList",
		data : {},
		success: function(list){

			var margin_value = 0;
			var str_html = "<ul class = 'project tree'>";
			for(var i = 0; i < list.length; i++)
			{
				margin_value = (list[i].prjt_lv-1)*20;
				str_html += "<li style = 'margin-left : "+margin_value+"px;'><a onclick = 'readProjectInfo("+list[i].prjt_idx+")'>"+list[i].prjt_sbjt+"</a></li>";
			}
			str_html += "</ul>";
			
			$(".list").html(str_html);
			
				
	
		},
		error: function(){alert("ERROR");}
	});
}


