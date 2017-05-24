$(document).ready (function (){
	usrList(0,0);
	getCmpnyList();
});
function getCmpnyList(){
	$.ajax({
		method : "POST",
		url : "/cmpny/GetCmpnyList",
		//data : {select_typ : select_typ},
		success: function(list){
			
			var str_html = "<select class='selectpicker cmpny_value' data-live-search='true' onChange = ''>";
			str_html += "<option value ='-1' selected>모두선택</option>";
			for(var i = 0; i < list.length; i++)
				str_html += "<option value = "+list[i].cmpny_idx+">"+list[i].cmpny_nm+"</option>";
				str_html += "</select>";
			
				str_html += "<button onclick = \"getUserByCmpny(0,0)\">검색</button>";
			$("#cmpnyList").html(str_html);	
			
		},
		error: function(){alert("ERROR");}
	});
}
function getUserByCmpny(off,page_off){
	usr_cmpny_idx = $(".cmpny_value").val();
	$.ajax ({
		method	: "post",
		url		: "/usrInfo/readUserInfoByCmpny",
		data 	: {usr_cmpny_idx : usr_cmpny_idx,off : off, page_off : page_off},
		success	: function (list) {
			var str_html = "<form id='usrInfoRead' action = '/usrInfo/usrInfo' method='get'>";
			str_html += " <div class=\"row\">";
			str_html += "<div class=\"col-lg-12\">";
			str_html += "<h1 class=\"page-header\">사용자 목록</h1></div></div>";

			str_html += "<div class=\"row\"><div class=\"col-lg-12\"><div class=\"panel panel-default\"><div class=\"panel-heading\">";
			str_html += "전체 사용자 리스트";
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
				str_html += "<td style ='text-align : center;'>"+"<button onclick='submit()'  name = 'usr_id'";
				
				str_html += " id = 'usr_id'";
				str_html += " value = '"+value.usr_id+"'";
				str_html += ">상세열람</button>"+"</td>";
				
				str_html += "</a></tr>";
				
			});	
			str_html +="</tbody></table></div></div></div></div>";
			str_html += "</form>";
			$("#list").html(str_html);
			
			var page_html =  
				"<div class=\"container\">"+
				"<ul class=\"pagination\">";
				
				
				if(page_off==0)
					page_html += "<li class=\"disabled\">"; 
				else 
					page_html += "<li>";
				page_html += "<a onclick = \"getUserByCmpny("+(page_off-1)+","+(page_off-5)+")\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>";
				
				
				
				for(i=0; i<5; i++){
					if(i==(off-page_off))
						page_html += "<li class=\"active\">";
					else
						page_html += "<li>";
					page_html+="<a onclick = \"getUserByCmpny("+(page_off+i)+","+(page_off)+")\">"+(page_off+i+1)+"</a></li>";
				}
				
					
					
				page_html +="<li>"+ 
					"<a onclick = \"getUserByCmpny("+(page_off+5)+","+(page_off+5)+")\">" + 
					"<span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>"+
			    	
			  	"</ul>"+
			  	"</div>";
				$("#pagination").html(page_html);
		}
	})
}

function usrList(off,page_off) {
		$.ajax ({
			method	: "post",
			url		: "/usrInfo/allPersonInfo/check/read",
			data : {off : off, page_off : page_off},
			success	: function (list) {

				var str_html = "<form id='usrInfoRead' action = '/usrInfo/usrInfo' method='get'>";
				str_html += " <div class=\"row\">";
				str_html += "<div class=\"col-lg-12\">";
				str_html += "<h1 class=\"page-header\">사용자 목록</h1></div></div>";

				str_html += "<div class=\"row\"><div class=\"col-lg-12\"><div class=\"panel panel-default\"><div class=\"panel-heading\">";
				str_html += "전체 사용자 리스트";
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
					str_html += "<td>"+(index+off*10+1)+"</td>";
					str_html += "<td>"+value.usr_nm+"</td>";
					str_html += "<td>"+value.usr_lv+"</td>";
					str_html += "<td>"+value.usr_pwd+"</td>";
					str_html += "<td style ='text-align : center;'>"+"<button onclick='submit()'  name = 'usr_id'";
					
					str_html += " id = 'usr_id'";
					str_html += " value = '"+value.usr_id+"'";
					str_html += ">상세열람</button>"+"</td>";
					
					str_html += "</a></tr>";
					
				});	
				str_html +="</tbody></table></div></div></div></div>";
				str_html += "</form>";
				$("#list").html(str_html);
				
				var page_html =  
				"<div class=\"container\">"+
				"<ul class=\"pagination\">";
				if(page_off==0)
					page_html += "<li class=\"disabled\">"; 
				else 
					page_html += "<li>";
				page_html += "<a onclick = \"usrList("+(page_off-1)+","+(page_off-5)+")\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>";
				for(i=0; i<5; i++){
					if(i==(off-page_off))
						page_html += "<li class=\"active\">";
					else
						page_html += "<li>";
					page_html+="<a onclick = \"usrList("+(page_off+i)+","+(page_off)+")\">"+(page_off+i+1)+"</a></li>";
				}
				page_html +="<li>"+ 
					"<a onclick = \"usrList("+(page_off+5)+","+(page_off+5)+")\">" + 
					"<span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>"+
			  	"</ul>"+
			  	"</div>";
				$("#pagination").html(page_html);
				
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});
}
