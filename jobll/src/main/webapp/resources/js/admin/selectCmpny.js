$(document).ready (function (){
	
});
function GetCmpnyList(type){
	
	if(type = 1)
	{
		$.ajax({
			method : "POST",
			url : "/admin/GetCmpnyList",
			data : {},
			success: function(list){
				 "";
				
				var str_html = "<select class='selectpicker' data-live-search='true' onChange = 'GetUsrInfoList(this.value)'>";
				str_html += "<option selected>선택</option>";
				for(var i = 0; i < list.length; i++)
					str_html += "<option value = "+list[i].cmpny_idx+">"+list[i].cmpny_nm+"</option>";
					str_html += "</select>";
				
				$("#cmpny_list").html(str_html);		
			},
			error: function(){alert("ERROR");}
		});
	}
	else if(type = 2)
	{
		$.ajax({
			method : "POST",
			url : "/admin/GetCmpnyList",
			data : {},
			success: function(list){
				 "";
				
				var str_html = "<select class='selectpicker' data-live-search='true' onChange = 'GetCmpnyPrjtList(this.value)'>";
				str_html += "<option selected>선택</option>";
				for(var i = 0; i < list.length; i++)
					str_html += "<option value = "+list[i].cmpny_idx+">"+list[i].cmpny_nm+"</option>";
					str_html += "</select>";
				
				$("#cmpny_list").html(str_html);		
			},
			error: function(){alert("ERROR");}
		});
	}
}