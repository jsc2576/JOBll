$(document).ready(function(){
	Cunt_Prjt();
	Tot_Prcs();
	Cnet_Prjt_Change();
	find_cnet_atcl_list();
});

var cunt_prjt;

function Cunt_Prjt(){ // 최근 프로젝트
	
	$("#cnet_list_name").html("프로젝트 리스트");
	$.ajax({
		method: "POST",
		url: "/cuntPrjt/check/read",
		success:function(list){
			var str_html = "<option value=''>----최근----</option>";
			$.each(list, function(index, data){
				str_html += "<option value='";
				str_html += data.prjt_idx;
				str_html += "'>";
				str_html += data.prjt_sbjt;
				str_html += "</option>";
			});
			
			Cnet_Prjt(str_html);
			
		},
		error: function(){
			var str_html = "<table class = 'cunt_prjt'>";
			str_html += "<thead><tr>";
			str_html += "<th>최근 프로젝트</th>";
			str_html += "</tr></thead>";		
			str_html += "<tbody>";
			str_html += "</tbody> </table>";
			$("#cunt_list").html(str_html);
		}
	});
}

function Cnet_Prjt(str_html){ // 담당 프로젝트
	
	
	$.ajax({
		method: "POST",
		url: "/cnetPrjt/check/read",
		success: function(list){
			str_html += "<option value=''>----담당----</option>";
			$.each(list, function(index, data){
				str_html += "<option value='";
				str_html += data.prjt_idx;
				str_html += "'>";
				str_html += data.prjt_sbjt;
				str_html += "</option>";
			});
			
			$("#cnet_list").html(str_html);
		},
		error: function(){alert("ERROR")}
	});
}

function Cnet_Prjt_Change(){
	$("#cnet_list").change(function(){
		var prjt_idx = $("#cnet_list").val();
		Tot_Prcs(prjt_idx);
	});
	
}

function Tot_Prcs(prjt_idx){
	
	$.ajax({
		method: "POST",
		url: "/atcl_chart",
		data: {prjt_idx : prjt_idx},
		success: function(data){
			var tot = data[0];
			var rmn = data[1];
			var end = data[2];
			Circle_chart(tot, rmn, end);
		},
		error: function(){
			alert("chart error");
		}
	});	
}

function Circle_chart(tot, rmn, end){
	var options = {
			'dataset':{
				[title: 'Web accessibility status',
				values:[end, tot-end-rmn, rmn],
				colorset: ['#2EB400', '#2BC8C9', "#666666"],
				fields: ['종료 이슈', '진행 이슈',  '남은 이슈'],
			},
			'donut_width' : 100,
			'core_circle_radius':0,
			'chartDiv': 'Nwagon',
			'chartType': 'pie',	
			'chartSize': {width:500, height:200}
		};
	$("#Nwagon").html("");
	Nwagon.chart(options);	
}

function find_cnet_atcl_list(){
	var str_html = "<thead><tr>";
	str_html += "<td>인덱스</td>";
	str_html += "<td>제목</td>";
	str_html += "<td>작성자</td>";
	str_html += "<td>날짜</td>";
	str_html += "</thead></tr>";
	str_html += "<tbody>";
	
	$.ajax({
		method: "POST",
		url: "/rcnt_atcl/read",
		success: function(list){
			$.each(list, function(index, data){
				str_html += "<tr>";
				str_html += "<td>"+data.qst_idx+"</td>";
				str_html += "<td>"+data.qst_sbjt+"</td>";
				str_html += "<td>"+data.usr_id+"</td>";
				str_html += "<td>"+data.reg_date+"</td>";
				str_html += "</tr>";
			});
			
			str_html += "</tbody>";
			
			$("#rcnt_atcl_list").html(str_html);
		}
	});
}