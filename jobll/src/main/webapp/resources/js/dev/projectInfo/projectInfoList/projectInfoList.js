$(document).ready (function (){
	GetProjectTable(4);

});

function readProjectInfo(idx){
	
	var str_html = "<input type ='hidden' name = 'prjt_idx' value = '"+idx+"'>";
	
	$(".prjt_list").append(str_html);
	
	$("#projectInfo").submit();

}
