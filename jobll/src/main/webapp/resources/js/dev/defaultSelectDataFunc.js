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
				 4: Find by selected_cmpny + graph data func
	*/
	
	var cmpny_idx = "";
	
	if(select_typ > 2)
	{
		cmpny_idx = $(".cmpny_value").val();
	}
	$.ajax({
		method : "POST",
		url : "/projectInfo/GetProjectList",
		data : {select_typ : select_typ, cmpny_idx : cmpny_idx},
		success: function(list){
			
			var str_html = "";
			if(select_typ == 4)
			{
				str_html += "<select class='selectpicker' onChange = 'GetIssueRate(this.value)'>";
			}
			else
			{
				str_html += "<select class='selectpicker' onChange = ''>";
			}
			
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
	 * 			 2: Find by selected_cmpny
				 3: Find by usr_cmpny
				 4: Find by usr_cmpny lv = 1 
	*/
	
	var cmpny_idx = "";
	
	if(select_typ == 2)
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
	            "<div class='panel-heading'>";
				if(select_typ > 2)
				{
					str_html += "진행중인 프로젝트 리스트";
				}
				else
				{
					str_html +=  "고객사 프로젝트 리스트";
				}
	               
				str_html +=  "</div>" +
	            "<!-- /.panel-heading -->" +
	            "<div class='panel-body'>" +
	                "<table width='80%' class='prjt-table table table-striped table-bordered table-hover' id='dataTables-example'>" +
	                    "<thead>" +
	                        "<tr>" +
	                            "<th>No.</th>" +
	                            "<th style='width: 55%;'>사업명</th>" +
	                            "<th>등록 날짜</th>" +
	                            "<th>담당자</th>";
								if(select_typ < 3)
								str_html += "<th>설정</th>";
							str_html += "</tr>" +
	                    "</thead>" +
	                    "<tbody>";
							for(var i = 0; i < list.length; i++)
							{
								str_html += "<tr class="+(i+1)+">" +
											"<td>"+(i+1)+"</td>" +
											"<td onclick = 'readProjectInfo("+list[i].prjt_idx+")'>"+list[i].prjt_sbjt+"</td>" +
											"<td>"+list[i].reg_date+"</td>" +
											"<th>"+list[i].usr_id+"</th>";
											if(select_typ < 3)
											{
												str_html += "<td>" +
												"<button onclick = mofidyProjectPop("+list[i].prjt_idx+")>수정</button><button onclick = deleteProject("+list[i].prjt_idx+")>삭제</button>"
												"</td>";
											}
											
											str_html += "</tr>";
							}
				
				str_html += "</tbody>" +
	                "</table>" +
	            "</div>" +
	            "<!-- /.panel-body -->";
	            if(select_typ < 3)
            	{
	            	str_html += "<button class = 'btn prjt_create_btn' onclick = 'PjrtCreateTagController()' style = 'margin : 15px'>프로젝트 추가</button><br><button>선택</button>" +
		     		"<div class='row prjt_create-tag'>" +
		                "<div class='col-lg-12'>" +
		                    "<form role='form' class = 'project-create-form' method = 'POST'>" +
		                        "<div class='form-group'>" +
		                            "<label>사업명</label>" +
		                            "<input class='form-control prjt-sbjt' name = 'prjt_sbjt'>" +
		                        "</div>" +
		                        "<div class='form-group'>" +
	                            "<label>관리자</label>" +
		                            "<div class='usr_list'>" +
		                            "</div>" +
	                            "</div>" +
		                        "<div class='form-group'>" +
		                            "<label>상세 내용</label>" +
		                            "<textarea class='form-control' rows='8' name = 'prjt_conts'>" +
		                            	"납품상세 :\n" +
		                            	"제품 :\n" +
		                            	"계약금 :\n" +	
		                            	"계약서 유무 :\n" +
		                            	"사업 실적 처리 :\n" +
		                            "</textarea>" +
		                        "</div>" +
	                            "<div class='form-group'>" +
	                            	"<button onclick = 'createPorject()' class = 'btn'>추가</button>" +
	                            "</div>" +
		                    "</form>" +
		                "</div>" +
		            "</div>";
		}
	            str_html += "</div>" +
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
				 3: Find by Cmpny Only lv 2
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
			for(var i = 0; i < list.length; i++)
				str_html += "<option value = "+list[i].usr_id+">"+list[i].usr_nm+"("+list[i].usr_id+")</option>";
				str_html += "</select>";
			
			$(".usr_list").prepend(str_html);	

		},
		error: function(){alert("ERROR");}
	});
}
//GetHstyTable(prjt_idx); : 본래 코드, 페이징을 위해 변경 - OSC
function GetHstyTable(prjt_idx,off,page_off){
	$.ajax({
		method : "POST",
		url : "/allPersonInfo/GetHstyLog",
		data : {prjt_idx : prjt_idx,off : off, page_off : page_off},
		success: function(list){
			//for(var i = 0; i < list.length; i++)
			//{
				var str_html = "<div class='row'>" +
			    "<div class='col-lg-12'>" +
		          "<div class='panel panel-default'>" +
		            "<div class='panel-heading'>" +
		            "프로젝트 현황" +
					"</div>" +
		            "<!-- /.panel-heading -->" +
		            "<div class='panel-body'>" +
		                "<table width='80%' class='prjt-table table table-striped table-bordered table-hover' id='dataTables-example'>" +
		                    "<thead>" +
		                        "<tr>" +
		                            "<th>No.</th>" +
		                            "<th style='width: 55%;'>내용</th>" +
		                            "<th>등록 날짜</th>" +
		                        "</tr>" +
		                    "</thead>" +
		                    "<tbody>";
								for(var j = 0; j < list.length; j++)
								{
									str_html += "<tr class="+(j+1)+">" +
												"<td>"+(j+off*10+1)+"</td>" +
												"<td>"+list[j].hsty_conts+"</td>" +
												"<th>"+list[j].hsty_date+"</th>" +
												"</tr>";
								}
								var page_html =  
									"<div class=\"container\">"+
									"<ul class=\"pagination\">";
									if(page_off==0)
										page_html += "<li class=\"disabled\">"; 
									else 
										page_html += "<li>";
									page_html += "<a onclick = \"GetHstyTable("+prjt_idx+","+(page_off-1)+","+(page_off-5)+")\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>";
									for(i=0; i<5; i++){
										if(i==(off-page_off))
											page_html += "<li class=\"active\">";
										else
											page_html += "<li>";
										page_html+="<a onclick = \"GetHstyTable("+prjt_idx+","+(page_off+i)+","+(page_off)+")\">"+(page_off+i+1)+"</a></li>";
									}
									page_html +="<li>"+ 
										"<a onclick = \"GetHstyTable("+prjt_idx+","+(page_off+5)+","+(page_off+5)+")\">" + 
										"<span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>"+
								  	"</ul>"+
								  	"</div>";
									$("#pagination").html(page_html);
					str_html += "</tbody>" +
		                "</table>" +
		            "</div>" +
		            "<!-- /.panel-body -->";
					"</div>" +
				"</div>" +
			"</div>" +
			"</div>";
					
					$(".hsty_list").html(str_html);	
			//}
		
			
			
		},
		error: function(){alert("ERROR");}
	});
}

function readProjectInfo(idx){
	
	var str_html = "<input type ='hidden' name = 'prjt_idx' value = '"+idx+"'>";
	
	$(".prjt_list").html(str_html);
	$(".prjt_data").html(str_html);
	$(".project-form").attr('action', "/projectInfo/prjt/check/read");
	$(".project-form").submit();

}

function GetIssueRate(prjt_idx)
{
	$.ajax({
		method : "POST",
		url : "/issue/GetIssueRate",
		data : {prjt_idx : prjt_idx},
		success: function(list){
			for(var i = 0; i < list.length; i++)
			{
				if(list[i] == null)
					list[i] = 0;
			}
			graphRefresh(list[0],list[1],list[2],list[3],list[4]);

		},
		error: function(){alert("ERROR");}
	});
	GetHstyTable(prjt_idx,0,0);
	//GetHstyTable(prjt_idx); : 본래 코드, 페이징을 위해 변경 - OSC
}