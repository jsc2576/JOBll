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
			var str_html = "<select class = 'prjt_idx' name = 'projectSupplyReadOne'>";
			for(var i = 0; i < list.length; i++)
			{
				str_html += "<option value = 'readProjectInfo("+list[i].prjt_idx+")'>"+list[i].prjt_sbjt+"</option>";
			}
			str_html += "</select>";
			
		$(".list").html(str_html);		
	},
	error: function(){alert("ERROR");}
});
}
