$(document).ready(function(){
	Cunt_Prjt();
	Cnet_Prjt();
	Tot_Prcs();
	Cnet_Prjt_Change();
});

var cunt_prjt;

function Cunt_Prjt(){ // 최근 프로젝트
	
	$.ajax({
		method: "POST",
		url: "/cuntPrjt/check/read",
		success:function(list){
			var str_html = "<table class = 'cunt_prjt' border='1'>";
			str_html += "<thead><tr>";
			str_html += "<th>최근 프로젝트</th>";
			str_html += "</tr></thead>";
		
			str_html += "<tbody>";
			
			$.each(list, function(index, data){
				str_html += "<tr><td>";
				str_html += data.prjt_sbjt;
				str_html += "</td></tr>";
			});
			
			
			str_html += "</tbody> </table>";
			$("#cunt_list").html(str_html);
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

function Cnet_Prjt(){ // 담당 프로젝트
	
	$("#cnet_list_name").html("담당 프로젝트");
	
	$.ajax({
		method: "POST",
		url: "/cnetPrjt/check/read",
		success: function(list){
			var str_html = "<option value=''></option>";
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
				title: 'Web accessibility status',
				values:[end, tot-end-rmn, rmn],
				colorset: ['#2EB400', '#2BC8C9', "#666666"],
				fields: ['종료 이슈', '진행 이슈',  '남은 이슈'],
			},
			'donut_width' : 35,
			'core_circle_radius':50,
			'chartDiv': 'Nwagon',
			'chartType': 'donut',
			'chartSize': {width:700, height:400}
		};
	$("#Nwagon").html("");
	Nwagon.chart(options);	
}