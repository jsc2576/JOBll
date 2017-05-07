$(document).ready (function (){
	GetCmpnyList();
});
function GetCmpnyList(){

	$.ajax({
		method : "POST",
		url : "/admin/GetCmpnyList",
		data : {},
		success: function(list){
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

function GetUsrInfoList(cmpny_idx){

	$.ajax({
		method : "POST",
		url : "/admin/GetCmpnyUsrInfo",
		data : {usr_cmpny_idx : cmpny_idx},
		success: function(list){
			var str_html = "<table class = 'table'>";
			str_html += "<tr>";
			str_html += "<th class = 'tb-typ'>번호</th>";
			str_html += "<th class = 'tb-sbjt'>이름</th>";
			str_html += "<th class = 'tb-reg-date'>기관</th>";
			str_html += "<th class = 'tb-id'>등급</th>";
			str_html += "<th>권한 변경</th>";
			str_html += "</tr>";
			for(var i = 0; i < list.length; i++)
			{
				str_html += "<tr>";
				str_html += "<td>"+(i+1)+"</td>";
				str_html += "<td>"+list[i].usr_nm+"</td>";
				str_html += "<td>"+list[i].usr_pwd+"</td>";
				str_html += "<td>"+list[i].usr_lv+"</td>";
				str_html += "<td>";
				str_html += "<select class='selectpicker' data-live-search='true' onChange = 'GetChangeUsrAuth("+list[i].usr_id+",this.value)'>";
				for(var j = 0; j < 4; j++)
				{
					if(j == list[i].usr_lv-1)
						str_html += "<option selected value = "+(j+1)+">"+(j+1)+"</option>";
					else
						str_html += "<option value = "+(j+1)+">"+(j+1)+"</option>";
				}
					
				str_html += "</select>";
				str_html += "</td>";
				
				str_html += "</tr>";
			}
			
			str_html += "</table>";
		
			$("#usrInfoList").html(str_html);	
		},
		error: function(){alert("ERROR");}
	});
}

function GetChangeUsrAuth(usr_id,change_lv){
	$.ajax({
		method : "POST",
		url : "/admin/GetChangeUsrAuth",
		data : {usr_id : usr_id, usr_lv : change_lv},
		success: function(){
		},
		error: function(){alert("ERROR");}
	});
}