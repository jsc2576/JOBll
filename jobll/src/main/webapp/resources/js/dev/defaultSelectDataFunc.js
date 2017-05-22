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
		if(cmpny_idx == "선택")
			return;
	}
	$.ajax({
		method : "POST",
		url : "/projectInfo/GetProjectList",
		data : {select_typ : select_typ, cmpny_idx : cmpny_idx},
		success: function(list){
			var str_html = "<div class='row'>" +
		    "<div class='col-lg-12'>" +
	          "<div class='panel panel-default'>" +
	            "<div class='panel-heading'>" +
	                "고객사 프로젝트 리스트" +
	            "</div>" +
	            "<!-- /.panel-heading -->" +
	            "<div class='panel-body'>" +
	                "<table width='80%' class='prjt-table table table-striped table-bordered table-hover' id='dataTables-example'>" +
	                    "<thead>" +
	                        "<tr>" +
	                            "<th>No.</th>" +
	                            "<th>사업명</th>" +
	                            "<th>계약 종류</th>" +
	                            "<th>등록 날짜</th>" +
	                        "</tr>" +
	                    "</thead>" +
	                    "<tbody>";
							for(var i = 0; i < list.length; i++)
							{
								str_html += "<tr class="+(i+1)+">" +
											"<td>"+(i+1)+"</td>" +
											"<td>"+list[i].prjt_sbjt+"</td>" +
											"<td>pass</td>" +
											"<td>0</td>" +
											"</tr>";
							}
				
				str_html += "</tbody>" +
	                "</table>" +
	            "</div>" +
	            "<!-- /.panel-body -->" +
	             "<button class = 'btn prjt_create_btn' onclick = 'PjrtCreateTagController()' style = 'margin : 15px'>프로젝트 추가</button>" +
	     		"<div class='row prjt_create-tag'>" +
	                "<div class='col-lg-12'>" +
	                    "<form role='form'>" +
	                        "<div class='form-group'>" +
	                            "<label>사업명</label>" +
	                            "<input class='form-control' name = 'prjt_sbjt'>" +
	                        "</div>" +
	                        "<div class='form-group'>" +
                            "<label>관리자</label>" +
	                            "<div class='usr_list'>" +
	                            "</div>" +
                            "</div>" +
	                        "<div class='form-group'>" +
	                            "<label>상세 내용</label>" +
	                            "<textarea class='form-control' rows='8'>" +
	                            	"납품상세 :" +
	                            	"																																																																																																		" +
	                            	"제품 :" +
	                            	"																																																																																																		" +
	                            	"계약금 :" +
	                            	"																																																																																																		" +
	                            	"계약서 유무 :" +
	                            	"																																																																																																		" +
	                            	
	                            	"사업 실적 처리 :" +
	                            "</textarea>" +
	                        "</div>" +
	                        "<div class='form-group'>" +
                            "<label>계약 종류</label><br>" +
                            "<select>" +
                            	"<option value = '1'>1(제품/분리발주/쇼핑몰)</option>" +
                            	"<option value = '2'>2(통합사업 + 제품)</option>" +
                            	"<option value = '3'>3(제품/SI)</option>" +
                            	"<option value = '4'>4(SI)</option>" +
                            	"<option value = '5'>5(BPR/ISP/컨설팅)</option>" +
                            	"<option value = '6'>6(IOT)</option>" +
                            "</select>" +
                            "</div>" +
                            "<div class='form-group'>" +
                            	"<button type = 'submit' class = 'btn'>추가</button>" +
                            "</div>" +
	                    "</form>" +
	                "</div>" +
	            "</div>" +
	        "</div>" +
	        "<!-- /.panel -->" +
	    "</div>" +
	    "<!-- /.col-lg-6 -->" +
	"</div>" +
	"<!-- /.row -->";


			$(".prjt_list").html(str_html);	

		},
		error: function(){alert("ERROR");}
	});
}
function GetUsrList(select_typ){
	/*select_typ 1: All
				 2: Find by Cmpny
				 3: Find by Cmpny Only lv 3
	*/
	var cmpny_idx = "";
	
	if(select_typ > 1)
	{
		cmpny_idx = $(".cmpny_value").val();
	}
	$.ajax({
		method : "POST",
		url : "/usrInfo/GetUsrList",
		data : {select_typ : select_typ, usr_cmpny_idx : cmpny_idx},
		success: function(list){
			
			var str_html = "<select class='selectpicker usr_value' data-live-search='true' onChange = ''>";
			str_html += "<option selected>선택</option>";
			for(var i = 0; i < list.length; i++)
				str_html += "<option value = "+list[i].usr_id+">"+list[i].usr_nm+"</option>";
				str_html += "</select>";
			
			$(".usr_list").prepend(str_html);	

		},
		error: function(){alert("ERROR");}
	});
}