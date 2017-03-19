$(document).ready (function (){
	readProjectList();

});

function readProjectList(){

	$.ajax({
		method : "POST",
		url : "/projectInfo/listRun",
		data : {},
		success: function(list){

			var level = 1;
			var str_html = "<ul class = 'project tree'>";
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
				str_html += "<li><a onclick = 'readProjectInfo("+list[i].prjt_idx+")'>"+list[i].prjt_sbjt+"</a></li>";
				
				level = list[i].prjt_lv;
				
			}
			str_html += "</ul>";
			
			$(".list").html(str_html);
			
				
	
		},
		error: function(){alert("ERROR");}
	});
}

function readProjectInfo(idx){
	
	var str_html = "<input type ='hidden' name = 'prjt_idx' value = '"+idx+"'>";
	
	$(".list").html(str_html);
	
	$("#projectInfo").submit();

}

