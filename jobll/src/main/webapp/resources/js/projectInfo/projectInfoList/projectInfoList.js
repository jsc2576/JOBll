$(document).ready (function (){
	readProject();

});

function readProject(){

	$.ajax({
		method : "POST",
		url : "/projectInfo/listRun",
		data : {},
		success: function(list){

			var level = 1;
			var str_html = "<ul class = 'project'>";
			for(var i = 0; i < list.length; i++)
			{
				if(level < list[i].prjt_lv)
				{
					str_html += "<ul>";
				}
				else if(level > list[i].prjt_lv)
				{
					for(var j = 0; j < level - list[i].prjt_lv; j++)
					str_html += "</ul>";
				}
				str_html += "<li>"+list[i].prjt_sbjt+"</li>";
				
				level = list[i].prjt_lv;
				
			}
			str_html += "</ul>";
			
			$(".list").html(str_html);
			
				
	
		},
		error: function(){alert("ERROR");}
	});
}