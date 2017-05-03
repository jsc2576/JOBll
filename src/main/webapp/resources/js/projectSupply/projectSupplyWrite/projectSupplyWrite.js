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
			str_html += "<option value = '"+list[0].prjt_idx+"'>"+list[0].prjt_idx+"</option>";
			for(var i = 1; i < list.length; i++){
				var check = 0;
				for(var j = 0; j < i; j++){
					if(list[j].prjt_idx == list[i].prjt_idx){
						check = 1;
					}
				}
				if(check == 0){
					str_html += "<option value = '"+list[i].prjt_idx+"'>"+list[i].prjt_idx+"</option>";
				}
			}
			str_html += "</select>";
			
			$(".SupplyList").html(str_html);
	
		},
		error: function(){alert("ERROR");}
	});
}