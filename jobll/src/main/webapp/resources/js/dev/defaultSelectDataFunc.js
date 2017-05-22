function GetCmpnyList(select_typ){
	/*select_typ 1: All
				 2: Find by usr_id
	*/
	$.ajax({
		method : "POST",
		url : "/cmpny/GetCmpnyList",
		data : {select_typ : select_typ},
		success: function(list){
			
			var str_html = "<select class='selectpicker cmpny_value' data-live-search='true' onChange = ''>";
			str_html += "<option selected>선택</option>";
			for(var i = 0; i < list.length; i++)
				str_html += "<option value = "+list[i].cmpny_idx+">"+list[i].cmpny_nm+"</option>";
				str_html += "</select>";
			
			$(".cmpny_list").prepend(str_html);	

		},
		error: function(){alert("ERROR");}
	});
}
function GetProjectList(select_typ){
	/*select_typ 1: All
				 2: Find by usr_cmpny
				 3: Find by selected_cmpny
	*/
	
	var cmpny_idx = "";
	
	if(select_typ == 3)
	{
		cmpny_idx = $(".cmpny_value").val();
	}
	$.ajax({
		method : "POST",
		url : "/projectInfo/GetProjectList",
		data : {select_typ : select_typ, cmpny_idx : cmpny_idx},
		success: function(list){
			
			var str_html = "<select class='selectpicker' onChange = ''>";
			str_html += "<option selected>선택</option>";
			for(var i = 0; i < list.length; i++)
				str_html += "<option value = "+list[i].prjt_idx+">"+list[i].prjt_sbjt+"</option>";
				str_html += "</select>";
			
			$(".prjt_list").html(str_html);	

		},
		error: function(){alert("ERROR");}
	});
}
function GetProjectTable(select_typ){
	/*select_typ 1: All
				 2: Find by usr_cmpny
				 3: Find by selected_cmpny
	*/
	
	var cmpny_idx = "";
	
	if(select_typ == 3)
	{
		cmpny_idx = $(".cmpny_value").val();
	}
	$.ajax({
		method : "POST",
		url : "/projectInfo/GetProjectList",
		data : {select_typ : select_typ, cmpny_idx : cmpny_idx},
		success: function(list){
			
			
			
			$(".prjt_list").html(str_html);	

		},
		error: function(){alert("ERROR");}
	});
}