$(document).ready (function (){
	usrList();
	
});
function GetCmpnyList(select_typ){
	$.ajax({
		method : "POST",
		url : "/cmpny/GetCmpnyList",
		data : {select_typ : select_typ},
		success: function(list){
			
			var str_html = "<select class='selectpicker cmpny_value' data-live-search='true' onChange = ''>";
			str_html += "<option value ='-1' selected>모두선택</option>";
			for(var i = 0; i < list.length; i++)
				str_html += "<option value = "+list[i].cmpny_idx+">"+list[i].cmpny_nm+"</option>";
				str_html += "</select>";
			
			$(".cmpny_list").prepend(str_html);	

		},
		error: function(){alert("ERROR");}
	});
}
function getUserByCmpny(){
	usr_cmpny_idx = $(".cmpny_value").val();
	$.ajax ({
		method	: "post",
		url		: "/usrInfo/readUserInfoByCmpny",
		data 	: {usr_cmpny_idx : usr_cmpny_idx},
		success	: function (list) {
			var str_html = "<form id='usrInfoRead' action = '/usrInfo/usrInfo' method='get'>";
			str_html += " <div class=\"row\">";
			str_html += "<div class=\"col-lg-12\">";
			str_html += "<h1 class=\"page-header\">회원 목록</h1></div></div>";

			str_html += "<div class=\"row\"><div class=\"col-lg-12\"><div class=\"panel panel-default\"><div class=\"panel-heading\">";
			str_html += "전체 회원 목록 리스트";
			str_html += "</div><div class=\"panel-body\">";
			str_html += "<table width=\"80%\" class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">";
			str_html += "<thead><tr>";
			str_html +="<th width=10%>번호</th>";
			str_html +="<th width=30%>이름</th>";
			str_html +="<th width=10%>등급</th>";
			str_html +="<th width=30%>기관</th>";
			str_html +="<th width=10%> </th>";
			str_html +="</tr></thead><tbody>";
			
	
				
			$.each(list, function(index, value){
				str_html += "<tr>";
				str_html += "<td>"+(index+1)+"</td>";
				str_html += "<td>"+value.usr_nm+"</td>";
				str_html += "<td>"+value.usr_lv+"</td>";
				str_html += "<td>"+value.usr_pwd+"</td>";
				str_html += "<td>"+"<button onclick='submit()'  name = 'usr_id'";
				
				str_html += " id = 'usr_id'";
				str_html += " value = '"+value.usr_id+"'";
				str_html += ">상세열람</button>"+"</td>";
				
				str_html += "</a></tr>";
				
			});	
			str_html +="</tbody></table></div></div></div></div>";
			str_html += "</form>";
			$("#list").html(str_html);
		}
	})
}

function usrList() {
		$.ajax ({
			method	: "post",
			url		: "/usrInfo/allPersonInfo/check/read",
			
			success	: function (list) {
				/*var str_html = "<form id='usrInfoRead' action = '/usrInfo/MyUsrInfo' method='get'>";
				str_html += "<table class = 'table'>";
				str_html += "<thead><tr>";
				str_html += "<th class = 'tb-typ'>번호</th>";
				str_html += "<th class = 'tb-sbjt'>이름</th>";
				str_html += "<th class = 'tb-id'>등급</th>";
				str_html += "<th class = 'tb-reg-date'>기관</th>";
				str_html += "</tr></thead>";
			
				str_html += "<tbody>";
				$.each(list, function(index, value){
					str_html += "<tr>";
					str_html += "<td>"+(index+1)+"</td>";
					str_html += "<td>"+value.usr_nm+"</td>";
					str_html += "<td>"+value.usr_lv+"</td>";
					str_html += "<td>"+value.usr_pwd+"</td>";
					str_html += "<td>"+"<button onclick='submit()'  name = 'usr_id'";
					
					str_html += " id = 'usr_id'";
					str_html += " value = '"+value.usr_id+"'";
					str_html += ">상세열람</button>"+"</td>";
					
					str_html += "</a></tr>";
					
				});
				str_html += "</tbody>";
				str_html += "</table>";
				str_html += "<div id = 'getIdx'></div>";
				str_html += "</form>";*/
				
				
				var str_html = "<form id='usrInfoRead' action = '/usrInfo/usrInfo' method='get'>";
				str_html += " <div class=\"row\">";
				str_html += "<div class=\"col-lg-12\">";
				str_html += "<h1 class=\"page-header\">회원 목록</h1></div></div>";

				str_html += "<div class=\"row\"><div class=\"col-lg-12\"><div class=\"panel panel-default\"><div class=\"panel-heading\">";
				str_html += "전체 회원 목록 리스트";
				str_html += "</div><div class=\"panel-body\">";
				str_html += "<table width=\"80%\" class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">";
				str_html += "<thead><tr>";
				str_html +="<th width=10%>번호</th>";
				str_html +="<th width=30%>이름</th>";
				str_html +="<th width=10%>등급</th>";
				str_html +="<th width=30%>기관</th>";
				str_html +="<th width=10%> </th>";
				str_html +="</tr></thead><tbody>";
				
		
					
				$.each(list, function(index, value){
					str_html += "<tr>";
					str_html += "<td>"+(index+1)+"</td>";
					str_html += "<td>"+value.usr_nm+"</td>";
					str_html += "<td>"+value.usr_lv+"</td>";
					str_html += "<td>"+value.usr_pwd+"</td>";
					str_html += "<td>"+"<button onclick='submit()'  name = 'usr_id'";
					
					str_html += " id = 'usr_id'";
					str_html += " value = '"+value.usr_id+"'";
					str_html += ">상세열람</button>"+"</td>";
					
					str_html += "</a></tr>";
					
				});	
				str_html +="</tbody></table></div></div></div></div>";
				str_html += "</form>";
				$("#list").html(str_html);
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});
}
